### Stable sort:
For the elements that contains same value, after sort, the order should still keeps.
Insertion sort, merge sort is stable
Quick sort: not stable, each time random select pivot. Which makes later element switch to earlier position.
Heap sort: Through heapify, the relative position maybe changed.

### We can improve the stability of algorithm by over writing the compareTo method.

###Problem with heap:
1.If elements have complex structure, swap operation going to be expensive.
2.Because of the relative position of each element changed after heap been built, it's hard to do indexing on certain element once heap is been built.

Solution: Index heap. (Use an extra array to keep track the original index.)

### Using heap to achieve Priority Queue:
Exp: select top 100 elements from 100000 elements.(Select top M elements from N elements).

N*log(M)
