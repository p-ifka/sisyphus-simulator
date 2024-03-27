package something;
import java.util.Random;

public class map {
    private static int placeX;
    private static int placeY;
    private static int i;
    public static void room1() {
        Random r = new Random();
        for(int column = 0; column<main.SCREEN_HEIGHT; column++) {
            for(int row = 0; row<main.SCREEN_WIDTH; row++) {
                if(row <= main.areaDiscovered) {
                    main.screen[row][column] = main.BACKGROUND_CHAR;
                } else {
                    int index = r.nextInt(0, main.FOG_CHARS.length);
                    main.screen[row][column] = main.FOG_CHARS[index];
                }
            }
        }
        for(i=0; i<7; i++) {


            placeY = r.nextInt(0, main.SCREEN_HEIGHT-1);
            placeX = r.nextInt(0, main.SCREEN_WIDTH-1);
            // System.out.println("placed at: "+placeX+", "+placeY);
            if(main.screen[placeX][placeY] == '.') {
                main.screen[placeX][placeY] = main.FIRE_CHAR;
            } else{
                i--;
            }
        }
        i = 0;
        for(i=0; i<15; i++) {
            placeY = r.nextInt(0, main.SCREEN_HEIGHT-1);
            placeX = r.nextInt(0, main.SCREEN_WIDTH-1);
            // System.out.println("placed at: "+placeX+", "+placeY);
            if(main.screen[placeX][placeY] == main.BACKGROUND_CHAR) {
            main.screen[placeX][placeY] = 'Σ';
            } else{
                i--;
            }
    }
    i = 0;
    main.screen[4][0] = main.BOULDER_CHAR;

    
}
}
