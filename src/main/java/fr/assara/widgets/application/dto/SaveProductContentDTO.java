package fr.assara.widgets.application.dto;

import jakarta.persistence.Lob;

import java.util.UUID;

public record SaveProductContentDTO(UUID publicId, @Lob byte[] images, String fileContentType ) {
}
