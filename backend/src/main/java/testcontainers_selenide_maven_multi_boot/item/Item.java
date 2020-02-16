package testcontainers_selenide_maven_multi_boot.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Value
@Builder
@Table("items")
@JsonDeserialize(builder = Item.ItemBuilder.class)
public class Item {

    @Id
    private final UUID id;
    private final String content;

    public static Item of(String content) {
        return new Item(null, content);
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class ItemBuilder { }
}
