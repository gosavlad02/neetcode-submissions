class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // first we sort the array
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] > 0) {
                break;
            }
            int target = -nums[x];
            int left = x + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[x]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    if (!result.contains(triplet)) {
                        result.add(triplet);
                    }
                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}