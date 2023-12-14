package Backend;

import java.util.ArrayList;

public class Player extends Character {

    private String name;
    private ArrayList<Weapon> weapons;
    private int money;

    public Player(String name, Character character) {
        super(character.getName(), character.getHp(), character.getStrength());
        this.name = name;
        this.weapons = new ArrayList<>();
        this.money = 50;  // Montant initial
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public void equipWeapon(String weaponName, WeaponStore weaponStore) {
        Weapon selectedWeapon = weaponStore.getWeaponByName(weaponName);
        this.weapons.add(selectedWeapon);
    }

    public void buyWeapon(Weapon weapon) {
        if (weapon.getPrice() <= this.money) {
            this.weapons.add(weapon);
            this.money -= weapon.getPrice();
            System.out.println("Weapon purchased: " + weapon.getName());
        } else {
            System.out.println("Not enough money to buy the weapon: " + weapon.getName());
        }
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", weapons=" + weapons + ", money=" + money + "]";
    }
}
