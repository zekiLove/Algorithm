class Solution {
int secMin = -1;
	int min = 0;
	boolean flag = true;
	public int findSecondMinimumValue(TreeNode root) {
		min = root.val;
		if (root == null || root.left == null) {
			return -1;
		}
		getSecondMin(root);
		if (secMin == min) {
			return -1;
		}
		return secMin;
	}

	public void getSecondMin(TreeNode node) {
		if (node.left != null) {
			getSecondMin(node.left);
		}
		if (node.val != min) {
			if (flag) {
				secMin = node.val;
				flag = false;
			} else {
				secMin = Math.min(secMin, node.val);
			}
		}
		if (node.right != null) {
			getSecondMin(node.right);
		}
	}
}
