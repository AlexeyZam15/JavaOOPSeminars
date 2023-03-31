package seminar01.units;

import seminar01.Main;
import seminar01.Names;
import seminar01.weapons.Weapons;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
    protected static int count;

    protected boolean team;

    public String name;

    protected static int lastFirstTeamX = 0;
    protected static int lastFirstTeamY = 0;

    protected static int lastSecondTeamX = 9;
    protected static int lastSecondTeamY = 0;

    protected int x;
    protected int y;

    protected int hp;
    protected int max_hp;

    protected int armor;
    protected int[] damage;

    protected Weapons weapon;

    @Override
    public String toString() {
        return this.getInfo() + " " + this.name + " Здоровье: " + this.hp + " Броня: " + this.armor;
    }

    public String getPosition() {
        return "x: " + this.x + " y: " + this.y;
    }

    public BaseHero(int hp, String name, boolean team, int armor, int[] damage) {
        this.hp = hp;
        this.name = name;
        if (team) {
            this.x = lastFirstTeamX;
            this.y = lastFirstTeamY++;
        } else {
            this.x = lastSecondTeamX;
            this.y = lastSecondTeamY++;
        }
        this.armor = armor;
        this.damage = damage;
        count++;
    }

    protected int getInt() {
        return 1;
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return getClass().getSimpleName();
    }

    public static int getCount() {
        return count;
    }

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public BaseHero findClosestEnemy(ArrayList<BaseHero> enemyTeam) {
        BaseHero closestEnemy = enemyTeam.get(0);
        double distance = Math.sqrt(Math.pow(enemyTeam.get(0).x - this.x, 2) + Math.pow(enemyTeam.get(0).y - this.y, 2));
        double minDistance = distance;
        for (BaseHero enemy : enemyTeam) {
            if (enemy.hp <= 0) continue;
            distance = Math.sqrt(Math.pow(enemy.x - this.x, 2) + Math.pow(enemy.y - this.y, 2));
            if (minDistance > distance) {
                minDistance = distance;
                closestEnemy = enemy;
            }
        }
        return closestEnemy;
    }
    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }
}
