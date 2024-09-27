package fr.assara.widgets.application.mapper;

import fr.assara.widgets.application.dto.ReadProductInfoDTO;
import fr.assara.widgets.application.dto.SaveProductDTO;
import fr.assara.widgets.application.vo.*;
import fr.assara.widgets.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "publicId", ignore = true)
    Product saveProductDTOToProduct(SaveProductDTO saveProductDTO);

    @Mapping(target = "favorite", ignore = true)
    ReadProductInfoDTO productToReadProductInfoDTO(Product product);

    default ProductAuthorVO stringProductAuthorVO(String author) {
        return new ProductAuthorVO(author);
    }

    default ProductTitleVO stringProductTitleVO(String title) {
        return new ProductTitleVO(title);
    }

    default ProductPriceVO stringProductPriceVO(String price) {
        return new ProductPriceVO(price);
    }

    default ProductDescriptionVO stringProductDescriptionVO(String description) {
        return new ProductDescriptionVO(description);
    }

    default ProductCountryVO stringProductCountryeVO(String country) {
        return new ProductCountryVO(country);
    }

    default ProductCityVO stringProductCityVO(String city) {
        return new ProductCityVO(city);
    }

    default ProductCategoryVO stringProductCategoryVO(String title) {
        return new ProductCategoryVO(title);
    }

    default String productAuthorVOToString(ProductAuthorVO authorVO) {
        return authorVO.value();
    }

    default String productTitleVOToString(ProductTitleVO titleVO) {
        return titleVO.value();
    }

    default String productPriceVOToString(ProductPriceVO priceVO) {
        return priceVO.value();
    }

    default String productDescriptionVOToString(ProductDescriptionVO descriptionVO) {
        return descriptionVO.value();
    }

    default String productCountryVOToString(ProductCountryVO countryVO) {
        return countryVO.value();
    }

    default String productCityVOToString(ProductCityVO cityVO) {
        return cityVO.value();
    }

    default String productCategoryVOToString(ProductCategoryVO categoryVO) {
        return categoryVO.value();
    }


}
