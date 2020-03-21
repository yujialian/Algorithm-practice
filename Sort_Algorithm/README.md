# Algorithm-practice


### Insertion sort:
```
  (Nearly) O(n) when array is (Nearly)already ordered.
  Compare to selection sort, insertion sort can break inner loop ealier, which is better is array is nearly sorted.
```
### Merge sort:
```
  When array is small, insertion sort is better, a1*n^2, a2*nlog(n), a1<a2.
  For nearly ordered array, insertion sort is better.

  For smaller array, the chance of been nearly ordered is high. (2). Even insertion is o(n^2), merge is o(nlogn), but there is a constant before the complexity, for this constant, insertion sort is smaller than merge sort, so, insertion sort have advantage than merge sort when array is small/Nearly sorted.
 ```

#### Optimize Merge sort:
```
    1, When array is small or recursion to nearly bottom, say r-l < 15, use insertion sort.
    2, Only when arr[mid] > arr[mid + 1], we do merge sort.

    Merge sort: From top to bottom is better compare to from bottom to top.
    Merge sort(Bottom to top): divide process do not need access array using index,  so it's better to use it to do merge sort
    on a likedlist. o(nlogn).
```
### Topological sort
```
Rule of thumb: We can only visit a vertex after all the vertices leading up to it have been visited.
Directed Acyclic graph
-DFS with time stamps
Topological sort are not unique(Except for Hamiltonian path, which visit each node exactly once.
Indegree: A vertice that has no edges going into it.
Useful for dependency resolution: Download packages, certein packages rely on other packages.
```

### Merge sort and quick sort all use divide and conquer method
