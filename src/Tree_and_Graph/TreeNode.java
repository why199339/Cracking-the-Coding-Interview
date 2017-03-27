package Tree_and_Graph;

public class TreeNode {
	int val;
	TreeNode parent;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return val + "";
	}
	
}
