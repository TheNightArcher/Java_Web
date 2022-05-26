package bg.softuni.mobilele.model.entity;

import javax.persistence.Entity;

@Entity(name = "brands")
public class BrandEntity extends BaseEntity{

    String name;
}
