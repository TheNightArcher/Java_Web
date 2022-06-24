package bg.softuni.musicdb.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    private String username;

    @NotNull
    @Size(min = 3, max = 20, message = "Full name length must be between 3 and 20 characters")
    private String fullName;

    @NotNull
    @Email(message = "Must be valid email")
    private String email;

    @NotNull
    @Size(min = 5, max = 20,message = "Password length must be between 5 and 20 characters")
    private String password;

    @NotNull
    @Size(min = 5, max = 20,message = "Password length must be between 5 and 20 characters")
    private String passwordConfirm;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
