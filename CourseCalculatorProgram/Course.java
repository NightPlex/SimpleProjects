import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Course {
    
    private ArrayList<Integer> numbers;
    
    public Course (ArrayList<Integer> list) {
        this.numbers = list;
    }
    
    public void printStars(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("*");
        }
    }
    
    public void gradeDistribution() {
        
        for (int i = 5; i >= 0; i--) {
            int printStars = 0;
            System.out.print(i + ": ");
            
            for (int number : numbers) {
                if (number == i) {
                    printStars++;
                }
            }
            
            printStars(printStars);
            System.out.println();
        }
    }
    
    public double acceptancePerc() {
        int passed = 0;
        int allGrades = 0;
        for (int i : numbers) {
            if (i > 0) {
                passed++;
                allGrades++;
            }else {
                allGrades++;
            }
        }
        return (double)100*passed/allGrades;
    }
    
    
    
}
