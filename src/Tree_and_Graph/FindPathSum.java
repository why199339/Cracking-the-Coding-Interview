package Tree_and_Graph;

public class FindPathSum {

	public static void main(String[] args) {

	}
	
	// O(NlogN), O(logN)
	public static void findPathSum(TreeNode root, int sum) {
		int depth = depth(root);
		int[] path = new int[depth];
		findSum(root, sum, path, 0);
	}

	private static void findSum(TreeNode root, int sum, int[] path, int level) {
		if (root == null) {
			return;
		}
		path[level] = root.val;
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				for (int j = i; j <= level; j++) {
					System.out.println(path[j]);
				}
			}
		}
		findSum(root.left, sum, path, level + 1);
		findSum(root.right, sum, path, level + 1);
		path[level] = Integer.MIN_VALUE;
	}

	private static int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
}
