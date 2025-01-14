package yym.svydovets.ai.chatBot.openAI;

import java.util.Scanner;
import yym.svydovets.ai.chatBot.openAI.client.OpenAIClient;
import yym.svydovets.ai.chatBot.openAI.dto.Conversation;
import yym.svydovets.ai.chatBot.openAI.dto.Message;
import yym.svydovets.ai.chatBot.openAI.dto.Model;
import yym.svydovets.ai.chatBot.openAI.dto.Role;
import yym.svydovets.ai.chatBot.openAI.utils.Constant;

public class Chat {

    public static void main(String[] args) {
        //TODO:
        // 1. Add {@link Scanner} for 'System.in'.
        try (var sc = new Scanner(System.in)) {
            // 2. Create instance of 'task.OpenAIClient' with model.
            final OpenAIClient client = new OpenAIClient(Model.GPT_4o_MINI, Constant.API_KEY, true);
            // 3. Create Conversation.
            Conversation conversation = new Conversation();
            // 4. Get System prompt from console or use default -> Constant#DEFAULT_SYSTEM_PROMPT
            // and add to conversation messages. <br>
            System.out.println("Type a prompt or leave it blank for the default one: ");
            final String prompt = sc.nextLine();
            setupConversationPrompt(prompt, conversation);
            // 5. Use `while` cycle, apply user message from console `scanner.nextLine()` and call openAiClient. <br>
            // 6. Apply 'Message' from openAiClient to conversation messages. <br>
            // 7. Don't forget to add 'exit' point from application via console.
            System.out.println("Ask me or type 'exit' to finish.");
            for (; ; ) {
                System.out.println(">>> ");
                String input = sc.nextLine();
                if ("exit".equals(input)) {
                    System.out.println("Bye!");
                    break;
                }
                conversation.getMessages().add(new Message(Role.USER, input));
                System.out.println("<<< ");
                addMessageToConversation(client, conversation);
                System.out.println();
            }
        }
    }

    private static void addMessageToConversation(OpenAIClient client, Conversation conversation) {
        try {
            final Message answer = client.streamResponseWithMessage(conversation.getMessages());
            conversation.getMessages().add(answer);
            System.out.println(answer.content());
        } catch (Exception e) {
            System.err.printf("Error: %s", e.getMessage());
        }
    }

    private static void setupConversationPrompt(String prompt, Conversation conversation) {
        if (prompt.isBlank()) {
            conversation.getMessages().add(new Message(Role.SYSTEM, Constant.DEFAULT_SYSTEM_PROMPT));
            System.out.printf("Using default system prompt: %s %n", Constant.DEFAULT_SYSTEM_PROMPT);
        } else {
            conversation.getMessages().add(new Message(Role.SYSTEM, prompt));
            System.out.printf("Using prompt: %s %n", prompt);
        }
    }

}
