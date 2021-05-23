package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Player {
    private String name;
    private Integer lifeLevel = 100;
    private Integer magicEnergy = 100;
    private List<Spell> spellList = new ArrayList<Spell>();
    private Integer chosenDefenseLocation;
    public Integer attackLocation;
    protected Integer location;

    @Override
    public String toString() {
        return name +
                "\n\t Tus puntos de vida: " + lifeLevel +
                "\n\t Tus puntos de energía mágica: " + magicEnergy +
                "\n";
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    Scanner keyboard = new Scanner(System.in);

    public Player() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLifeLevel() {
        return lifeLevel;
    }

    public void setLifeLevel(Integer lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    public Integer getMagicEnergy() {
        return magicEnergy;
    }

    public void setMagicEnergy(Integer magicEnergy) {
        this.magicEnergy = magicEnergy;
    }

    public void addSpell(Spell spell) {
        spellList.add(spell);
    }

    public List<DefenseSpell> getListDefenseSpell() {
        List<DefenseSpell> defenseSpells = new ArrayList<>();
        for (Spell spell : spellList) {
            if (spell instanceof DefenseSpell) {
                defenseSpells.add((DefenseSpell) spell);
            }
        }
        return defenseSpells;
    }

    public List<AttackSpell> getListAttackSpell() {
        List<AttackSpell> attackSpells = new ArrayList<>();
        for (Spell spell : spellList) {
            if (spell instanceof AttackSpell) {
                attackSpells.add((AttackSpell) spell);
            }
        }
        return attackSpells;
    }

    public List<EnergySpell> getListEnergySpell() {
        List<EnergySpell> energySpells = new ArrayList<>();
        for (Spell spell : spellList) {
            if (spell instanceof EnergySpell) {
                energySpells.add((EnergySpell) spell);
            }
        }
        return energySpells;
    }

    public Integer chosenDefenseLocation() {
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.println("Elegí dónde te defenderás del ataque de tu oponente:");
            System.out.println("\t1) El Bosque Prohibido.");
            System.out.println("\t2) El Gran Hall.");
            System.out.println("\t3) Las Mazmorras.");
            chosenDefenseLocation = keyboard.nextInt();

            switch (chosenDefenseLocation) {
                case 1:
                    chosenDefenseLocation = 1;
                    break;
                case 2:
                    chosenDefenseLocation = 2;
                    break;
                case 3:
                    chosenDefenseLocation = 3;
                    break;
                default:
                    chosenDefenseLocation = 0;
                    System.out.println("El número elegido es incorrecto, por favor volvé a elegir.");
                    break;
            }
        } while (chosenDefenseLocation == 0);

        return chosenDefenseLocation;
    }

    public Integer chosenAttackLocation() {
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.println("Elegí dónde atacarás: ");
            System.out.println("\t1) El Bosque Prohibido.");
            System.out.println("\t2) El Gran Hall.");
            System.out.println("\t3) Las Mazmorras.");
            attackLocation = keyboard.nextInt();

            switch (attackLocation) {
                case 1:
                    attackLocation = 1;
                    break;
                case 2:
                    attackLocation = 2;
                    break;
                case 3:
                    attackLocation = 3;
                    break;
                default:
                    attackLocation = 0;
                    System.out.println("El número elegido es incorrecto, por favor volvé a elegir.");
                    break;
            }
        } while (attackLocation == 0);


        return attackLocation;
    }

    public void printSpells() {
        System.out.println("Tus hechizos disponibles son: \n" + spellList);
    }

    public Boolean isFreeOrDark() {
        Boolean isFreeOrDark = null;
        int attackSpellQtty = 0;
        for (Spell spell : spellList) {
            if (spell instanceof AttackSpell) {
                attackSpellQtty++;
            }
        }
        if (attackSpellQtty > 3) {
            isFreeOrDark = true;
        } else {
            isFreeOrDark = false;
        }
        return isFreeOrDark;
    }

    protected void receiveAttack(Player opponent, Integer totalAttack, Integer location) {
        Integer currentLife = opponent.getLifeLevel();
        currentLife = currentLife - totalAttack;
        System.out.println("\nLa vida del oponente se redujo a " + currentLife + " puntos.\n");
        opponent.setLifeLevel(currentLife);
    }

    protected void executeEnergy(Player playerInTurn) {
        System.out.println("Seleccioná uno de tus hechizos de energía mágica:");
        List<EnergySpell> energySpell = playerInTurn.getListEnergySpell();
        Integer totalEnergy = 0;
        boolean aux = true;

        for (int i = 0; i < energySpell.size(); i++) {
            System.out.println((i + 1) + " ) " + playerInTurn.getListEnergySpell().get(i));
            System.out.println("");
            System.out.println("");
        }

        int chosenEnergySpell = keyboard.nextInt();
        chosenEnergySpell = chosenEnergySpell - 1;
        while (aux) {
            if (chosenEnergySpell < energySpell.size()) {
                EnergySpell localEnergySpell = playerInTurn.getListEnergySpell().get(chosenEnergySpell);
                if (localEnergySpell.getRequiredMagicPoints() < playerInTurn.getMagicEnergy()) {
                    if (playerInTurn instanceof Elf) {
                        Elf elf = (Elf) playerInTurn;
                        Integer baseSpellEnergy = localEnergySpell.getMagicEnergy();
                        if (elf.isFreeOrDark()) {
                            totalEnergy = baseSpellEnergy + 10;
                        } else {
                            totalEnergy = baseSpellEnergy + 5;
                        }
                    } else if (playerInTurn instanceof Wizard){
                        Wizard wizard = (Wizard) playerInTurn;
                        Integer baseSpellEnergy = localEnergySpell.getMagicEnergy();
                        if (wizard.isFreeOrDark()){
                            totalEnergy = baseSpellEnergy + 10;
                        } else {
                            totalEnergy = baseSpellEnergy;
                        }

                    }

                        if (playerInTurn.getMagicEnergy() + totalEnergy > 100) {
                        playerInTurn.setMagicEnergy(100);

                    } else {
                        playerInTurn.setMagicEnergy(playerInTurn.getMagicEnergy() + totalEnergy);

                    }

                } else {
                    System.out.println("Tu cantidad de energía mágica insuficiente. Perdés un turno y recuperás 10 puntos de energía.");
                    playerInTurn.setMagicEnergy(playerInTurn.getMagicEnergy() + 10);

                }
                System.out.println("Tu energía ahora es de : " + playerInTurn.getMagicEnergy() + " puntos.");
                aux = false;
            } else {
                System.out.println("Número incorrecto. Por favor volvé a elegir.");
            }
        }
    }

    protected void attack(Player playerInTurn, Player opponent) {
        System.out.println("Seleccioná uno de tus hechizos de ataque:");
        List<AttackSpell> attackSpell = playerInTurn.getListAttackSpell();
        Integer totalAttack = 0;

        for (int i = 0; i < attackSpell.size(); i++) {
            System.out.println((i + 1) + " ) " + playerInTurn.getListAttackSpell().get(i));
            System.out.println("");
            System.out.println("");
        }

        int chosenAttackSpell = keyboard.nextInt();
        chosenAttackSpell = chosenAttackSpell - 1;
        AttackSpell localAttackSpell = playerInTurn.getListAttackSpell().get(chosenAttackSpell);
        boolean aux = true;

        while (aux) {
            if (chosenAttackSpell < attackSpell.size()) {
                if (localAttackSpell.getRequiredMagicPoints() < playerInTurn.getMagicEnergy()) {
                    if (playerInTurn instanceof Wizard) {
                        Wizard wizard = (Wizard) playerInTurn;
                        Wand wand = wizard.getWand();
                        Integer extraWandAttack = wand.getDamagePointsAdded();
                        Integer baseSpellAttack = localAttackSpell.getAttack();
                        if (wizard.isFreeOrDark()) {
                            baseSpellAttack = baseSpellAttack + 10;
                        }
                        totalAttack = baseSpellAttack + extraWandAttack;

                    } else {
                        Elf elf = (Elf) playerInTurn;
                        Integer baseSpellAttack = localAttackSpell.getAttack();
                        if (elf.isFreeOrDark()) {
                            totalAttack = baseSpellAttack + 5;
                        } else {
                            totalAttack = baseSpellAttack;
                        }
                    }

                    System.out.println("¿A dónde vas a dirigir el ataque?\n");
                    Integer attackLocation = playerInTurn.chosenAttackLocation();

                    if (attackLocation == location) {
                        opponent.receiveAttack(opponent, totalAttack, location);
                        System.out.println("Ataque exitoso!!\n");
                    } else {
                        System.out.println("Tu ataque falló!\n");
                    }

                    playerInTurn.setMagicEnergy(playerInTurn.getMagicEnergy() - localAttackSpell.getRequiredMagicPoints());

                } else {
                    System.out.println("Cantidad de energía mágica insuficiente. Perdés un turno y ganás 10 puntos de energía.\n");
                    playerInTurn.setMagicEnergy(playerInTurn.getMagicEnergy() + 10);
                }
                aux = false;
            } else {
                System.out.println("Número incorrecto, por favor volvé a elegir.");
            }
        }
    }

    public void executeDefense(Player playerInTurn) {
        System.out.println("Seleccioná uno de tus hechizos de defensa:");
        List<DefenseSpell> defenseSpell = playerInTurn.getListDefenseSpell();
        Integer totalDefense = 0;
        for (int i = 0; i < defenseSpell.size(); i++) {
            System.out.println((i + 1) + " ) " + playerInTurn.getListDefenseSpell().get(i));
            System.out.println("");
            System.out.println("");
        }

        int chosenDefenseSpell = keyboard.nextInt();
        chosenDefenseSpell = chosenDefenseSpell - 1;
        DefenseSpell localDefenseSpell = playerInTurn.getListDefenseSpell().get(chosenDefenseSpell);
        boolean aux = true;

        while (aux) {
            if (chosenDefenseSpell < defenseSpell.size()) {

                if (localDefenseSpell.getRequiredMagicPoints() < playerInTurn.getMagicEnergy()) {
                    if (playerInTurn instanceof Wizard) {
                        Wizard wizard = (Wizard) playerInTurn;
                        Integer baseSpellDefense = localDefenseSpell.getHeal();
                        if (wizard.isFreeOrDark()) {
                            totalDefense = baseSpellDefense - 10;
                        } else {
                            totalDefense = baseSpellDefense;
                        }

                    } else {
                        Elf elf = (Elf) playerInTurn;
                        Integer baseSpellDefense = localDefenseSpell.getHeal();
                        if (elf.isFreeOrDark()) {
                            totalDefense = baseSpellDefense + 5;
                        } else {
                            totalDefense = totalDefense + 10;
                        }
                    }
                    if (playerInTurn.getLifeLevel() + totalDefense > 100) {
                        playerInTurn.setLifeLevel(100);
                    } else {
                        playerInTurn.setLifeLevel(playerInTurn.getLifeLevel() + totalDefense);
                    }
                    playerInTurn.setMagicEnergy(playerInTurn.getMagicEnergy() - localDefenseSpell.getRequiredMagicPoints());
                } else {
                    System.out.println("Cantidad de energía mágica insuficiente. Perdés un turno y ganás 10 puntos de energía.");
                    playerInTurn.setMagicEnergy(playerInTurn.getMagicEnergy() + 10);
                }

                System.out.printf("Ahora tenés %d puntos de vida ", playerInTurn.getLifeLevel());
                System.out.printf("y %d puntos de energía mágica!\n ", playerInTurn.getMagicEnergy());

                aux = false;
            } else {
                System.out.println("Número incorrecto. Por favor volvé a elegir. ");
            }
        }
    }

    public Boolean checkPlayersLife() {
        boolean isPlayerAlive = true;
        if (getLifeLevel() > 0) {
            isPlayerAlive = true;
        } else {
            isPlayerAlive = false;
        }
        return isPlayerAlive;
    }

}