class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();

        for (int num : nums) {
            numCount.merge(num, 1, (currVal, newVal) -> currVal + newVal);
        }
        for (int count : numCount.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}