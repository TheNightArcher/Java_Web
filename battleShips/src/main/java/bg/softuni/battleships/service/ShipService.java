package bg.softuni.battleships.service;

import bg.softuni.battleships.model.entity.ShipEntity;
import bg.softuni.battleships.model.service.ShipServiceModel;
import bg.softuni.battleships.repository.ShipRepository;
import bg.softuni.battleships.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    public void addShip(ShipServiceModel shipServiceModel) {
        ShipEntity shipEntity = modelMapper.map(shipServiceModel, ShipEntity.class);

        shipEntity.setUser(userService.findById(currentUser.getId()));
        shipEntity.setCategory(categoryService.findByCategoryEnum(shipServiceModel.getCategory()));

        shipRepository.save(shipEntity);
    }
}
