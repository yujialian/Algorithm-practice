class Solution {
    public int trap(int[] A) {
        if(A.length < 3) return 0;
        int ans = 0;
        int l = 0, r = A.length - 1;
        while(l < r && A[l] <= A[l + 1]) l++;
        while(l < r && A[r] <= A[r - 1]) r--;

        while(l < r) {
            int left = A[l];
            int right = A[r];
            if(left < right) {
                //Add volume until an edge larger than the left edge
                while(l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                while(l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }
}


class Solution {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        int index = 0;
        while(index < height.length) {
            if(stack.isEmpty() || height[stack.peek()] >= height[index]) {
                stack.push(index++);
            } else {
                int pot = stack.pop();
                water += stack.isEmpty() ? 0 : (Math.min(height[index], height[stack.peek()]) - height[pot]) * (index - stack.peek() - 1);
            }
        }
        return water;
    }
}
