class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegrees = new int[numCourses];
        for(int[] currCourses: prerequisites) {
            int course = currCourses[0];
            int pre = currCourses[1];
            if(matrix[pre][course] == 0) {
                indegrees[course]++;
            }
            matrix[pre][course] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            visited++;
            for(int i = 0; i < numCourses; i++) {
                if(matrix[cur][i] != 0) {
                    indegrees[i]--;
                    if(indegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return visited == numCourses;
        }
    }