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
    
    // Asynchronous/streaming method
    public Flux<String> askToDeepSeekAIWithStream(String question) {
        return chatClient.prompt(question).stream().content();
    }
}
