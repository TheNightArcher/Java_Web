package bg.softuni.pathfinder.model;

import javax.persistence.*;

@Entity(name = "pictures")
public class PictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Lob
    private String url;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }
}
