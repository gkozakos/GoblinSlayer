package games;

import java.util.Random;

public class Weapon {

    private int atk;
    public Weapon() {
        Random generator = new Random();
        this.atk= generator.nextInt(5)+1;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getAtk() {
        return atk;
    }
}
