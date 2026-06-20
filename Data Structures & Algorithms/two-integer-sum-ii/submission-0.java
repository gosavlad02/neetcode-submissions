class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // left -> [1, 2, 3, 4] <- right
        // 1. left = 1
        /*    right = 4
              left + right = 5 > target (3)
              In this case, to decrease the sum, we do right--

              In the opposite case, we do left++, since we know that we need a bigger number
        */
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            else if(sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
