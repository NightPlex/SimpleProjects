import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    ArrayList<Integer> numbers;
    
        System.out.println("Type exam scores, -1 completes: ");
    
    numbers = Grade.numbers(); 
    Course course = new Course(numbers);
    
        System.out.println("Grade distribution:");
    course.gradeDistribution();
    
        System.out.println("Acceptance percentage: " + course.acceptancePerc());
    
        
            
            
        
    }
        
        
}

