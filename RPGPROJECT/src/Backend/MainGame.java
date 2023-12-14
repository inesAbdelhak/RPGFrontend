package Backend;

import Frontend.GameUI;

public class MainGame {
    public static void main(String[] args) {
        WeaponStore weaponStore = new WeaponStore();
        GameMap gameMap = new GameMap();  
        GameUI gameUI = new GameUI(null, weaponStore, gameMap); 
        // Affiche l'interface graphique
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gameUI.setVisible(true);
            }
        });
    }
}
