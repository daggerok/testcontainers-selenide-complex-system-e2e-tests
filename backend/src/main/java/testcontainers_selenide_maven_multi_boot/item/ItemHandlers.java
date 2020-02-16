package testcontainers_selenide_maven_multi_boot.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;
import java.util.function.Function;

import static java.util.Collections.singletonMap;

@Log4j2
@Component
@RequiredArgsConstructor
public class ItemHandlers {

    private final ItemRepository itemRepository;

    public Mono<ServerResponse> fallback(ServerRequest request) {
        URI uri = request.uri();
        String baseUrl = String.format("%s://%s", uri.getScheme(), uri.getAuthority());
        Function<String, String> url = path -> String.format("%s%s", baseUrl, path);
        Map<String, String> api = singletonMap("all items GET", url.apply("/"));
        return ServerResponse.ok().body(Mono.just(api).doOnNext(log::info), Map.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(itemRepository.findAll().doOnNext(log::info), Item.class);
    }
}
