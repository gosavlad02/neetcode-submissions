class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }

        if (uniqueSet.size() < nums.length) {
            return true;
        }
        return false;
    }
}