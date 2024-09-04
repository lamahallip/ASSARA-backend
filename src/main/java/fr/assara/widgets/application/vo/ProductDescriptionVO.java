package fr.assara.widgets.application.vo;

import jakarta.validation.constraints.NotBlank;

public record ProductDescriptionVO(@NotBlank String value) {
}
