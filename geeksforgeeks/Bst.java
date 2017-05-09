package geeksforgeeks;

public class Bst extends BinTree{
    
    @Override 
    public void addNode(int k, int a){
        Node newNode = new Node(k,a);
        
        if(root == null)
            root = newNode;
        else{
            Node focus = root;
            Node parent;
            while(Boolean.TRUE){
                parent = focus;
                if(k < focus.key){
                    focus = focus.leftChild;
                    if(focus == null){
                        parent.leftChild = newNode;
                        return;
                    }    
                }
                else{
                    focus = focus.rightChild;
                    if(focus == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    @Override
    public void addNode(int k){
        addNode(k,Integer.MIN_VALUE);
    }
    
    @Override
    @SuppressWarnings("null")
    public Node findNode(int k){
        Node focus = root;
        while(focus.key != k && focus != null){
            if(k < focus.key)
                focus = focus.leftChild;
            else
                focus = focus.rightChild;            
        }
        return focus;
    }
    
    @Override
    public boolean removeNode(int k){
        return Boolean.FALSE;
    }
}
