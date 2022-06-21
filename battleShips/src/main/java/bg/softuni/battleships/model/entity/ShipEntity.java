package bg.softuni.battleships.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity(name = "ships")
public class ShipEntity extends BaseEntity {

    @Column(nullable = false)
    private LocalDate created;

    @Column(nullable = false)
    private Long health;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private Long power;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne
    private UserEntity user;

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
