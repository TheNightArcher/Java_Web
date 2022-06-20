package bg.softuni.coffeshop.service;

import bg.softuni.coffeshop.model.OrderEntity;
import bg.softuni.coffeshop.model.service.OrderServiceModel;
import bg.softuni.coffeshop.model.view.OrderViewModel;
import bg.softuni.coffeshop.repository.OrderRepository;
import bg.softuni.coffeshop.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper,
                        CurrentUser currentUser,
                        UserService userService,
                        CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity order = modelMapper.map(orderServiceModel, OrderEntity.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    public List<OrderViewModel> findAllOrdersByPriceDes() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    public void readyOrder(Long id) {

        orderRepository.deleteById(id);
    }
}
