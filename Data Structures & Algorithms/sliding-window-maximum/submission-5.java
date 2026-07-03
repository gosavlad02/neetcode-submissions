class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> windowMaxHeap = new PriorityQueue(Comparator.reverseOrder());
        List<Integer> maxPerWindow = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            windowMaxHeap.offer(nums[i]);
        }
        maxPerWindow.add(windowMaxHeap.peek());

        for (int left = 1; left + k <= nums.length; left++) {
            windowMaxHeap.remove(nums[left - 1]);
            windowMaxHeap.offer(nums[left + k - 1]);

            maxPerWindow.add(windowMaxHeap.peek());
        }

        return maxPerWindow.stream().mapToInt(Integer::intValue).toArray();
    }
}
