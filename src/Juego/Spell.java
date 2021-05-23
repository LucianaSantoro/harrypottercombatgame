package Juego;

public abstract class Spell {
    protected Integer requiredMagicPoints;
    protected Integer attack = 0;
    protected Integer heal = 0;
    protected Integer magicEnergy = 0;
    protected String name;

    public Spell() {
    }

    public Integer getRequiredMagicPoints() {
        return requiredMagicPoints;
    }

    public void setRequiredMagicPoints(Integer requiredMagicPoints) {
        this.requiredMagicPoints = requiredMagicPoints;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }

    public Integer getMagicEnergy() {
        return magicEnergy;
    }

    public void setMagicEnergy(Integer magicEnergy) {
        this.magicEnergy = magicEnergy;
    }

    public void setName(String name) {
        this.name = name;
    }
}
