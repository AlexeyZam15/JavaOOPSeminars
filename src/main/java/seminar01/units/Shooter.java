package seminar01.units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shooter extends BaseHero {

    protected int arrows;

    protected int accuracy;

    public Shooter(int hp, String name, boolean team, int armor, int[] damage, int arrows, int accuracy) {
        super(hp, name, team, armor, damage);
        this.arrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(BaseHero enemy) {
//        enemy.getDamage(damage[Random ]);
    }

    public void step(ArrayList<BaseHero> enemyTeam) {
        if (hp <= 0 || arrows <= 0) return;
        shoot(findClosestEnemy(enemyTeam));
    }
}
