package Recursive_and_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class GetSubsets {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(getSubsets(nums));
	}

	public static ArrayList<ArrayList<Integer>> getSubsets(int[] nums) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		subsets(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void subsets(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int[] nums, int start) {
		list.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			subsets(list, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
