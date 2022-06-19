package bg.softuni.coffeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String email;

    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
