### Binary Search advantage: 
    Effectively on both insertion, deletion, searching, Find relationship between data like: min, max, floor, ceil, rank, select.  
    Difference between heap and binary search tree, heap is balanced binary tree, so can be transformed into array, binary search tree can be unbalanced.
  
    Binary Search Tree Node Deletion: Delete any node in a binary search tree: o(logn).
  
    Hubbard deletion: If the deletion node's left and right children exist, we can use the biggest left child or smallest right child to subsitute deletion node.
  

# B tree 
    B Tree: Extenstion of Binary Search Tree
    B Tree:  Can have m children, satisfies following properties:  
    1. Each node has at most m children.  
    2. Each internal node(node that is not leaf and not root)  has at least [m/2] children.  
    3. Root has at least 2 children, if it is not leaf.  
    4. A non-leaf node with k children, has k-1 keys.
    5. All leaves appear in some level.（keeping hight bounded)

## m=3 B-Tree

    Each Node has at most 3 children, root has 2 children, all leaves are at same level
    If a node has 2 children, it has 1 key.
    Each internal node has at least 2 children, maxmium is 3.

### m=2, same as binary search tree  

### Algorithm of B tree:
    Use search procedure like binary tree to find leaf node where x should be placed.
    Add x to appropriate place in leaf(Ascending order)
    If there are m-1 or fewer keys then done.
    If more than m-1 keys in the leaf, overflow, split the node into 2 equal parts and one middle element,
    add middle to parent and make those 2 nodes as its child.
    If there is overflow in parent, split it, we continue till no overflow occurs or root itself splits.
    
    
    
