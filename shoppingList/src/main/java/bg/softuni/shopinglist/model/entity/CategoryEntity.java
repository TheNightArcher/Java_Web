package bg.softuni.shopinglist.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    @Enumerated(value = EnumType.STRING)
    private CategoryNameEnum name;

    private String description;

    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
