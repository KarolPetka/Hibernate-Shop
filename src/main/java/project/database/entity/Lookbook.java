package project.database.entity;

import javax.persistence.*;

// TODO: - make mapping relation for product location id "productLocationId"

@Entity
@Table(name = "Lookbook")
public class Lookbook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private Integer priceInUSD;
    private Integer quantity;
    private String season;
    private String status;

    public Lookbook() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(Integer priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}