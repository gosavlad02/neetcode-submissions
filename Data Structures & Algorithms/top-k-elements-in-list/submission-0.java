class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.merge(num, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        Queue<Frequency> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(new Frequency(entry.getKey(), entry.getValue()));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().value;
        }
        return res;
    }
}

class Frequency {
    public int value;
    public int count;

    public Frequency(int value, int count) {
        this.value = value;
        this.count = count;
    }
}
