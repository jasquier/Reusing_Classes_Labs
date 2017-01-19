package squier.john.reusingClasses;

/**
 * Created by johnsquier on 1/18/17.
 */
public class Product {
    private Double price;
    private String productID;
    private Integer quantityOnHand;

    public Product(Double price, String productID, Integer quantityOnHand) {
        this.price = price;
        this.productID = productID;
        this.quantityOnHand = quantityOnHand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
}
