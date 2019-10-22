package games;

import java.util.Random;

public class Artifact {
    private int hp;

    public Artifact() {
        Random generator = new Random();
        this.hp = generator.nextInt(5)+1;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
