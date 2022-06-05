package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.LevelEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "routes")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String gpx;

    @Enumerated(value = EnumType.STRING)
    private LevelEnum levelEnum;

    @Column(nullable = false,unique = true)
    private String name;

    private String videoUrl;

    @ManyToOne
    private UserEntity author;

    @ManyToMany
    private List<CategoryEntity> categories = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGpx() {
        return gpx;
    }

    public void setGpx(String gpx) {
        this.gpx = gpx;
    }

    public LevelEnum getLevelEnum() {
        return levelEnum;
    }

    public void setLevelEnum(LevelEnum levelEnum) {
        this.levelEnum = levelEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
