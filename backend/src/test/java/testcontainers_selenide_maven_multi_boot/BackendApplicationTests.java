package testcontainers_selenide_maven_multi_boot;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.test.StepVerifier;
import testcontainers_selenide_maven_multi_boot.item.Item;
import testcontainers_selenide_maven_multi_boot.item.ItemRepository;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@SpringBootTest
@AllArgsConstructor(onConstructor_ = @Autowired)
class BackendApplicationTests {

    private final ItemRepository itemRepository;
    private final RouterFunction<ServerResponse> routes;

    @Test
    void testR2dbc() {
        StepVerifier.create(itemRepository.findAll())
                    .expectNextMatches(item -> item.getContent().equals("ololo") && item
                            .getId().equals(UUID.fromString("000000000000-0000-0000-0000-000000000")))
                    .expectNextMatches(item -> item.getContent().equals("trololo") && item
                            .getId().equals(UUID.fromString("000000000000-0000-0000-0000-000000001")))
                    .verifyComplete();
    }

    @Test
    void testWebflux() {
        WebTestClient restClient = WebTestClient.bindToRouterFunction(routes)
                                                .build();
        restClient.get()
                  .uri("/")
                  .accept(MediaType.APPLICATION_JSON)
                  .exchange()
                  .expectStatus().isOk()
                  .expectBody(new ParameterizedTypeReference<List<Item>>() {})
                  .consumeWith(result -> {
                      Iterable<Item> items = result.getResponseBody();
                      assertThat(items).hasSize(2);
                      Iterator<Item> iterator = items.iterator();
                      assertThat(iterator.next().getContent()).isEqualTo("ololo");
                      assertThat(iterator.next().getContent()).isEqualTo("trololo");
                  });
    }
}
