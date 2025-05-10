package mythosforge.fable_minds.config.security.auhentication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mythosforge.fable_minds.config.security.auhentication.dto.GroqRequest;
import mythosforge.fable_minds.config.security.auhentication.dto.GroqResponse;
import mythosforge.fable_minds.config.security.auhentication.service.GroqService;

@RestController
@RequestMapping("/api/groq")
public class GroqController {

    private final GroqService groqService;

    @Autowired
    public GroqController(GroqService groqService) {
        this.groqService = groqService;
    }

    @PostMapping("/chat")
    public ResponseEntity<GroqResponse> chat(@RequestBody GroqRequest request) {
        String response = groqService.getChatResponse(request.getPrompt());
        return ResponseEntity.ok(new GroqResponse(response));
    }
}