package seminar01;

import seminar01.units.BaseHero;

import java.util.Collections;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    private static void tabSetter(int cnt, int max) {
        int dif = max - cnt + 2;
        if (dif > 0) System.out.printf("%" + dif + "s", ":\t");
        else System.out.print(":\t");
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getChar(int x, int y) {
        String out = "| ";
//        System.out.println(BaseHero.getAllTeam().size());
        for (BaseHero human : BaseHero.getAllTeam()) {
            if (human.getCoords()[0] == x && human.getCoords()[1] == y) {
                if (human.getHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
//                System.out.println(BaseHero.getDarkTeam().contains(human) + " " + BaseHero.getHolyTeam().contains(human));
                if (BaseHero.getDarkTeam().contains(human))
                    out = "|" + (AnsiColors.ANSI_GREEN + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (BaseHero.getHolyTeam().contains(human))
                    out = "|" + (AnsiColors.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }

    public static void view() {
        Main.printHeader("Ход №" + step);
        step++;
        BaseHero.getAllTeam().forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
//        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print(AnsiColors.ANSI_BLUE + "Blue side" + AnsiColors.ANSI_RESET);
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0] - 10));
        System.out.println(AnsiColors.ANSI_GREEN + "\tGreen side" + AnsiColors.ANSI_RESET);
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(BaseHero.getHolyTeam().get(0));
        tabSetter(BaseHero.getHolyTeam().get(0).toString().length(), l[0]);
        System.out.println(BaseHero.getDarkTeam().get(0));
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(BaseHero.getHolyTeam().get(i - 1));
            tabSetter(BaseHero.getHolyTeam().get(i - 1).toString().length(), l[0]);
            System.out.println(BaseHero.getDarkTeam().get(i - 1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(BaseHero.getHolyTeam().get(9));
        tabSetter(BaseHero.getHolyTeam().get(9).toString().length(), l[0]);
        System.out.println(BaseHero.getDarkTeam().get(9));
        System.out.println(bottom10);
    }
}