package something;
import java.util.Random;

public class map {
    private static int placeX;
    private static int placeY;
    private static int i;

    public static int wallCount = 15;
    public static int fireCount = 8;
    public static void room1() {
        Random r = new Random();

        /* make fog */
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
        /* make fire */
        for(i=0; i<fireCount; i++) {
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
        /* make walls */
        for(i=0; i<wallCount; i++) {
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

    
}
}
