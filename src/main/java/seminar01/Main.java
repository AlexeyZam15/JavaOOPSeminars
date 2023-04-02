package seminar01;

import seminar01.teams.Team;
import seminar01.units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        ArrayList<BaseHero> heroes = rndClassesArrList();
//        heroes.forEach(n -> System.out.println(n));
//        System.out.println("_".repeat(40));
//        System.out.println("Всего персонажей: " + BaseHero.getCount());

//        if (heroes.get(0) instanceof Shooter) ((Shooter) heroes.get(0)).step();

//        heroes.forEach(n -> System.out.println(n.getInfo() + " " + n.name));

//        ArrayList<BaseHero> firstTeam = createTeam(true);

        Team<BaseHero> firstTeam = new Team<BaseHero>("Хаос", true, 10);

        Team<BaseHero> secondTeam = new Team<BaseHero>("Свет", false, 10);

//        ArrayList<BaseHero> secondTeam = createTeam(false);

        printHeader("Расположение");
        printHeader("Команда " + firstTeam.getTeamName());
        firstTeam.forEach(n -> System.out.println(n.getHeroName() + " " + n.getPosition()));
        printHeader("Команда " + secondTeam.getTeamName());
        secondTeam.forEach(n -> System.out.println(n.getHeroName() + " " + n.getPosition()));

        printHeader("Ходы");
//        firstTeam.forEach(n -> System.out.println(n.getInfo()));
        printHeader("Команда " + firstTeam.getTeamName());
        firstTeam.forEach(n -> n.step(secondTeam));
//        secondTeam.forEach(n -> System.out.println(n.getInfo()));
        printHeader("Команда " + secondTeam.getTeamName());
        secondTeam.forEach(n -> n.step(firstTeam));

//        System.out.println(firstTeam.get(1).findClosestEnemy(secondTeam));

    }

    public static void printHeader(String text){
        System.out.print("_".repeat(40) + "\n" + text + "\n" + "_".repeat(40) + "\n");
    }


    public static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

//    private static ArrayList<BaseHero> rndClassesArrList(){
//        ArrayList<BaseHero> heroes = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            int random = new Random().nextInt(6);
//            switch (random){
//                case 0: heroes.add(new Bowman(getName()));
//                break;
//                case 1: heroes.add(new Crossbowman(getName()));
//                break;
//                case 2: heroes.add(new Mage(getName()));
//                break;
//                case 3: heroes.add(new Monk(getName()));
//                break;
//                case 4: heroes.add(new Spearman(getName()));
//                break;
//                case 5: heroes.add(new Thief(getName()));
//                break;
//                default: heroes.add(new Peasant(getName()));
//            }
//        }
//        return heroes;
//    }


    public static ArrayList<BaseHero> createTeam(boolean firstTeam) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt(6);
            switch (random) {
                case 0:
                    heroes.add(new Bowman(getName(), firstTeam));
                    break;
                case 1:
                    heroes.add(new Crossbowman(getName(), firstTeam));
                    break;
                case 2:
                    heroes.add(new Mage(getName(), firstTeam));
                    break;
                case 3:
                    heroes.add(new Monk(getName(), firstTeam));
                    break;
                case 4:
                    heroes.add(new Spearman(getName(), firstTeam));
                    break;
                case 5:
                    heroes.add(new Thief(getName(), firstTeam));
                    break;
                default:
                    heroes.add(new Peasant(getName(), firstTeam));
            }
        }
        return heroes;
    }

}
