package bg.softuni.battleships.model.binding;

import javax.validation.constraints.NotNull;

public class HomeBindingModel {

    @NotNull
    private Long attackerShip;

    @NotNull
    private Long defenderShip;

    public Long getAttackerShip() {
        return attackerShip;
    }

    public void setAttackerShip(Long attackerShip) {
        this.attackerShip = attackerShip;
    }

    public Long getDefenderShip() {
        return defenderShip;
    }

    public void setDefenderShip(Long defenderShip) {
        this.defenderShip = defenderShip;
    }
}
