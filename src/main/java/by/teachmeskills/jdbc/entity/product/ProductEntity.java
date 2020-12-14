package by.teachmeskills.jdbc.entity.product;

import by.teachmeskills.jdbc.entity.Entity;

public class ProductEntity extends Entity {

    private String title;
    private String description;
    private double price;

    public ProductEntity(Long id, String title, String description, double price, Long timestamp) {
        super(id, timestamp);
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
