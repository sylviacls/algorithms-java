public class TreeNode {
    private int value;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private int count;

    public TreeNode(int value) {
        this.value = value;
        this.count = 0;
    }

    /**
     * Insert a value in the node
     * @param value
     */
    public void insert(int value) {
        if(this.value == value) {
            this.count++;
        } else if (value < this.value ) {
            if(this.leftChild == null) {
                this.leftChild = new TreeNode(value);
            } else {
                this.leftChild.insert(value);
            }           
        } else {
            if(this.rightChild == null) {
                this.rightChild = new TreeNode(value);
            } else {
                this.rightChild.insert(value);
            }
        }
    }
    
    /**
     * To transverser In-Order we have to visit the leftChild first, then Node itself
     *  and then rightChild
     */
    public void traverseInOrder() {
        if(this.leftChild != null) {
            this.leftChild.traverseInOrder();
        }

        System.out.print(this.value + ", ");

        if(this.rightChild != null) {
            this.rightChild.traverseInOrder();
        }
    }

    /**
     * To transverser Pre-Order we have to visit the Node itself, then leftChild 
     *  and then rightChild
     */
    public void traversePreOrder() {

        System.out.print(this.value + ", ");

        if(this.leftChild != null) {
            this.leftChild.traversePreOrder();
        }

        if(this.rightChild != null) {
            this.rightChild.traversePreOrder();
        }
    }

    /**
     * To transverser Post-Order we have to visit the children first, 
     * leftChild, rightChild and then the Node
     */
    public void traversePostOrder() {
      
        if(this.leftChild != null) {
            this.leftChild.traversePostOrder();
        }

        if(this.rightChild != null) {
            this.rightChild.traversePostOrder();
        }

        System.out.print(this.value + ", ");
    }

    /**
     * Return the Node that has the value
     * @param value
     * @return
     */
    public TreeNode get(int value) {
        if(value == this.value) {
            return this;
        }
        if(value < this.value) {
            if(this.leftChild != null) {
                return this.leftChild.get(value);
            }
        } else {
            if(this.rightChild != null) {
                return this.rightChild.get(value);
            }
        }
        return null;
    }

    /**
     * To find the minimum value in a binary tree
     *  we have to traverse all way down to the left
     * @return the min value founded 
     */
    public int min() {
        if(this.leftChild == null) {
            return this.value;
        } else {
            return this.leftChild.min();
        }
    }

    /**
     * To find the max value in a binary tree
     *  we have to traverse all way down to the right
     * @return the max value founded 
     */
    public int max() {
        if(this.rightChild == null) {
            return this.value;
        } else {
            return this.rightChild.max();
        }
    }

    public int getValue() {
        return this.value;
    }

    public void setData(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode [value=" + value + "]";
    }
    
   
}