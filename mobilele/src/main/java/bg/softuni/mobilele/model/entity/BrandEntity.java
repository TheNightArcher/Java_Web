package bg.softuni.mobilele.model.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "brands")
public class BrandEntity extends BaseEntity{

   private String name;

   private LocalDateTime created;

   private LocalDateTime modified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
