package bg.softuni.pathfinder.model.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {

    @NotNull
    @Size(min = 5,max = 20)
    private String username;

    @NotNull
    @Size(min = 5,max = 20)
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @Positive
    private int age;

    @NotNull
    @Size(min = 5,max = 20)
    private String password;

    @NotNull
    @Size(min = 5,max = 20)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
