package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.UserRolesEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private UserRolesEnum role;


    @ManyToMany(targetEntity = UserEntity.class, mappedBy = "roles")
    private List<UserEntity> userEntity = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRolesEnum getRole() {
        return role;
    }

    public void setRole(UserRolesEnum role) {
        this.role = role;
    }

    public List<UserEntity> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(List<UserEntity> userEntity) {
        this.userEntity = userEntity;
    }
}
