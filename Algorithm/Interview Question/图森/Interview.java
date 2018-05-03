TuSimple Online Interview
Candidate name: Yujia Lian
Scheduled time: 5/1/2018 16:00 UTC+0800
// Problem 1
// "abbcdef" => ["a" "bb" "cd" "ef"]
// "abbcda" => ["abbcda"]
// "abcdba" => ["abcdba"]
// "abcd" => ["a", "b", "c", "d"]
// "abcbetrtyrty" => ["a", "bcb"]
// "aabb"

public void find(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    ArrayList<String> ans = new ArrayList<>();
    int index = 0;
    while(index < s.length()) {
        StringBuffer sb = new StringBuffer();
        int l = index;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        while(l < s.length()) {
            char c = s.charAt(l);
            map.put(c, map.get(c) - 1);
            sb.add(c);
            if(!set.contains(c)) {
                count++;
            }
            set.add(c);
            if(map.get(c) == 0) {
                count--;
            }
            if(count == 0) break;
            else l++;
        }
        ans.add(sb.toString());
        index = l + 1;
        sb.clear();
    }
}
public List<List<Double>> mergeInterval(List<List<Double>> list) {
    PriorityQueue<List<Double>> pq = new PriorityQueue<>(new Comparator<List<Double>>() {
        public int compare(List<Double> l1, List<Double> l2) {
            return l1.get(0).compareTo(l2.get(0));
        }
    }
    List<List<Double>> ans = new List<List<Double>>();
    pq.addAll(list);
    while(!pq.isEmpty()) {
        if(ans.size() == 0) ans.add(pq.poll());
        else {
            List<Double> curr = pq.poll();
            List<Double> prev = ans.get(ans.size() - 1);
            if(curr.get(0) <= prev.get(prev.size() - 1)) {
                if(curr.get(curr.size() - 1) > prev.get(prev.size() - 1)) {
                    prev.set(prev.size() - 1, curr.get(curr.size() - 1));
                }
            } else {
                ans.add(curr);
            }
        }
    }
    return ans;
}
