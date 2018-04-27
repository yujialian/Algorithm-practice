public class max_heap {
  int[] arr;
  int size;
  public max_heap() {
    arr = new int[10];
    size = 0;
  }
  public max_heap(int capacity) {
    arr = new int[capacity + 1];
    size = 0;
  }
  public int size() {
    return size;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public void insert(int a) {
    /*If out of the arr bound, double the size of arr.*/
    if(size + 1 >= arr.length) {
      int[] newArr = new int[arr.length * 2];
      for(int i = 0; i < arr.length; i++) {
        newArr[i] = arr[i];
      }
      arr = newArr;
    }
    /*end of double the size of arr.*/
    arr[size+1] = a;
    size++;
    siftUp(size);
  }
  public int extractMax() {
    if(size <= 0) return 0;
    int ret = arr[1];
    swap(1, size);
    size--;
    shiftDown(1);
    return ret;
  }
  private void siftUp(int k) {
    while(k > 1 && arr[k / 2] < arr[k]) {
      /*When k == 2, last round, compare with it's parent
       k == 1 and then exit.*/
      swap(k/2, k);
      k /= 2;
    }
  }
  private void shiftDown(int k) {
    while(k*2 <= size) {
      int j = k*2;//left child
      if(j + 1 <= size && arr[j+1] > arr[j]) {
        j += 1;
      }
      if(arr[k] >= arr[j]) {
        break;
      }
      swap(k, j);
      k = j;
    }
  }
  private void swap(int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
  public void printOut() {
    for(int i = 0; i < arr.length; i++) {
      System.out.println("No "+i+" Element is: "+ arr[i]);
    }
  }
  public static void main(String[] args) {
    max_heap heap = new max_heap(10);
    System.out.println("" + heap.getClass());
    heap.insert(6);
    heap.insert(10);
    heap.insert(1);
    heap.insert(100);
    heap.insert(20);
    heap.insert(8);
    heap.insert(80);
    heap.insert(6);
    heap.insert(11);
    heap.insert(12);
    //heap.printOut();
    while(!heap.isEmpty()) {
      System.out.println(heap.extractMax());
    }
  }


  public Person(String name, House house) {
    this.name = name;
    this.house = new House(house.)
  }




}
