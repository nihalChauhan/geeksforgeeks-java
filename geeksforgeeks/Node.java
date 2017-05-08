package geeksforgeeks;

public class Node {
    int key;
    int aux;
    Node leftChild;
    Node rightChild;
    
    public Node(int key, int aux){
        this.key = key;
        this.aux = aux;
    }
    
    public Node(int key){
        this.key = key;
        this.aux = 0;
    }
}
