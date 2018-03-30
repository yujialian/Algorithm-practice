class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        for(int[] curOrder: prerequisites) {
            int course = curOrder[0];
            int pre = curOrder[1];
            if(matrix[pre][course] == 0) {
                indegree[course]++;
            }
            matrix[pre][course] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for(int i = 0; i < numCourses; i++) {
                if(matrix[cur][i] != 0) {
                    indegree[i]--;
                    if(indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        if(ans.size() != numCourses) {
            return new int[]{};
        }
        int[] arr = new int[numCourses];
        for(int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}