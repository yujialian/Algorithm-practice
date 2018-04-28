class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }
        for(int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);
            ans.add(deque.getFirst());
            outQueue(deque, nums[i-k+1]);
        }
        int[] arr = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
    private void inQueue(Deque<Integer> deque, int num) {
        while(!deque.isEmpty() && deque.getLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }
    private void outQueue(Deque<Integer> deque, int num) {
        if(deque.getFirst() == num) {
            deque.pollFirst();
        }
    }
}
