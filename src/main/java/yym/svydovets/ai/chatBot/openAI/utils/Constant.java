package yym.svydovets.ai.chatBot.openAI.utils;

import java.net.URI;

public final class Constant {
    private Constant() {}

    public static final int AI_RESPONSE_OFFSET = 6;
    public static final URI OPEN_AI_API_URI = URI.create("https://api.openai.com/v1/chat/completions");

    public static final String DEFAULT_SYSTEM_PROMPT = "You are an assistant who answers concisely and informatively.";

    public static final String API_KEY = ""; //todo insert apiKey here

}
