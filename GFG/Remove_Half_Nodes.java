package GFG;

public class Remove_Half_Nodes {

    public static Node RemoveHalfNodes(Node root)
    {
        if(root == null) return null;

        if(root.left == null && root.right == null) return root;

        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);

        if(root.left == null) return root.right;

        if(root.right == null) return root.left;

        return root;
    }

}
