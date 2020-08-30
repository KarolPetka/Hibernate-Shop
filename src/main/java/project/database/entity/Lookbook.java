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
    private String season;

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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }


    public String toStringClient() {
        return "ID= " + productId +
                " | NAME= " + name +
                " | PRICE= " + priceInUSD +
                " | SEASON= " + season;
    }
}