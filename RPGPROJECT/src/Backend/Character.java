package Backend;
import java.util.ArrayList;

public class Character {
    protected String name;
    protected int hp;
    protected int strength;
    protected ArrayList<Weapon> weapons;
    protected double money;

    
    public Character(String name, int hp, int strength) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.weapons = new ArrayList<>();
        this.money = 50;  // Montant initial
    }

  
    public Character() {
        // Initialisation des valeurs par défaut
        this.name = "DefaultName";
        this.hp = 100;
        this.strength = 10;
        this.weapons = new ArrayList<>();
        this.money = 50;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", HP: " + hp + ", Strength: " + strength;
    }
}