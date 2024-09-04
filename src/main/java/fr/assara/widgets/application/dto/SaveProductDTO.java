package fr.assara.widgets.application.dto;

import fr.assara.widgets.application.vo.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record SaveProductDTO(@Valid ProductTitleVO productTitleVO,
                             @Valid ProductAuthorVO productAuthorVO,
                             @Valid ProductCategoryVO productCategoryVO,
                             @Valid ProductCityVO productCityVO,
                             @Valid ProductCountryVO productCountryVO,
                             @Valid ProductDescriptionVO productDescriptionVO,
                             @Valid ProductPriceVO productPriceVO,
                             @NotNull byte[] image,
                             @NotNull String imageContentType
                             ) {
}
