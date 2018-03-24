class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i+=2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> etr: map.entrySet()) {
            if(etr.getValue() == 1) {
                return etr.getKey();
            }
        }
        return -1;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int val = 0;
        for(int i = 0; i < nums.length; i++) {
            val ^= nums[i];
        }
        return val;
    }
}
