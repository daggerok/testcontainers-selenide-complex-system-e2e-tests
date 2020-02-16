package testcontainers_selenide_maven_multi_boot;

import lombok.extern.java.Log;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Log
@Path("/items")
public class ItemsResource {

    @Inject
    @RestClient
    ItemsRestClient restClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Item> hello() {
        Collection<Item> items = restClient.getItems();
        log.info(items.toString());
        return items;
    }
}
