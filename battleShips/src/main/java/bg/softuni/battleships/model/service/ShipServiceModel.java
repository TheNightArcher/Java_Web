package bg.softuni.battleships.model.service;

import bg.softuni.battleships.model.entity.CategoryNameEnum;
import bg.softuni.battleships.model.entity.UserEntity;

import java.time.LocalDate;

public class ShipServiceModel {

    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private CategoryNameEnum category;
    private UserEntity user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
