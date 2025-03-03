package yym.svydovets.ai.chatBot.openAI.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import java.util.List;
import org.apache.commons.lang3.NotImplementedException;
import yym.svydovets.ai.chatBot.openAI.dto.Message;
import yym.svydovets.ai.chatBot.openAI.dto.Model;

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
        //  3. Create {@link HttpRequest}, don't forget to add api key and content type
        //  4. Collect and print 'data' to console.
        //  5. Return AI message with collected 'data' content.
        throw new NotImplementedException();
    }
}
