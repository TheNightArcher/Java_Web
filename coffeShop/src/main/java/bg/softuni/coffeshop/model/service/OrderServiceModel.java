package bg.softuni.coffeshop.model.service;

import bg.softuni.coffeshop.model.CategoryNameEnum;
import bg.softuni.coffeshop.model.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {

    private String description;
    private String name;
    private LocalDateTime orderTime;
    private BigDecimal price;
    private CategoryNameEnum category;
    private UserEntity employee;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
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

    public UserEntity getEmployee() {
        return employee;
    }

    public void setEmployee(UserEntity employee) {
        this.employee = employee;
    }
}
