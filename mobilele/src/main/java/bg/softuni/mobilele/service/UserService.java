package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER =  LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        UserEntity newUser = new UserEntity();

        newUser.setActive(true);
        newUser.setEmail(userRegisterDTO.getEmail());
        newUser.setFirstName(userRegisterDTO.getFirstName());
        newUser.setLastName(userRegisterDTO.getLastName());
        newUser.setPassword(userRegisterDTO.getPassword());

        newUser = userRepository.save(newUser);

        login(newUser);
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOtp = userRepository
                .findByEmail(userLoginDTO.getUsername());

        if (userOtp.isEmpty()) {
            LOGGER.info("User with not found. User name: {}",
                    userLoginDTO.getUsername());
            return false;
        }

        String rawPassword = userLoginDTO.getPassword();
        String encodedPassword = userOtp.get().getPassword();

        boolean success = passwordEncoder
                .matches(rawPassword, encodedPassword);

        if (success) {
            login(userOtp.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true);
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
