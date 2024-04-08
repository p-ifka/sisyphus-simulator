package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

    /*CHARACTERS */
    public static final char BACKGROUND_CHAR = '.';
    public static final char PLAYER_CHAR = 'ඞ';
    public static final char FIRE_CHAR = '^';
    public static final char BOULDER_CHAR = '0';
    public static final char WALL_CHAR = 'Σ';
    public static final char[] FOG_CHARS = {'#', '$', '@', '%'};

    public static final int SCREEN_WIDTH = 64;
    public static final int SCREEN_HEIGHT = 16;
    public static int areaDiscovered = 9;
    public static boolean running = true;

    public static String statusMessage = "";
    public static double startTime = 0.0;

    public static char[][] screen = new char[SCREEN_WIDTH][SCREEN_HEIGHT];

    // public static char[][] screen = {    
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //    p {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    //     {BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR ,BACKGROUND_CHAR ,BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR, BACKGROUND_CHAR},
    // };
    public static void main(String[] args) {
        sound.init();
        clearScreen();
        System.out.println("sisyphus simulator 2024™");
        System.out.println("enter anything to start:");
        input.getKey(false);
        map.room1();
        player.placePlayer();
        startTime = System.currentTimeMillis();
        printSreen();

        while(running == true) {
        input.getKey(true); //get key, do stuff for key
        player.placePlayer(); // update player pos
        printSreen();

        }

    

    }

    public static void printSreen() {
        clearScreen();
        for(int column = 0; column<SCREEN_HEIGHT-1; column++) {
            for(int row = 0; row<SCREEN_WIDTH-1; row++) {
                System.out.print(screen[row][column]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("x:"+player.playerX+" y: "+player.playerY+" inputs: "+input.inputs);
        for(int i=0; i<map.boulderHealth; i++) {
            System.out.print("<3 ");
        }
        System.out.println(statusMessage);
    }

    public static void discover() {
        areaDiscovered = areaDiscovered+4;
        map.wallCount += 5;
        map.fireCount += 4;
        map.room1();
        player.placePlayer();
        screen[4][4] = main.BOULDER_CHAR;
        statusMessage = statusMessage+"\n the boulder rolled down the hill";
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void die(String deathMessage) {
        clearScreen();
        System.out.println(deathMessage);
        System.exit(0);
    }

    public static void end(){ // "end"
        clearScreen();
        double endTime = System.currentTimeMillis();
        double completionTime = Math.abs(endTime-startTime);
        System.out.println("the end?");
        System.out.println("game 'completed' in "+completionTime/1000+" s");
        System.out.println("and "+input.inputs+" inputs");
        saveScore(input.inputs);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sound.stop();
        main(null);


    }

    public static void saveScore(int newScore) {
        File file = new File("game/highscore");
        try (Scanner r = new Scanner(file)) {
            int currentScore = Integer.valueOf(r.nextLine());
            System.out.println(currentScore);

            if(newScore < currentScore) {
                FileWriter w = new FileWriter(file);
                w.write(String.valueOf(newScore)); 
                w.close();  
                System.out.println("highscore set");
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }


    }

}