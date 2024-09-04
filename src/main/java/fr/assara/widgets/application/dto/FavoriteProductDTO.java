package fr.assara.widgets.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FavoriteProductDTO(@NotNull boolean Favorite,
                                 @NotNull UUID publicId) {
}
