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
        Node focus = root;
        Node parent = root;
        
        boolean isLeftChild = true;
        while(focus.key != k){
            parent = focus;
            if(focus.key < k){
                isLeftChild = true;
                focus = focus.leftChild;
            }    
            else{
                isLeftChild = false;
                focus = focus.rightChild;
            }
            if(focus == null)
                return false;
        }
        
        if(focus.leftChild == null && focus.rightChild == null){
            if(focus == root)
                root = null;
            else if(isLeftChild)
                parent.leftChild = null;
            else 
                parent.rightChild = null;
        }
        
        else if(focus.rightChild == null){
            if(focus == root)
                root = focus.leftChild;
            else if(isLeftChild)
                parent.leftChild = focus.leftChild;
            else 
                parent.rightChild = focus.leftChild;
        }
        
        else if(focus.leftChild == null){
            if(focus == root)
                root = focus.rightChild;
            else if(isLeftChild)
                parent.leftChild = focus.rightChild;
            else 
                parent.rightChild = focus.rightChild;
        }
        
        else{
            Node replace = getReplace(focus); 
            if(focus == root)
                root = replace;
            else if(isLeftChild)
                parent.leftChild = replace;
            else 
                parent.rightChild = replace;
            
            replace.leftChild = focus.leftChild;
        }
        return true;
    }
    
    private Node getReplace(Node replaceNode){
        Node replaceParent = replaceNode;
        Node replacement = replaceNode;
        
        Node focus = replaceNode.rightChild;
        while(focus != null){
            replaceParent = replacement;
            replacement = focus;
            focus = focus.leftChild;
        }
        if(replacement != replaceNode.rightChild){
            replaceParent.leftChild = replacement.rightChild;
            replacement.rightChild = replaceNode.rightChild;
        }
        return replacement;
    }
}
