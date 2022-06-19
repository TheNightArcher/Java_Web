package bg.softuni.coffeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private CategoryEntity categoryEntity;

    @ManyToOne
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public void setEmployee(UserEntity employee) {
        this.employee = employee;
    }
}
