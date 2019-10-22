package games;

public class Level {
    private int currentLevel;

    public Level() {
        this.currentLevel = 1;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
