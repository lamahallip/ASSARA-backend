package fr.assara.widgets.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product_content")
public class ProductContent implements Serializable {

    @Id
    @Column(name = "product_id")
    private Long Id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] images;

    @Column(name = "image_content_type", nullable = false)
    private String imageContentType;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
}
