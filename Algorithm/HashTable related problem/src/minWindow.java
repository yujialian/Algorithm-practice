class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int end = 0;
        int start = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        while(end < s.length()) {
            Character c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            while(counter == 0) {
                char tempc = s.charAt(start);
                if(map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0) counter++;
                }
                if(end-start < len) {
                    len = end - start;
                    head = start;
                }
                start++;
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }
}