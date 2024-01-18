package org.example.auth0audience;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class MovieApi {
    @GetMapping("movies")
    public List<String> getMovies(@RequestParam("user") String user) {
        if ("auth0|60770bd4cce08b006b0c496d".equalsIgnoreCase(user)) {
            return List.of("movie1", "movie2");
        }
        return Collections.emptyList();
    }
}
