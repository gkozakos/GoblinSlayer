package games;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Slayer slayer = new Slayer(
                40,
                20,
                100,
                new Equipment(new Weapon(), new Shield(), new Artifact()),
                new Level()
        );
        slayer.selectFaction(scanner);
        GoblinChapter chapter = new GoblinChapter(scanner, slayer, new Goblin());

    }
}
