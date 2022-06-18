package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserRegistrationDTO;
import bg.softuni.pathfinder.model.enums.LevelEnum;
import bg.softuni.pathfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public void registration(UserRegistrationDTO userRegistrationDTO) {

        UserEntity user = modelMapper
                .map(userRegistrationDTO, UserEntity.class);

        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);
    }

    public void login(UserLoginDTO userLoginDTO){


    }

}
