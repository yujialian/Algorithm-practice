class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> i, Map.Entry<Integer, Integer> j) {
                return i.getValue() - j.getValue();
            }
        }
        );
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: pq) {
            ans.add(0, entry.getKey());
        }
        return ans;
    }
}

//Bucket sort
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && ans.size() < k; i--) {
            if(bucket[i] != null) {
                ans.addAll(bucket[i]);
            }
        }
        return ans;
    }
}
