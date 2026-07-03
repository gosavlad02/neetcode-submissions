class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> decreasingDeque = new ArrayDeque<>();
        int[] output = new int[nums.length - k + 1];
        int l = 0, r = 0;

        while (r < nums.length) {
            while (!decreasingDeque.isEmpty() && nums[decreasingDeque.getLast()] < nums[r]) {
                decreasingDeque.removeLast();
            } // start from the right and remove until you find the correct spot
            decreasingDeque.addLast(r);

            if (l > decreasingDeque.getFirst()) {
                decreasingDeque.removeFirst();
            } //remove elements outside of our window

            if ((r + 1) >= k) {
                output[l] = nums[decreasingDeque.getFirst()];
                l++;
            } // if we are at the end, take the max and put it in the slot
            r++;
        }
        return output;
    }
}
