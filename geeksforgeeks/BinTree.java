package geeksforgeeks;
import java.util.Queue;
import java.util.LinkedList;

abstract public class BinTree {
    Node root;
    public BinTree(){
        root = null;
    }
    
    abstract public void addNode(int k, int a);
    abstract public void addNode(int k);
    abstract public Node findNode(int k);
    abstract public boolean removeNode(int k);
    
    public void inOrderTraverse(Node focus){
        if(focus != null){
            inOrderTraverse(focus.leftChild);
            focus.showNode();
            inOrderTraverse(focus.rightChild);
        }
    }
    
    public void preOrderTraverse(Node focus){
        if(focus != null){
            focus.showNode();
            preOrderTraverse(focus.leftChild);
            preOrderTraverse(focus.rightChild);
        }
    }
    
    public void postOrderTraverse(Node focus){
        if(focus != null){
            postOrderTraverse(focus.leftChild);
            postOrderTraverse(focus.rightChild);
            focus.showNode();
        }
    }
    
    public void layerTraverse(Node focus){
        Queue<Node> queue = new LinkedList<>();
        queue.add(focus);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            temp.showNode();
            if(temp.leftChild!=null)
                queue.add(temp.leftChild);
            if(temp.rightChild!=null)
                queue.add(temp.rightChild);
        }
    }
    
    public void inOrderTraverse(){
        preOrderTraverse(this.root);
    }
    
    public void preOrderTraverse(){
        preOrderTraverse(this.root);
    }
    
    public void postOrderTraverse(){
        preOrderTraverse(this.root);
    }
    
    public void layerTraverse(){
        preOrderTraverse(this.root);
    }
}
