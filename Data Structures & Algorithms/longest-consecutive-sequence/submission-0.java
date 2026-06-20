class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            if (!numSet.contains(start - 1)) {
                int curr = start;
                int current_sequence_length = 1;
                while (numSet.contains(curr + 1)) {
                    curr++;
                    current_sequence_length++;
                }
                longest = Math.max(longest, current_sequence_length);
            } // this is the start of a sequence
        }
        return longest;
    }
}
