package bg.softuni.final_exam.service;

import bg.softuni.final_exam.model.entity.SongEntity;
import bg.softuni.final_exam.model.entity.UserEntity;
import bg.softuni.final_exam.model.service.UserServiceModel;
import bg.softuni.final_exam.model.view.MyPlayListViewModel;
import bg.softuni.final_exam.repository.UserRepository;
import bg.softuni.final_exam.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final SongService songService;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, SongService songService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.songService = songService;
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

    public void addToMyList(Long id) {

        Optional<UserEntity> findUser = userRepository.findById(currentUser.getId());
        UserEntity user = modelMapper.map(findUser, UserEntity.class);

        SongEntity song = songService.findSong(id);
        user.getPlayList().add(song);

        userRepository.save(user);
    }

    public List<MyPlayListViewModel> findUserSongs(Long id) {
        Optional<UserEntity> findUser = userRepository.findById(id);
        UserEntity user = modelMapper.map(findUser, UserEntity.class);

        return user.getPlayList()
                .stream()
                .map(u -> modelMapper.map(u, MyPlayListViewModel.class))
                .collect(Collectors.toList());
    }
}
