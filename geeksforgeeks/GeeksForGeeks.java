package geeksforgeeks;
import java.util.*;

public class GeeksForGeeks {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        Array a = new Array(sc.nextInt());
        
        a.setArray();
        a.getArray();
        a.menu();
    }   
}