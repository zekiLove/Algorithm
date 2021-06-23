class Solution {
    TreeNode newRoot = new TreeNode();
    TreeNode temp = newRoot;
    public TreeNode increasingBST(TreeNode root) {
        order(root);
        return newRoot.right;
    }

    public void order(TreeNode node){
        if(node.left!=null){
            order(node.left);
        }
        
        TreeNode next = new TreeNode();
        next.val=node.val;
        temp.right=next;
        temp=next;
        
        if(node.right!=null){
            order(node.right);
        }

    }
}
