package yym.svydovets.ai.chatBot.openAI.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Contains <b>id</b> (UUID) and list of <b>messages</b>
 */
public class Conversation {
    private UUID id;
    private List<Message> messages;

    public Conversation(UUID id, List<Message> messages) {
        this.id = id;
        this.messages = messages;
    }

    public Conversation() {
        id = UUID.randomUUID();
        messages = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
