package Juego;

public class EnergySpell extends Spell {

    @Override
    public String toString() {
        return "\nENERGÍA MÁGICA:\n\t" +
                name +
                "\n\tEnergía mágica requerida: " + requiredMagicPoints +
                "\n\tEnergía mágica recuperada: " + magicEnergy +
                "\n ";
    }
}
