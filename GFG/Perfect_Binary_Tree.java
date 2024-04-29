package GFG;

public class Perfect_Binary_Tree {

    public boolean isPerfect(Node root){
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;

        int leftSubTree = height(root.left);
        int rightSubTree = height(root.right);

        if(leftSubTree != rightSubTree) return false;

        return checkPerfect(root);
    }

    private int height(Node root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private boolean checkPerfect(Node root) {
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;

        return isPerfect(root.left) && isPerfect(root.right);
    }

}
