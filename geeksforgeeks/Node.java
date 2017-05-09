package geeksforgeeks;

public class Node {
    int key;
    int aux;
    Node leftChild;
    Node rightChild;
    
    public Node(int key, int aux){
        this.key = key;
        this.aux = aux;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public void showNode(){
        if(aux != Integer.MIN_VALUE){
            System.out.print("Key : " + key + " Aux : " + aux);
        }
        else
        System.out.print("Key : " + key);
    }
}
