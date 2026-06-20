class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] {0,1};
        }

        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complements.containsKey(complement)) {
                int[] ans = new int[] {i, complements.get(complement)};
                Arrays.sort(ans);
                return ans;
            }
            complements.putIfAbsent(nums[i], i);
        }
        System.out.println(complements);
        return null;
    }
}
