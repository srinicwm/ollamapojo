package com.westmarine.ollamapojo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DeepSeekAIService {
    private final ChatClient chatClient;
    
    public DeepSeekAIService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    
    // Synchronous method
    public String askToDeepSeekAI(String request) {
        return chatClient.prompt(request).call().content();
    }
    
    // Asynchronous/streaming method for getting quick response
    public Flux<String> askToDeepSeekAIWithStream(String question) {
        Flux<String> fluxContent = chatClient.prompt(question).stream().content();
        return fluxContent;
    }
}
