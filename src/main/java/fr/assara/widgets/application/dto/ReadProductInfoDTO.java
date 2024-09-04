package fr.assara.widgets.application.dto;

import fr.assara.widgets.application.vo.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ReadProductInfoDTO {

    private ProductTitleVO title;
    private ProductAuthorVO author;
    private ProductCategoryVO category;
    private ProductCountryVO country;
    private ProductCityVO city;
    private ProductDescriptionVO description;
    private ProductPriceVO price;

    @NotNull
    private byte[] images;

    @NotNull
    private String imageContentType;

    @NotNull
    private boolean isFavorite;

    @NotNull
    private UUID publicId;

    public ProductTitleVO getTitle() {
        return title;
    }

    public void setTitle(ProductTitleVO title) {
        this.title = title;
    }

    public ProductAuthorVO getAuthor() {
        return author;
    }

    public void setAuthor(ProductAuthorVO author) {
        this.author = author;
    }

    public ProductCategoryVO getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryVO category) {
        this.category = category;
    }

    public ProductCountryVO getCountry() {
        return country;
    }

    public void setCountry(ProductCountryVO country) {
        this.country = country;
    }

    public ProductCityVO getCity() {
        return city;
    }

    public void setCity(ProductCityVO city) {
        this.city = city;
    }

    public ProductDescriptionVO getDescription() {
        return description;
    }

    public void setDescription(ProductDescriptionVO description) {
        this.description = description;
    }

    public ProductPriceVO getPrice() {
        return price;
    }

    public void setPrice(ProductPriceVO price) {
        this.price = price;
    }

    @NotNull
    public byte[] getImages() {
        return images;
    }

    public void setImages(@NotNull byte[] images) {
        this.images = images;
    }

    public @NotNull String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(@NotNull String imageContentType) {
        this.imageContentType = imageContentType;
    }

    @NotNull
    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(@NotNull boolean favorite) {
        isFavorite = favorite;
    }

    public @NotNull UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(@NotNull UUID publicId) {
        this.publicId = publicId;
    }
}
