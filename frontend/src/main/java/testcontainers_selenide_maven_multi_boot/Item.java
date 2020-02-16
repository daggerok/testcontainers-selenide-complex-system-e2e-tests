package testcontainers_selenide_maven_multi_boot;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import java.util.UUID;

@Value
@Builder
@JsonDeserialize(builder = Item.ItemBuilder.class)
public class Item {

    private final UUID id;
    private final String content;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ItemBuilder { }
}
