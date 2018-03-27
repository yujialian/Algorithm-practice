class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(kill == 0) return pid;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = pid.size();
        for(int i = 0; i < n; i++) {
            map.put(pid.get(i), new HashSet<Integer>());
        }
        for(int i = 0; i < n; i++) {
            if(map.containsKey(ppid.get(i))) {
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        List<Integer> ans = new ArrayList<>();
        traverse(map, ans, kill);
        return ans;
    }
    private void traverse(Map<Integer, Set<Integer>> map, List<Integer> ans, int kill) {
        ans.add(kill);
        for(int curr: map.get(kill)) {
            traverse(map, ans, curr);
        }
    }
}


//Use queue, interatively
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(kill == 0) return pid;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(kill);
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            if(map.containsKey(cur)) {
                q.addAll(map.get(cur));
            }
        }
        return ans;
    }
}