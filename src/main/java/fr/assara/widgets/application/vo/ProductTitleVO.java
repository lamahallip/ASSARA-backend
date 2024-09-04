package fr.assara.widgets.application.vo;

import jakarta.validation.constraints.NotBlank;

public record ProductTitleVO(@NotBlank String value) {
}
