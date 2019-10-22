package games;

public class Equipment {
    private Weapon weapon;
    private Shield shield;
    private Artifact artifact;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }

    public Equipment(Weapon weapon, Shield shield, Artifact artifact) {
        this.weapon = weapon;
        this.shield = shield;
        this.artifact = artifact;
    }
}
