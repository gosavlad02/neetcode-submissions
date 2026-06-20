class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix_arr = new int[n];
        prefix_arr[0] = nums[0];
        int[] suffix_arr = new int[n];
        suffix_arr[n - 1] = nums[n-1];

        for (int i = 1; i < n; i++) {
            prefix_arr[i] = prefix_arr[i - 1] * nums[i];
        }
        for (int i = n - 2; i >=0; i--) {
            suffix_arr[i] = suffix_arr[i + 1] * nums[i];
        }

        int[] res = new int[n];
        res[0] = 1 * suffix_arr[1];
        res[n - 1] = prefix_arr[n - 2] * 1;
        for (int i = 1; i < n - 1; i++) {
            res[i] = prefix_arr[i - 1] * suffix_arr[i + 1];
        }
       return res;
    }
} 