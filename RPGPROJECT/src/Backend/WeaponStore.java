package Backend;

import java.util.ArrayList;

public class WeaponStore {

    private ArrayList<Weapon> weaponsList;

    public WeaponStore() {
        this.weaponsList = new ArrayList<>();
        this.weaponsList.add(new Bow());
        this.weaponsList.add(new Axe());
        this.weaponsList.add(new Hammer());
    }

    public void printWeaponsList() {
        System.out.println("Available weapons in the store :");
        int index = 0;
        for (Weapon w : this.weaponsList) {
            System.out.println("[" + index + "] " + w.toString() + "\n" + w.ascii_art());
            index++;
        }
    }

    public Weapon getWeapon(int index) {
        if (index >= 0 && index < weaponsList.size()) {
            return weaponsList.get(index);
        }
        return null;
    }

    public Weapon getWeaponByName(String name) {
        for (Weapon weapon : weaponsList) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null;
    }
}
