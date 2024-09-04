package fr.assara.widgets.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "favorite_product")
@IdClass(FavoriteId.class)
public class Favorite implements Serializable {

    @Id
    @Column(name = "user_email")
    private Long userEmail;

    @Id
    @Column(name = "product_public_id")
    private UUID productPublicId;

    public Long getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Long userEmail) {
        this.userEmail = userEmail;
    }

    public UUID getProductPublicId() {
        return productPublicId;
    }

    public void setProductPublicId(UUID productPublicId) {
        this.productPublicId = productPublicId;
    }
}
