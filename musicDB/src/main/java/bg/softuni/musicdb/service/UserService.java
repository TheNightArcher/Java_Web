package bg.softuni.musicdb.service;

import bg.softuni.musicdb.model.entity.UserEntity;
import bg.softuni.musicdb.model.service.UserServiceModel;
import bg.softuni.musicdb.repository.UserRepository;
import bg.softuni.musicdb.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);

        userRepository.save(user);
    }

    public UserServiceModel findUser(UserServiceModel userServiceModel) {

        return userRepository.findByUsernameAndPassword(userServiceModel.getUsername(), userServiceModel.getPassword())
                .map(u -> modelMapper.map(u, UserServiceModel.class))
                .orElse(null);
    }

    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    public UserEntity findFrom(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }
}
