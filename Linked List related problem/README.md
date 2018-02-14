## Difference between compare() and compareTo()?   


a.compareTo(b):
Comparable interface : Compares values and returns an int which tells if the values compare less than, equal, or greater than.
If your class objects have a natural order, implement the Comparable<T> interface and define this method. All Java classes that have a natural ordering implement Comparable<T> - Example: String, wrapper classes, BigInteger

compare(a, b):
Comparator interface : Compares values of two objects. This is implemented as part of the Comparator<T> interface, and the typical use is to define one or more small utility classes that implement this, to pass to methods such as sort() or for use by sorting data structures such as TreeMap and TreeSet. You might want to create a Comparator object for the following:

### Multiple comparisons  
  To provide several different ways to sort something. For example, you might want to sort a Person class by name, ID, age, height, ... You would define a Comparator for each of these to pass to the sort() method.
### System class  
  To provide comparison methods for classes that you have no control over. For example, you could define a Comparator for Strings that compared them by length.
### Strategy pattern  
  To implement a Strategy pattern, which is a situation where you want to represent an algorithm as an object that you can pass as a parameter, save in a data structure, etc.  
  If your class objects have one natural sorting order, you may not need compare().
