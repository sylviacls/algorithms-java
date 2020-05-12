public class BinaryTree {

    private TreeNode root;

    /**
    * Inserts a value in the node
    * @param value
    */   
    public void insert(int value) {
        if(this.root == null) {
            this.root = new TreeNode(value);
        } else {
            this.root.insert(value);
        }
    }

    /**
     * Deletes a value from the Tree
     * @param value
     */
    public void delete(int value) {
        this.root = delete(root, value);
    }

    /**
     * 
     * @param root
     * @param value
     * @return the Node replaced
     */
    private TreeNode delete(TreeNode subRoot, int value) {

        if(subRoot == null) {
            return subRoot;
        }
        if(value < subRoot.getValue()) {
            subRoot.setLeftChild(delete(subRoot.getLeftChild(), value));
        } else if (value > subRoot.getValue()){
            subRoot.setRightChild(delete(subRoot.getRightChild(), value));
        } else {
            //When the node has 0 or 1 child
            if(subRoot.getLeftChild() == null) {
                return subRoot.getRightChild();
            } else if (subRoot.getRightChild() == null) {
                return subRoot.getLeftChild();
            }
            // Case 3: node to delete has 2 children
            // Replace the value in the root node with the smallest value
            // from the right subtree
            subRoot.setData(subRoot.getRightChild().min());
            // Delete the node that has the smallest value in the right subtree
            subRoot.setRightChild(delete(subRoot.getRightChild(), subRoot.getValue()));
        }

        return subRoot;
    }

    /**
     * To transverser In-Order we have to visit the leftChild first, then Node
     * itself and then rightChild
     */
    public void traverseInOrder() {
        if(this.root == null) {
            return;
        } else {
            this.root.traverseInOrder();
        }
    }
    /**
     * To transverser Pre-Order we have to visit the Node itself, then leftChild 
     *  and then rightChild
     */
    public void traversePreOrder() {
        if(this.root == null) {
            return;
        } else {
            this.root.traversePreOrder();
        }
    }

    /**
     * To transverser Post-Order we have to visit the children first, 
     * leftChild, rightChild and then the Node
     */
    public void traversePostOrder() {
        if(this.root == null) {
            return;
        } else {
            this.root.traversePostOrder();
        }
    }

    /**
     * To find the max value in a binary tree
     *  we have to traverse all way down to the right
     * @return the max value founded or Integer.MAX_VALUE
     */
    public int max() {
        if(this.root == null) {
            return Integer.MAX_VALUE;
        } else {
            return this.root.max();
        }
    }

     /**
     * To find the min value in a binary tree
     *  we have to traverse all way down to the left
     * @return the min value founded or Integer.MIN_VALUE
     */
    public int min() {
        if(this.root == null) {
            return Integer.MIN_VALUE;
        } else {
            return this.root.min();
        }
    }   
    public TreeNode get(int value) {
        if(this.root != null) {
            return this.root.get(value);
        }
        return null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        BinaryTree intTree = new BinaryTree();
	    intTree.insert(25);
	    intTree.insert(20);
	    intTree.insert(15);
	    intTree.insert(27);
	    intTree.insert(30);
	    intTree.insert(29);
	    intTree.insert(26);
	    intTree.insert(22);
	    intTree.insert(32);
        intTree.insert(17);
        System.out.println("In order:");
        intTree.traverseInOrder();
        System.out.println();
        System.out.println("Pre order:");
        intTree.traversePreOrder();
        System.out.println();
        System.out.println("Post order:");
        intTree.traversePostOrder();
        System.out.println();
        System.out.println(intTree.get(22));
        System.out.println(intTree.get(15));
        System.out.println(intTree.get(100));;
        System.out.println("Min value = " + intTree.min());
        System.out.println("Max value = " + intTree.max());
        int value = 22;
        System.out.println("Deleting " + value);
        intTree.delete(22);
        System.out.println("In order:");
        intTree.traverseInOrder();
    }

    
}