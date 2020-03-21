//Keep the order when frequency are same
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(
            new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                    if(e1.getValue() == e2.getValue()) {
                        return s.indexOf(e1.getKey()) - s.indexOf(e2.getKey());
                    } else {
                        return e2.getValue() - e1.getValue();
                    }
                }
            }
        );
        pq.addAll(map.entrySet());
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int times = entry.getValue();
            while(times != 0) {
                sb.append(entry.getKey());
                times--;
            }
        }
        return sb.toString();
    }
}
//Don't consider order
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(
            new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                    return e2.getValue() - e1.getValue();
                }
            }
        );
        pq.addAll(map.entrySet());
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int times = entry.getValue();
            while(times != 0) {
                sb.append(entry.getKey());
                times--;
            }
        }
        return sb.toString();
    }
}
