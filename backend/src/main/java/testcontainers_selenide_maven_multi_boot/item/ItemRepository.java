package testcontainers_selenide_maven_multi_boot.item;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface ItemRepository extends R2dbcRepository<Item, UUID> { }
