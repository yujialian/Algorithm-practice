class Solution {
    public String findLongestWord(String s, List<String> d) {
        if(d==null || d.size() == 0) {
            return "";
        }
        Collections.sort(d, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s2.length() != s1.length()) {
                    return s2.length() - s1.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        StringBuffer buff = new StringBuffer(s.length());
        buff.append(s);
        for(int i = 0; i < d.size(); i++) {
            String current = d.get(i);
            for(int j = 0; j < current.length(); j++) {
                int idx = buff.indexOf(current.substring(j, j+1));
                if(idx != -1) {
                    buff.delete(0,idx+1);
                    if(j == current.length() -1) {
                        return current;
                    }
                } else {
                    buff.delete(0, buff.length());
                    buff.append(s);
                    break;
                }
            }
        }
        return "";
    }
}