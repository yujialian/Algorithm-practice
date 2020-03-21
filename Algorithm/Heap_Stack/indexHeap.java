public class indexHeap {
  int[] data;
  int[] indexes;
  int[] reverse;
  int size;
  int capacity;
  public indexHeap(int size) {
    this.size = 0;
    this.capacity = size;
    data = new int[size + 1];
    indexes = new int[size + 1];
    reverse = new int[size + 1];
    for(int i = 0; i <= capacity; i++) {
      reverse[i] = 0;
    }
  }
  //the item i to user is start from 0
  public void insert(int i, int item) {
    if(size + 1 <= capacity && i + 1 >= 1 && i + 1 <= capacity) {
      i += 1;
      data[i] = item;
      indexes[size + 1] = i;
      reverse[i] = size + 1;
      size++;
      shiftUp(size);
    }
  }
  public int extractMax() {
    if(size > 0) {
      int ret = data[indexes[1]];
      swap(indexes[1], indexes[size]);
      reverse[indexes[1]] = 1;
      reverse[indexes[size]] = 0;
      size--;
      shiftDown(1);
      return ret;
    }
    return Integer.MIN_VALUE;
  }
  public int extractMaxIndex() {
    if(size > 0) {
      int ret = index[1] - 1;
      swap(indexes[1], indexes[size]);
      reverse[indexes[1]] = 1;
      reverse[indexes[size]] = 0;
      size--;
      shiftDown(1);
      return Integer.MIN_VALUE;
    }
    return -1;
  }
  public boolean contain(int i) {//contain index?
    if(i + 1 >= 1 && i + 1 <= capacity) {
      return reverse[i+1] != 0;
    }
    return false;
  }
  // for user, i start from 0.
  public int get(int i) {
    if(contain(i)) {
      return data[i+1];
    }
  }
  public void change(int i, int newItem) {
    if(contain(i)) {
      i += 1;
      data[i] = newItem;
      //find indexes[j] = i, j represents data[i]'s position in heap
      int j = reverse[i];//o(1)
      shiftUp(j);
      shiftDown(j);
    }
    }
  }
  private void shiftDown(int k) {
    while(2 * k <= size) {
      int j = 2*k;
      if(j + 1 <= size && data[indexes[j+1]] > data[indexes[j]]) {
        j += 1;
      }
      if(data[indexes[k]] >= data[indexes[j]]) {
        break;
      }
      swap(indexes[k], indexes[j]);
      reverse[indexes[k]] = k;
      reverse[indexes[j]] = j;
      k = j;
    }
  }
  private void shiftUp(int k) {
    while(k > 1 && data[indexes[k/2]] < data[indexes[k]]) {
      swap(indexes[k/2], indexes[k]);
      reverse[indexes[k/2]] = k/2;
      reverse[index[k]] = k;
      k = k/2;
    }
  }
}
