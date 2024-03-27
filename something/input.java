package something;
import java.util.Scanner;

public class input {
    public static char[] keys = {','};

public static void getKey(boolean doStuff) {
    Scanner sc = new Scanner(System.in);
    keys = sc.nextLine().toCharArray();
    if(doStuff == true){
        keyActions();
    }
}
public static void keyActions() {
    for(char c : keys) {
        if(c == 'w') {
            player.move('w');
        }
        if(c == 's') {
            player.move('s');
        }
        if(c == 'a') {
            player.move('a');
        }
        if(c == 'd') {
            player.move('d');
        }
    }
}
  
}