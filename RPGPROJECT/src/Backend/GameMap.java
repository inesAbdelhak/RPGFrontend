package Backend;

public class GameMap {
	
	
    static final int[][] MAP_TEMPLATE_DEFAULT = {
            {2, 0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 0, 0},
            {1, 1, 1, 0, 1, 1, 1, 2},
    };
    
    
    private int playerX;
    private int playerY;

    // méthodes pour obtenir la position du joueur
    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    // méthodes pour déplacer le joueur
    public void movePlayerUp() {
        if (playerY > 0) {
            playerY--;
        }
    }

    public void movePlayerDown() {
        if (playerY < map.length - 1) {
            playerY++;
        }
    }

    public void movePlayerLeft() {
        if (playerX > 0) {
            playerX--;
        }
    }

    public void movePlayerRight() {
        if (playerX < map[0].length - 1) {
            playerX++;
        }
    }

    private int[][] map;

   
    public GameMap() {
        // valeur par défaut
        this(5, 5); 
    }


    public GameMap(int rows, int columns) {
        this.map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.map[i][j] = MAP_TEMPLATE_DEFAULT[i][j];
            }
        }
    }

    public int[][] getMap() {
        return this.map;
    }
}