package yym.svydovets.ai.chatBot.openAI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AiResponse {

    private String id;
    private String object;
    private String model;
    private List<Choice> choices;

    public boolean hasContent() {
        if (choices != null) {
            final Choice choice = choices.get(0);
            if (choice.getDelta() != null) {
                return choice.getDelta().content != null
                        && !choice.getDelta().content.isBlank();
            }
        }
        return false;
    }

    public String getContent() {
        if (choices != null) {
            final Choice choice = choices.get(0);
            if (choice.getDelta() != null && choice.getDelta().content != null) {
                return choice.getDelta().content;
            }
        }
        return "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Choice {
        private Delta delta;
        private int index;
        private String finishReason;

        public Choice() {
        }

        public Choice(Delta delta, int index, String finishReason) {
            this.delta = delta;
            this.index = index;
            this.finishReason = finishReason;
        }

        public Delta getDelta() {
            return delta;
        }

        public void setDelta(Delta delta) {
            this.delta = delta;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getFinishReason() {
            return finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Delta(Role role, String content) {};

}
