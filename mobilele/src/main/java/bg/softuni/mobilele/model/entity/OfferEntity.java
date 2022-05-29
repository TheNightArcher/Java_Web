package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.entity.enums.EngineEnum;
import bg.softuni.mobilele.model.entity.enums.TransmissionEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "offers")
public class OfferEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(value = EnumType.STRING)
    private EngineEnum engine;

    private String imageUrl;

    private int mileage;

    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private TransmissionEnum transmission;

    // Year of the car
    private int year;

    private LocalDateTime created;

    private LocalDateTime modified;

}
