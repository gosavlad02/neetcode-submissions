class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> waitingTempsIdx = new ArrayDeque<>();
        int[] waitingTimes = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int current_temp = temperatures[i];
            while (!waitingTempsIdx.isEmpty() && current_temp > temperatures[waitingTempsIdx.peek()]) {
                int waitingTempIdx = waitingTempsIdx.pop();
                waitingTimes[waitingTempIdx] = i - waitingTempIdx;
            }
            waitingTempsIdx.push(i);
        }
        return waitingTimes;
    }
}
