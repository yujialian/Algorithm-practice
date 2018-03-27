class RandomizedSet {

    /** Initialize your data structure here. */
    HashSet<Integer> set;
    Random rand;
    public RandomizedSet() {
        set = new HashSet<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int position = rand.nextInt(set.size());
        int curr = 0;
        int r = 0;
        for(int val: set) {
            r = val;
            if(position <= curr) {
                break;
            }
            curr++;
        }
        return r;
    }
}


///

class RandomizedSet {

    /** Initialize your data structure here. */
    HashMap<Integer, Integer> location;
    ArrayList<Integer> list;
    Random rand = new Random();
    public RandomizedSet() {
        location = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(location.containsKey(val)) {
            return false;
        }
        location.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!location.containsKey(val)) {
            return false;
        }
        if(val != list.get(list.size() - 1)) {
            int prev = location.get(val);
            //location.put(val, list.size() - 1);
            location.put(list.get(list.size() - 1), prev);
            list.set(prev, list.get(list.size() - 1));
            //list.set(list.size() - 1, val);
        }
        location.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
