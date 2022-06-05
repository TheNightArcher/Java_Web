package bg.softuni.pathfinder.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Lob
    private String textContext;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private UserEntity recipient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTextContext() {
        return textContext;
    }

    public void setTextContext(String textContext) {
        this.textContext = textContext;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public UserEntity getRecipient() {
        return recipient;
    }

    public void setRecipient(UserEntity recipient) {
        this.recipient = recipient;
    }
}
