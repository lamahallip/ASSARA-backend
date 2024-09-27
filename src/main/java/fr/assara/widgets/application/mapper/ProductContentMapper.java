package fr.assara.widgets.application.mapper;

import fr.assara.widgets.application.dto.ProductContentDTO;
import fr.assara.widgets.application.dto.SaveProductDTO;
import fr.assara.widgets.models.ProductContent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductContentMapper {

    @Mapping(source="product.publicId", target = "publicId")
    ProductContentDTO productContentToProductContentDTO(ProductContent productContent);

    ProductContent saveProductDTOToProduct(SaveProductDTO productDTO);
}
