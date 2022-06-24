package bg.softuni.shopinglist.model.view;

import bg.softuni.shopinglist.model.entity.CategoryNameEnum;

import java.math.BigDecimal;

public class ProductViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryNameEnum category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
