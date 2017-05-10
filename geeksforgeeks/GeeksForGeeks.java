package geeksforgeeks;
import java.util.*;

public class GeeksForGeeks {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        /*System.out.print("Enter number of elements : ");
        Array a = new Array(sc.nextInt());
        
        a.setArray();
        a.menu();*/
        Bst b = new Bst();
        b.addNode(5);
        b.addNode(2);
        b.addNode(1);
        b.addNode(3);
        b.addNode(6);
        b.addNode(7);
        b.addNode(8);
        b.addNode(9);
        b.addNode(10);
        b.layerTraverse(b.root);
    }   
}