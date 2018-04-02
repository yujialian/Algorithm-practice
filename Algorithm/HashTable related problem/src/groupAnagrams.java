class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for(String str: strs) {
            char[] curArray = str.toCharArray();
            Arrays.sort(curArray);
            if(map.containsKey(String.valueOf(curArray))) {
                map.get(String.valueOf(curArray)).add(str);
            } else {
                map.put(String.valueOf(curArray), new ArrayList<>());
                map.get(String.valueOf(curArray)).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for(String s: strs) {
            Arrays.fill(count, 0);
            for(char c: s.toCharArray()) count[c-'a']++;
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
