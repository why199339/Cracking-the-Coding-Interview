package Recursive_and_DynamicProgramming;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(getPermutations(nums));
	}

	public static ArrayList<ArrayList<Integer>> getPermutations(int[] nums) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private static void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int[] nums) {
		if (temp.size() == nums.length) {
			list.add(new ArrayList<>(temp));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (temp.contains(nums[i])) {
					continue;
				}
				temp.add(nums[i]);
				backtrack(list, temp, nums);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
