package yym.svydovets.ai.chatBot.openAI.client;


import static yym.svydovets.ai.chatBot.openAI.utils.Constant.AI_RESPONSE_OFFSET;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Stream;
import yym.svydovets.ai.chatBot.openAI.dto.AiRequest;
import yym.svydovets.ai.chatBot.openAI.dto.AiResponse;
import yym.svydovets.ai.chatBot.openAI.dto.Message;
import yym.svydovets.ai.chatBot.openAI.dto.Model;
import yym.svydovets.ai.chatBot.openAI.dto.Role;
import yym.svydovets.ai.chatBot.openAI.utils.Constant;

/**
 * Client for communication with Open AI API
 */
public class OpenAIClient {

    private final ObjectMapper mapper;
    private final HttpClient httpClient;
    private final Model model;
    private final String apiKey;
    private final boolean streamResponse;

    public OpenAIClient(Model model, String apiKey) {
        this(model, apiKey, true);
    }

    public OpenAIClient(Model model, String apiKey, boolean streamResponse) {
        this.model = model;
        this.apiKey = checkApiKey(apiKey);
        this.streamResponse = streamResponse;
        this.mapper = new ObjectMapper();
        this.httpClient = HttpClient.newHttpClient();
    }

    private String checkApiKey(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("apiKey cannot be null or empty");
        }
        return apiKey;
    }

    /**
     * Goes to Open AI API, prints chunks with AI response to the console and returns Message with AI message.
     *
     * @param messages message history
     * @return AI message
     */
    public Message streamResponseWithMessage(List<Message> messages) throws Exception {
        // todo:
        //  1. Collect history and user request.
        //  2. Create request json body:
        final AiRequest request = new AiRequest();
        request.setModel(model.getValue());
        request.setMessages(messages);
        request.setStream(streamResponse);
        //  3. Create {@link HttpRequest}, don't forget to add api key and content type
        String jsonRequest = mapper.writeValueAsString(request);
        final HttpRequest httpRequest = HttpRequest.newBuilder(Constant.OPEN_AI_API_URI)
            .headers("Authorization", "Bearer " + apiKey, "Content-Type", "application/json")
            .POST(BodyPublishers.ofString(jsonRequest))
            .build();

        StringBuilder context = new StringBuilder();
        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofLines())
            .thenAccept(r -> handleContext(r.body(), context))
            .join();
        //  5. Collect and print 'data' to console.
        //  6. Return AI message with collected 'data' content.
        return new Message(Role.ASSISTANT, context.toString());
    }

    private void handleContext(Stream<String> body, StringBuilder context) {
        body.filter(data -> !data.isBlank())
            .filter(data -> !data.startsWith("data: [D"))
            .forEach(data -> parseResponse(context, data));
    }

    private void parseResponse(StringBuilder context, String data) {
        try {
            final String text = data.substring(AI_RESPONSE_OFFSET); // 6
            final AiResponse aiResponse = mapper.readValue(text, AiResponse.class);
            if (aiResponse != null && aiResponse.hasContent()) {
                final String content = aiResponse.getContent();
                context.append(content);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
