package org.example.auth0audience;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@Controller
public class IndexController {

    private final WebClient webClient;

    public IndexController(WebClient webClient) {
        this.webClient = webClient;
    }

    @RequestMapping("/")
    public String index(final Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            List<String> r = webClient.get().uri("movies")
                    .attributes(clientRegistrationId("auth0"))
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<String>>() {
                    }).block();
            model.addAttribute("movies", r);
        }
        return "index";
    }

}