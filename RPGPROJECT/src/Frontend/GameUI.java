package Frontend;

import Backend.*;
import Backend.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameUI extends JFrame implements KeyListener {

    private Player player;
    private WeaponStore weaponStore;
    private GameMap gameMap;
    private JTextField playerNameField;
    private JComboBox<String> characterComboBox;
    private JComboBox<String> weaponComboBox;
    private JLabel playerLabel; 
    private JLabel mapLabel;    // Label pour afficher la carte

    public GameUI(Player player, WeaponStore weaponStore, GameMap gameMap) {
        this.player = player;
        this.weaponStore = weaponStore;
        this.gameMap = gameMap;
        initialize();
        addKeyListener(this); 
    }

    private void initialize() {
        setTitle("Mini RPG Game");
        setSize(600, 400); // Ajuste la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création du panel principal avec un gestionnaire de disposition GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        setContentPane(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10); // Espacement autour des composants

        // Panel pour les informations du joueur et le bouton Play
        JPanel playerInfoPanel = new JPanel(new GridBagLayout());
        mainPanel.add(playerInfoPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblPlayerName = new JLabel("Choisir un nom :");
        playerInfoPanel.add(lblPlayerName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        playerNameField = new JTextField();
        playerNameField.setPreferredSize(new Dimension(150, 25));
        playerInfoPanel.add(playerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblEmpty1 = new JLabel(""); 
        playerInfoPanel.add(lblEmpty1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        String[] characters = {"Warrior", "Mage", "Archer"};
        characterComboBox = new JComboBox<>(characters);
        playerInfoPanel.add(characterComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        String[] weapons = {"Axe", "Bow", "Hammer"}; 
        weaponComboBox = new JComboBox<>(weapons);
        playerInfoPanel.add(weaponComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        playerInfoPanel.add(btnPlay, gbc);

       
        playerLabel = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(playerLabel, gbc);

        // Panel pour afficher la carte
        mapLabel = new JLabel();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        mainPanel.add(mapLabel, gbc);

        displayMap(); // Affiche la carte initiale
    }

  

    private void startGame() {
        String playerName = playerNameField.getText();
        String selectedCharacter = (String) characterComboBox.getSelectedItem();
        String selectedWeapon = (String) weaponComboBox.getSelectedItem();

        createPlayer(playerName, selectedCharacter, selectedWeapon);
        displayMap();
    }

    private void createPlayer(String playerName, String selectedCharacter, String selectedWeapon) {
      
        Character createdCharacter = null;

        switch (selectedCharacter) {
            case "Warrior":
                createdCharacter = new Warrior();
                break;
            case "Mage":
                createdCharacter = new Mage();
                break;
            case "Archer":
                createdCharacter = new archer();
                break;
            default:
                throw new IllegalArgumentException("Invalid character choice.");
        }

        // Passe l'objet WeaponStore à la classe Player
        player = new Player(playerName, createdCharacter);
        player.equipWeapon(selectedWeapon, weaponStore);

        System.out.println("Player created: " + player.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {

        displayMap(); 
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    private void displayMap() {
        // Obtiens la carte depuis la classe GameMap
        int[][] map = gameMap.getMap();

        
        JPanel mapPanel = new JPanel(new GridLayout(map.length, map[0].length));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                JLabel cellLabel = new JLabel();
                mapPanel.add(cellLabel);
            }
        }

    
        getContentPane().remove(mapLabel); 
        mapLabel = new JLabel(new ImageIcon(createMapImage(map))); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        getContentPane().add(mapLabel, gbc);

        //mise à jour de l'interface
        repaint();
    }

   
    private BufferedImage createMapImage(int[][] map) {
        int cellSize = 30; 
        BufferedImage image = new BufferedImage(map[0].length * cellSize, map.length * cellSize, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
            
            }
        }

        g.dispose();
        return image;
    }

    
    
    
}
