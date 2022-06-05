package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.TravelingType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false,unique = true)
    private TravelingType name;

    @Lob
    private String description;

    @ManyToMany(targetEntity = RouteEntity.class, mappedBy = "categories")
    private List<RouteEntity> routeEntity = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TravelingType getName() {
        return name;
    }

    public void setName(TravelingType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
