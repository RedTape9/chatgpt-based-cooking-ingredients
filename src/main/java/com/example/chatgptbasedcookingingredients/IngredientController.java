package com.example.chatgptbasedcookingingredients;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final WebClient webClient;

    @PostMapping(value = "/categorize", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> categorizeIngredient(@RequestBody String ingredient) {
        return webClient.post()
                .bodyValue(new ChatGPTRequest("Ist die Zutat:" + ingredient + " vegan, vegetarian oder regular?" ))
                .retrieve()
                .bodyToMono(ChatGPTResponse.class)
                .map(ChatGPTResponse::text);
    }
}



