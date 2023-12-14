package Backend;

import java.util.Random;

public class Monster extends Destructible {
    private static final double HP = 100.;
    private int strength;

    public Monster() {
        super(HP);
        // Force aléatoire du monstre entre 1 et 20
        Random random = new Random();
        this.strength = random.nextInt(20) + 1; // Génère une force entre 1 et 20
    }

    public int getStrength() {
        return strength;
    }
}
