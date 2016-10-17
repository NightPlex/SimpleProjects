import java.util.Scanner;
import java.util.ArrayList;


public class Grade {
    
    public static ArrayList<Integer> numbers () {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        while(true) {
            int points = Integer.parseInt(input.nextLine());
            
            if (points == -1) {
                break;
            }
            
            if (points >= 0 && points <= 60) {
                if (points < 30) {
                numbers.add(0);
                }else if (points < 35 && points >29) {
                numbers.add(1);
                }else if (points < 40 && points >34) {
                numbers.add(2);
                }else if (points < 45 && points >39) {
                numbers.add(3);
                }else if (points < 50 && points >44) {
                numbers.add(4);
                }else if (points < 61 && points >49) {
                numbers.add(5);
                }
            }
            
        }
        
        return numbers;
    }
    
    
}
