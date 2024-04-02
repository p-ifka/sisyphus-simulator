package something;



public class player {
    public static int playerX = 0;
    public static int playerY = 0;

    public static void placePlayer() {
        main.screen[playerX][playerY] = main.PLAYER_CHAR;
    }

    public static void removePlayer() {
        main.screen[playerX][playerY] = main.BACKGROUND_CHAR;
    }

    public static void move(char direction) {
        try {

        if(direction == 'w'){
            interact(main.screen[playerX][playerY-1], 'w', playerX, playerY-1);
            if(playerY != 0 && main.screen[playerX][playerY-1] == main.BACKGROUND_CHAR) {
                removePlayer();
                playerY--;
            }

        } else if(direction == 's') {
            interact(main.screen[playerX][playerY+1], 's', playerX, playerY+1);
            if(playerY != 16 && main.screen[playerX][playerY+1] == main.BACKGROUND_CHAR) {
                removePlayer();
                playerY++;
            }
        } else if(direction == 'a') {
            interact(main.screen[playerX-1][playerY], 'a', playerX-1, playerY);
            if(main.screen[playerX-1][playerY] == main.BACKGROUND_CHAR) {
                removePlayer();
                playerX--;
            }
        } else if(direction == 'd') {
            interact(main.screen[playerX+1][playerY], 'd', playerX+1, playerY);
            if(main.screen[playerX+1][playerY] == main.BACKGROUND_CHAR) {
                removePlayer();
                playerX++;
            }
        }
    
    } catch(ArrayIndexOutOfBoundsException e) {
        main.die("you ran into a wall and died.");
    }
    }

    public static void interact(char object, char dir, int x, int y) {
        if(object == main.FIRE_CHAR) {
            main.die("fire");

        } else if(object == main.BOULDER_CHAR) {
            main.statusMessage = "";
            main.screen[x][y] = main.BACKGROUND_CHAR;
            if(dir == 'w') {
                main.screen[x][y-1] = main.BOULDER_CHAR;
            } else if(dir == 's') {
                main.screen[x][y+1] = main.BOULDER_CHAR;
            } else if(dir == 'a') {
                main.screen[x-1][y] = main.BOULDER_CHAR;
            } else if(dir == 'd') {
                main.screen[x+1][y] = main.BOULDER_CHAR;
            }


    }
    if(x == main.areaDiscovered-1) {
        if(object == main.BOULDER_CHAR) {
            main.discover();
        } else {
            main.statusMessage = "you must push the boulder (0) to continue";
        }
    }
}
}

