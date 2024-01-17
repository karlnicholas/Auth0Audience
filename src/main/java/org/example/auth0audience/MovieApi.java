package org.example.auth0audience;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MovieApi {
    @GetMapping("movies")
    public List<String> getMovies() {
        return List.of("movie1", "movie2");
    }
}
