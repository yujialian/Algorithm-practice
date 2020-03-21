class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    if(entry1.getValue() != entry2.getValue()) {
                        return entry1.getValue() - entry2.getValue();
                    } else {
                        return entry2.getKey().compareTo(entry1.getKey());
                    }
                }
            }
        );
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        // for(Map.Entry<String, Integer> entry: pq) {
        //     ans.add(0, entry.getKey());
        // }
        while(!pq.isEmpty()) {
            ans.add(0, pq.poll().getKey());
        }
        return ans;
    }
}
