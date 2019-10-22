package games;

import java.util.Scanner;

class GoblinChapter {
    // Slayer Choices
    private static final int ATTACK = 1;
    private static final int GUARD = 2;
    private static final int RUN = 3;

    // Battle Choices
    private static final int ENGAGE = 1;

    // Battle Outcomes
    private static final String VICTORY = "You have slained the goblin!";
    private static final String LOSS = "You lost loser!";

    private final Scanner scanner;
    private final Slayer slayer;
    private final Goblin goblin;

    GoblinChapter(Scanner scanner, Slayer slayer, Goblin goblin) {
        this.scanner = scanner;
        this.slayer = slayer;
        this.goblin = goblin;
        showGoblinBattle();
    }

    private void showGoblinBattle() {
        System.out.println("A wild goblin has appeared press\n" +
                "1) if you want to engage in battle \n" +
                "2) if you want to run ");
        slayer.selectNextMove(scanner);

        if (slayer.getNextMove() == ENGAGE) {
            showGoblinBattleOptions();
        } else {
            System.out.println("Game over!");
        }
    }

    private void showGoblinBattleOptions() {
        if (slayer.getFaction() == goblin.getFaction()) {
            play("You have the same type as the goblin", 1);

        } else if (slayer.getFaction() > goblin.getFaction()) {
            // TODO: MAKE THE FRACTION ADVANTAGE
            play("You have the advantage", 1.5);

        } else {// TODO: make the goblin advantage
            play("You have disadvantage", 0.5);
        }
    }

    private void play(String mode, double advantage) {
        showSlayerChoices(mode);
        boolean outcome = battle(advantage, mode);
        if (outcome)
            gameOver(VICTORY);
        else
            gameOver(LOSS);
    }

    private void gameOver(String result) {
        System.out.println(result);
        slayer.getLevel().setCurrentLevel(slayer.getLevel().getCurrentLevel()+1);
        System.out.println("You gained a level. Your level now is " + slayer.getLevel().getCurrentLevel());
    }

    private boolean battle(double advantage, String mode) {
        while (rulesAreOK()) {
            slayer.selectNextMove(scanner);
            switch (slayer.getNextMove()) {
                case ATTACK:
                    selectAttack(slayer, goblin, advantage);
                    break;
                case GUARD:
                    selectGuard(slayer, goblin, advantage);
                    break;
                case RUN:
                    selectRun(slayer, goblin, advantage);
                    break;
            }
            showSlayerChoices(mode);
        }

        return slayer.getHp() > 0;
    }

    private void showSlayerChoices(String mode) {
        System.out.println(mode + "\n" +
                " press " + ATTACK
                + " for attack \n press " + GUARD
                + " for guard \n press " + RUN
                + " to run");
    }

    private boolean rulesAreOK() {
        return slayer.getHp() > 0 && goblin.isAlive() && !slayer.getRun();
    }

    private void selectAttack(Slayer slayer, Goblin goblin, double advantage) {
        double damage = ((slayer.getAtk() * advantage) - goblin.getDef());
        goblin.setHp(goblin.getHp() - damage);
        System.out.println("You did " + damage + " damage to the goblin");
        System.out.println("Goblin's HP is " + goblin.getHp());
    }

    private void selectRun(Slayer slayer, Goblin goblin, double advantage) {
        slayer.generateRun();

        if (slayer.getRun() ) {
            System.out.println("You run away safely");
        } else {
            slayer.setHp((goblin.getAtk() * advantage) - slayer.getDef());
            System.out.println("Cant escape! \n Your remaining hp is: "
                    + slayer.getHp());
        }
    }

    private void selectGuard(Slayer slayer, Goblin goblin, double advantage) {
        slayer.generateGuard();
        if (slayer.getGuard() >= 2)
            System.out.println("Your guard was successful");
        else if (slayer.getGuard() == 1) {
            slayer.setHp((goblin.getAtk() * advantage) - slayer.getDef());
            System.out.println("Your guard was not successful \n Your remaining hp is: "
                    + slayer.getHp());
        }
    }
}
