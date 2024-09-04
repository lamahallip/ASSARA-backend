package fr.assara.widgets.application.vo;

import jakarta.validation.constraints.NotBlank;

public record ProductPriceVO(@NotBlank String value) {
}
