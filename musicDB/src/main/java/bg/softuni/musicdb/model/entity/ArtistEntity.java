package bg.softuni.musicdb.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "artists")
public class ArtistEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String careerInformation;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ArtistNameEnum name;

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }

    public ArtistNameEnum getName() {
        return name;
    }

    public void setName(ArtistNameEnum name) {
        this.name = name;
    }
}
