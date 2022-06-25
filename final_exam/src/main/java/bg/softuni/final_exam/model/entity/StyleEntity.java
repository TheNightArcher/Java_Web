package bg.softuni.final_exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "styles")
public class StyleEntity extends BaseEntity {


    @Column(nullable = false,unique = true)
    @Enumerated(value = EnumType.STRING)
    private StyleNameEnum styleName;

    @Column(columnDefinition = "TEXT")
    private String description;

    public StyleNameEnum getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleNameEnum styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
