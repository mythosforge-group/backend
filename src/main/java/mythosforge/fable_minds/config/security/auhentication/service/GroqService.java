package mythosforge.fable_minds.config.security.auhentication.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GroqService {

    private final ChatClient chatClient;

    public GroqService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getChatResponse(String prompt) {
        return chatClient.call(prompt);
    }
}