package testcontainers_selenide_maven_multi_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import testcontainers_selenide_maven_multi_boot.item.ItemHandlers;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class BackendApplication {

    @Bean
    RouterFunction<ServerResponse> routes(ItemHandlers handlers) {
        return route().nest(path("/"),
                            builder -> builder.GET("/",
                                                   handlers::getAll).build())
                      .build()
                      .andRoute(path("/**"),
                                handlers::fallback);
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
