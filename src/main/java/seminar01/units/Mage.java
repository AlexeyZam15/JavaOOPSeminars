package seminar01.units;

import seminar01.Spells;

import java.util.ArrayList;

public class Mage extends BaseHero {
    protected int mana;

    protected ArrayList<Spells> spells_book;

    public Mage(String name) {
        super(100, name, 1, 6, 15, new int[]{3, 5}, "Маг");
        mana = 100;
//        spells_book.add(new Spells("Фаербол"));
//        spells_book.add(new Spells("Увеличение брони"));
//        spells_book.add(new Spells("Увеличение урона"));
    }


}
