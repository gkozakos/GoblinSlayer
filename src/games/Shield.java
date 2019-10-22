package games;

import java.util.Random;

public class Shield {
    private int def;

    public Shield() {
        Random generator = new Random();
        this.def= generator.nextInt(5)+1;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
