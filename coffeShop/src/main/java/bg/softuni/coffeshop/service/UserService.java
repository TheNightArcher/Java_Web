package bg.softuni.coffeshop.service;

import bg.softuni.coffeshop.model.UserEntity;
import bg.softuni.coffeshop.model.service.UserServiceModel;
import bg.softuni.coffeshop.model.view.UserViewModel;
import bg.softuni.coffeshop.repository.UserRepository;
import bg.softuni.coffeshop.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    public void loginUser(long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    public List<UserViewModel> findAllUserAndCountOrdersOrderByCountDesc() {
        return userRepository.findAllByOrdersDesc()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCountOfOrders(user.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
