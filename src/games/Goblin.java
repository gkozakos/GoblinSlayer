package games;

import java.util.Random;

public class Goblin {

    private static final int HOBGOBLIN = 1;
    private static final int GREEN_GOBLIN = 2;
    private int faction;
    private int guard;
    private int run;
    private double hp = 70;
    private int atk = 20;
    private int def = 10;

    public Goblin() {
        Random generator = new Random();
        faction = generator.nextInt(3) + 1;
        guard = generator.nextInt(3) + 1;
        run = generator.nextInt(3) + 1;
    }

    public String getGoblinType() {
        switch (faction) {
            case HOBGOBLIN:
                return "Hobgoblin";
            case GREEN_GOBLIN:
                return "Green Goblin";
            default:
                return "Goblin Attack Force";
        }
    }

    public int getFaction() {
        return faction;
    }

    public int getGuard() {
        return guard;
    }

    public int getRun() {
        return run;
    }

    public double getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return getHp() > 0;
    }
}
