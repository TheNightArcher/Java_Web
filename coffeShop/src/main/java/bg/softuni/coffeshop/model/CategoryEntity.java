package bg.softuni.coffeshop.model;

import bg.softuni.coffeshop.model.dto.CategoryNameDTO;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "categories")
public class CategoryEntity extends BaseEntity {

    private CategoryNameDTO name;

    @Column(nullable = false)
    private int neededTime;

    public CategoryNameDTO getName() {
        return name;
    }

    public void setName(CategoryNameDTO name) {
        this.name = name;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }
}
