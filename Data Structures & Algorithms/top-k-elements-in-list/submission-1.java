class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.merge(num, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        
        int[] res = new int[k];
        int cnt = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Integer> bucket = buckets.get(i);
            for (int num : bucket) {
                if (cnt == k) break;
                res[cnt] = num;
                cnt++;
            }
        }
        return res;
    }
}

