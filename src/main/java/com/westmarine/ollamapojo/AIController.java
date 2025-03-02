package com.westmarine.ollamapojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AIController {
    private static final Logger LOG = LoggerFactory.getLogger(AIController.class);
    
    private final DeepSeekAIService deepSeekAIModel;
    
    public AIController(DeepSeekAIService deepSeekAIModel) {
        this.deepSeekAIModel = deepSeekAIModel;
    }
    
    @GetMapping("/prompt")
    public String askFromAI(@RequestParam(value = "question") String question) {
        try {
            return deepSeekAIModel.askToDeepSeekAI(question);
        } catch (Exception e) {
            LOG.error("There is an error with deep seek AI. Please try again later", e);
            return "Error occurred while processing the request";
        }
    }
    
    @GetMapping("/promptAsync")
    public Flux<String> askFromAIAsync(@RequestParam(value = "question") String question) {
        return deepSeekAIModel.askToDeepSeekAIWithStream(question);
    }
}
