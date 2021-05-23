package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player playerOne;
    private Player playerTwo;

    Scanner keyboard = new Scanner(System.in);

    public void printGameName() {
        System.out.println(
                "\n" +
                        "                                                                                                                     \n" +
                        "        88                                          88888888ba                                                       \n" +
                        "        88                                          88      \"8b               ,d       ,d                            \n" +
                        "        88                                          88      ,8P               88       88                            \n" +
                        "        88  ,adPPYYba,  8b       d8  ,adPPYYba,     88aaaaaa8P'  ,adPPYba,  MM88MMM  MM88MMM  ,adPPYba,  8b,dPPYba,  \n" +
                        "        88  \"\"     `Y8  `8b     d8'  \"\"     `Y8     88\"\"\"\"\"\"'   a8\"     \"8a   88       88    a8P_____88  88P'   \"Y8  \n" +
                        "        88  ,adPPPPP88   `8b   d8'   ,adPPPPP88     88          8b       d8   88       88    8PP\"\"\"\"\"\"\"  88          \n" +
                        "88,   ,d88  88,    ,88    `8b,d8'    88,    ,88     88          \"8a,   ,a8\"   88,      88,   \"8b,   ,aa  88          \n" +
                        " \"Y8888P\"   `\"8bbdP\"Y8      \"8\"      `\"8bbdP\"Y8     88           `\"YbbdP\"'    \"Y888    \"Y888  `\"Ybbd8\"'  88          \n" +
                        "                                                                                                                     \n" +
                        "                                                                                                                     \n"
        );

        System.out.println("\n" +
                "        ___               __   __   __             ___          ___  __  \n" +
                "\\ /    |__  |       |    /  \\ /  \\ |__)    | |\\ | |__  | |\\ | |  |  /  \\ \n" +
                " |     |___ |___    |___ \\__/ \\__/ |       | | \\| |    | | \\| |  |  \\__/ \n" +
                "                                                                         \n");

        System.out.println("*****           Por Lati Colombo y Lu Santoro          *****");

    };

    public void choosePlayer(Scanner keyboard) {
        System.out.println("\n\n\n" + "SELECCIÓN DE JUGADOR 1");
        playerOne = selectPlayerType(keyboard);
        selectSpellToPlayer(playerOne, keyboard);
        System.out.println("SELECCIÓN DE JUGADOR 2");
        playerTwo = selectPlayerType(keyboard);
        selectSpellToPlayer(playerTwo, keyboard);
    }

    public Player selectPlayerType(Scanner keyboard) {
        System.out.println("¿Qué tipo de personaje serás?");
        System.out.println("\n\t1) Mago\n\t2) Elfo");
        Player player = null;
        int choose = keyboard.nextInt();
        switch (choose) {
            case 1:
                player = selectWizard();
                break;
            case 2:
                player = selectElf();
                break;
            default:
                player = null;
                System.out.println("Debes elegir una opción válida");
        }

        return player;

    }

    public Player selectElf() {
        Elf elf = new Elf();
        String aux = null;
        List<String> elfNames = new ArrayList<String>();
        do {
            System.out.println("Seleccioná un Elfo de la lista: ");
            System.out.println("\t1) Dobby");
            System.out.println("\t2) Kreacher");
            System.out.println("\t3) Hokey");
            System.out.println("\t4) Winky");

            int option = keyboard.nextInt();
            switch (option) {
                case 1:
                    elf.setName("Dobby");
                    elfNames.add("Dobby");
                    aux = "aux";
                    break;
                case 2:
                    elf.setName("Kreacher");
                    elfNames.add("Kreacher");
                    aux = "aux";
                    break;
                case 3:
                    elf.setName("Hokey");
                    elfNames.add("Hokey");
                    aux = "aux";
                    break;
                case 4:
                    elf.setName("Winky");
                    elfNames.add("Winky");
                    aux = "aux";
                    break;
                default:
                    aux = null;
                    System.out.println("Debes elegir un número del 1 al 4");
                    break;
            }

        } while (aux == null);
        return elf;
    }

    public Player selectWizard() {
        Wizard wizard = new Wizard();
        String aux = null;
        List<String> wizardNames = new ArrayList<String>();
        do {
            System.out.println("Seleccione un mago de la lista: ");
            System.out.println("\t1) Harry Potter");
            System.out.println("\t2) Lord Voldemort");
            System.out.println("\t3) Luna Lovegood");
            System.out.println("\t4) Albus Dumbledore");
            System.out.println("\t5) Bellatrix Lestrange");

            int option = keyboard.nextInt();
            switch (option) {
                case 1:
                    wizard.setName("Harry Potter");
                    wizardNames.add("Harry Potter");
                    aux = "aux";
                    break;
                case 2:
                    wizard.setName("Lord Voldemort");
                    wizardNames.add("Lord Voldemort");
                    aux = "aux";
                    break;
                case 3:
                    wizard.setName("Luna Lovegood");
                    wizardNames.add("Luna Lovegood");
                    aux = "aux";
                    break;
                case 4:
                    wizard.setName("Albus Dumbledore");
                    wizardNames.add("Albus Dumbledore");
                    aux = "aux";
                    break;
                case 5:
                    wizard.setName("Bellatrix Lestrange");
                    wizardNames.add("Bellatrix Lestrange");
                    aux = "aux";
                    break;
                default:
                    wizard = null;
                    System.out.println("Debes elegir un número del 1 al 5");

            }

        } while (aux == null);

        Wand wand = getRandomWand();
        wizard.setWand(wand);

        return wizard;
    }

    public Wand getRandomWand() {
        Random wand = new Random();
        //lógica para seleccionar de una lista las varitas
        List<Wand> wands = new ArrayList<>();
        wands.add(new Wand("CEREZO", 2)); // Neville
        wands.add(new Wand("CIPRÉS", 4)); // Remus
        wands.add(new Wand("ROBLE", 0)); // Hagrid
        wands.add(new Wand("SAUCE", 3)); // Ron
        wands.add(new Wand("ABETO", 4)); // Minerva
        wands.add(new Wand("SAUCO", 5)); // Albus

        int index = wand.nextInt(wands.size());

        System.out.println("La varita elige al mago. Las varitas disponibles son: \n" + wands);

        System.out.printf("\n <<< <<< LA VARITA QUE TE ELIGIÓ ES:  %s   >>> >>> \n\n\n", wands.get(index).getWandName());
        return wands.get(index); //acá estoy retornando la varita
    }

    public void selectSpellToPlayer(Player player, Scanner keyboard) {
        int continueMenu = 0;
        int spellCount = 0;
        do {
            System.out.println("Elegí el tipo de hechizo que querés agregarte: \n\t1) Ataque \n\t2) Defensa \n\t3) Energía Mágica");
            int option = keyboard.nextInt(); // capturo la elección del usuario

            switch (option) {
                case 1:
                    AttackSpell attackSpell = getAttackSpellItem(keyboard); // llamo al método y le paso el teclado para el ingreso
                    if (attackSpell != null)
                        player.addSpell(attackSpell);
                    spellCount = spellCount + 1;
                    break;
                case 2:
                    DefenseSpell defenseSpell = getDefenseSpellItem(keyboard);
                    if (defenseSpell != null)
                        player.addSpell(defenseSpell);
                    spellCount = spellCount + 1;
                    break;
                case 3:
                    EnergySpell energySpell = getEnergySpellItem(keyboard);
                    if (energySpell != null)
                        player.addSpell(energySpell);
                    spellCount = spellCount + 1;
                    break;
                default:
                    System.out.println("Debes elegir un número entre el 1 y el 3");

            }
            System.out.println("Querés agregar otro hechizo?\n\t1) Sí\n\t2) No");
            continueMenu = keyboard.nextInt(); // capturo la elección del usuario
            if (continueMenu != 1 && continueMenu != 2) {
                System.out.println("Debes elegir 1 ó 2");
                continueMenu = 1;
            }

        } while (continueMenu == 1 && spellCount < 7);
    }

    public AttackSpell getAttackSpellItem(Scanner keyboard) {
        System.out.println("Elegí uno de los siguientes hechizos de ataque:");
        System.out.println("\t1) Avada Kedavra: ataque 100 - consumo de energía mágica 90");
        System.out.println("\t2) Imperius: ataque 90 - consumo de energía mágica 80");
        System.out.println("\t3) Crucio: ataque 80 - consumo de energía mágica 70");
        System.out.println("\t4) Petrificus Totalus: ataque 17 - consumo de energía mágica 9");
        System.out.println("\t5) Experliarmus: ataque 25 - consumo de energía mágica 15");
        System.out.println("\t6) Reducto: ataque 10 - consumo de energía mágica 5");

        AttackSpell attackSpell = new AttackSpell();

        int option = keyboard.nextInt();

        switch (option) {
            case 1:
                attackSpell.setName("Avada Kedavra");
                attackSpell.setAttack(100);
                attackSpell.setRequiredMagicPoints(90);
                break;
            case 2:
                attackSpell.setName("Imperius");
                attackSpell.setAttack(90);
                attackSpell.setRequiredMagicPoints(80);
                break;
            case 3:
                attackSpell.setName("Crucio");
                attackSpell.setAttack(80);
                attackSpell.setRequiredMagicPoints(70);
                break;
            case 4:
                attackSpell.setName("Petrificus Totalus");
                attackSpell.setAttack(17);
                attackSpell.setRequiredMagicPoints(9);
                break;
            case 5:
                attackSpell.setName("Expeliarmus");
                attackSpell.setAttack(25);
                attackSpell.setRequiredMagicPoints(15);
                break;
            case 6:
                attackSpell.setName("Reducto");
                attackSpell.setAttack(10);
                attackSpell.setRequiredMagicPoints(5);
                break;
            default:
                System.out.println("El número selecciondo es incorrecto.");
                attackSpell = null;
        }
        return attackSpell;
    }

    public DefenseSpell getDefenseSpellItem(Scanner keyboard) {
        System.out.println("Elige uno de los siguientes hechizos de curación/defensa:");
        System.out.println("\t1) Ossio Dispersimus: sanación: 20 - energía mágica requerida: 15");
        System.out.println("\t2) Repartifors: sanación: 15 - energía mágica requerida: 18");
        System.out.println("\t3) Ferula: sanación: 10 - energía mágica requerida: 5");
        System.out.println("\t4) Rennervate: sanación: 5 - energía mágica requerida: 1");


        DefenseSpell defenseSpell = new DefenseSpell();

        int option = keyboard.nextInt();

        switch (option) {
            case 1:
                defenseSpell.setName("Ossio Dispersimus");
                defenseSpell.setHeal(20);
                defenseSpell.setRequiredMagicPoints(15);
                break;
            case 2:
                defenseSpell.setName("Repartifors");
                defenseSpell.setHeal(15);
                defenseSpell.setRequiredMagicPoints(8);
                break;
            case 3:
                defenseSpell.setName("Ferula");
                defenseSpell.setHeal(10);
                defenseSpell.setRequiredMagicPoints(5);
                break;
            case 4:
                defenseSpell.setName("Rennervate");
                defenseSpell.setHeal(5);
                defenseSpell.setRequiredMagicPoints(1);
                break;
            default:
                System.out.println("El número elegido es incorrecto.");
                defenseSpell = null;

        }
        return defenseSpell;
    }

    public EnergySpell getEnergySpellItem(Scanner keyboard) {
        System.out.println("Elige uno de los siguientes hechizos: ");
        System.out.println("\t1) Salvio Hexia: energía mágica recuperada 15");
        System.out.println("\t2) Protego: energía mágica recuperada 14");
        System.out.println("\t3) Episkey: energía mágica recuperada 13");

        EnergySpell energySpell = new EnergySpell();

        int option = keyboard.nextInt();

        switch (option) {
            case 1:
                energySpell.setName("Salvio Hexia");
                energySpell.setMagicEnergy(15);
                energySpell.setRequiredMagicPoints(0);
                break;
            case 2:
                energySpell.setName("Protego");
                energySpell.setMagicEnergy(14);
                energySpell.setRequiredMagicPoints(0);
                break;
            case 3:
                energySpell.setName("Episkey");
                energySpell.setMagicEnergy(13);
                energySpell.setRequiredMagicPoints(0);
                break;
            default:
                System.out.println("El número elegido es incorrecto.");
                energySpell = null;
        }
        return energySpell;
    }

    public void startFight() {
        System.out.println("Jugador 1:\n ");
        playerOne.setLocation(playerTwo.chosenDefenseLocation());

        System.out.println("Jugador 2:\n ");
        playerTwo.setLocation(playerTwo.chosenDefenseLocation());

        do {
            Integer totalAttack = 0;

            System.out.println("\n             <<<<  TURNO DEL JUGADOR 1:  >>>>\n");
            System.out.println(playerOne.toString());
            changeTurn(playerOne, playerTwo, totalAttack, playerTwo.getLocation());
            if (!playerTwo.checkPlayersLife()) break;

            System.out.println("\n            <<<<  TURNO DEL JUGADOR 2:  >>>>\n");
            System.out.println(playerTwo.toString());
            changeTurn(playerTwo, playerOne, totalAttack, playerOne.getLocation());

        } while (playerOne.checkPlayersLife() && playerTwo.checkPlayersLife());
        checkWinner();
        printWinner();
    }

    public void changeTurn(Player playerInTurn, Player opponent, Integer totalAttack, Integer location) {
        int chosenSpellType;

        playerInTurn.printSpells();
        do {

            System.out.println("Elegí qué tipo de hechizo vas a utilizar:");
            System.out.println("\t1) Ataque");
            System.out.println("\t2) Defensa - sanación");
            System.out.println("\t3) Recarga de energía mágica");
            chosenSpellType = keyboard.nextInt();

            typeOfSpellSwitch:
            switch (chosenSpellType) {

                case 1:
                    playerInTurn.attack(playerInTurn, opponent);
                    System.out.println(playerInTurn.chosenDefenseLocation());
                    break;
                case 2:
                    playerInTurn.executeDefense(playerInTurn);
                    System.out.println(playerInTurn.chosenDefenseLocation());
                    break;
                case 3:
                    playerInTurn.executeEnergy(playerInTurn);
                    System.out.println(playerInTurn.chosenDefenseLocation());
                    break;
                default:
                    chosenSpellType = 0;
                    System.out.println("Número incorrecto. Por favor, elegí nuevamente.");
            }
        } while (chosenSpellType == 0);
    }

    public Player checkWinner() {
        Player winner = null;
        if (playerOne.getLifeLevel() > 0) {
            winner = playerOne;
        } else {
            winner = playerTwo;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("El ganador es " + checkWinner().toString() + "!!!");
    }

}
