package bg.softuni.battleships.service;

import bg.softuni.battleships.model.binding.HomeBindingModel;
import bg.softuni.battleships.model.entity.ShipEntity;
import bg.softuni.battleships.model.service.ShipServiceModel;
import bg.softuni.battleships.model.view.UserShipView;
import bg.softuni.battleships.repository.ShipRepository;
import bg.softuni.battleships.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UserShipView> findShipsById(Long id) {
        return shipRepository.findAllByUserId(id)
                .stream().map(s -> modelMapper.map(s, UserShipView.class))
                .collect(Collectors.toList());
    }

    public List<UserShipView> findShipsOfOthers(Long id) {
        return shipRepository.findAllByUserIdNot(id)
                .stream().map(s -> modelMapper.map(s, UserShipView.class))
                .collect(Collectors.toList());
    }

    public List<UserShipView> findAll() {
        return shipRepository.findAllShipsOrderByDesc()
                .stream().map(s -> modelMapper.map(s, UserShipView.class))
                .collect(Collectors.toList());
    }

    public void fight(HomeBindingModel homeBindingModel) {

        Optional<ShipEntity> attacker = shipRepository.findById(homeBindingModel.getAttackerShip());
        Optional<ShipEntity> defender = shipRepository.findById(homeBindingModel.getDefenderShip());

        UserShipView userShipAttacker = modelMapper.map(attacker, UserShipView.class);
        UserShipView otherUsersShipsDefenders = modelMapper.map(defender, UserShipView.class);

        long defenderHp = otherUsersShipsDefenders.getHealth() - userShipAttacker.getPower();

        if (defenderHp <= 0) {
            shipRepository.deleteById(homeBindingModel.getDefenderShip());
        } else {
            otherUsersShipsDefenders.setHealth(defenderHp);
            modelMapper.map(otherUsersShipsDefenders, ShipEntity.class);
        }

    }
}
