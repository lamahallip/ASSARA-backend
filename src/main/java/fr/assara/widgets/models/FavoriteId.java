package fr.assara.widgets.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class FavoriteId implements Serializable {

    UUID productPublicId;

    String userEmail;

    public FavoriteId() {

    }

    public FavoriteId(UUID productPublicId, String userEmail) {
        this.productPublicId = productPublicId;
        this.userEmail = userEmail;
    }

    public UUID getProductPublicId() {
        return productPublicId;
    }

    public void setProductPublicId(UUID productPublicId) {
        this.productPublicId = productPublicId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteId that = (FavoriteId) o;
        return Objects.equals(productPublicId, that.productPublicId) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPublicId, userEmail);
    }
}
