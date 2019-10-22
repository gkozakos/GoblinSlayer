package games;

import java.util.Random;
import java.util.Scanner;

public class Slayer {
    private final Equipment equipment;

    public Level getLevel() {
        return level;
    }

    private final Level level;
    private int faction;
    private int atk;
    private int def;
    private int guard;
    private boolean run;

    public Slayer(int atk, int def, double hp, Equipment equipment, Level level) {
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.equipment = equipment;
        this.level = level;
    }

    public boolean getRun() {
        return run;
    }

    public int getGuard() {
        return guard;
    }

    public int getAtk() {
        if (equipment.getWeapon() == null){
            return atk;
        }
        return atk + equipment.getWeapon().getAtk();
    }

    public int getDef() {
        if (equipment.getShield()== null) {
            return def;
        }
        return def + equipment.getShield().getDef();
    }

    public double getHp() {
        if (equipment.getArtifact() == null) {
            return hp;
        }
        return hp + equipment.getArtifact().getHp();
    }

    private double hp = 100;

    public int getNextMove() {
        return nextMove;
    }

    private int nextMove;

    public void selectFaction(Scanner scanner) {
        System.out.println("Hello...In this game you can choose a character class and slay some goblins \n " +
                "Some goblins will be vulnerable to your attacks and some others will be resistant to them! \n" +
                "Press the number to choose the Fraction that you like: \n " +
                "1) Warlock \n 2) Assassin \n 3) Monk ");
        faction = scanner.nextInt();
        switch (faction) {
            case 1:
                System.out.println("You are now a warlock\n");
                break;
            case 2:
                System.out.println("You are now an assassin\n");
                break;
            case 3:
                System.out.println("You are now a monk\n");
                break;
        }
    }

    public int getFaction() {
        return faction;
    }

    public void selectNextMove(Scanner scanner) {
        nextMove = scanner.nextInt();
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void generateGuard() {
        Random generator = new Random();
        guard = generator.nextInt(4) + 1;
    }

    public void generateRun() {
        Random generator = new Random();
        run = generator.nextInt(4) + 1 > 1;
    }

}

