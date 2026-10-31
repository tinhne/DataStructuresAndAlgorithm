# Data Structures and Algorithms (Java)

Data structures practice repository (December 2023 – April 2024). Classic structures are implemented from scratch in plain Java, mostly without `java.util` collections, together with a few small algorithm exercises. Some implementations are complete; others were left unfinished and are marked as such below.

## What it practises

- Generic types and the `Iterable` / `Iterator` contracts
- Designing an ADT interface first (`StackADT`, `QueueADT`, `TreeADT`, `HashTableADT`, `DoublyLinkedListADT`) and implementing it more than once
- Array growth, node-based structures, recursion vs. explicit stacks, and tree traversals
- Simple timing comparisons between array-based and linked implementations

## Implemented structures

| Package | Class | Status | Notable behaviour |
| --- | --- | --- | --- |
| `Array` | `DynamicArray<T>` | Partial | Default capacity 10; doubles the backing array when it fills up; `indexOf`/`contains` accept `null`; rejects negative capacity; `removeAt` checks the index. `get`/`set` do not check bounds, and `removeAt`/`remove` contain a loop bug (see limitations). |
| `LinkedList` | `DoublyLinkedList<T>` | Complete | Head and tail pointers; O(1) add/peek/remove at both ends; `removeAt` walks from whichever end is closer; iterator and `toString`. |
| `LinkedList` | `MyDoublyLinkedList<T>` | Complete | Second implementation of the same ADT, adds `insert(data, index)` and a print helper. |
| `LinkedList` | `SinglyLinkedList<T>` | Complete | `add`, `append`, `insert` and `removeAt` with index checks, `remove(value)`. |
| `Stack` | `ArrayBasedStack<T>` | Partial | Backed by `DynamicArray`; throws `EmptyStackException` on empty `pop`. Pushing after a pop can hit the `DynamicArray.add` copy bug below. |
| `Stack` | `LinkedListBasedStack<T>` | Complete | Backed by `DoublyLinkedList`. |
| `MyStack` | `LinkedListBaseStack<T>` | Complete | Own node class and iterator. |
| `MyStack` | `ArraysBasedStack` | Complete | Fixed-size `int` stack. |
| `Queue` | `CircularArrayBasedQueue<T>` | Partial | Fixed-capacity ring buffer with wrap-around indexes; iterator is a stub. |
| `Queue` | `DoublyLinkedListBasedQueue<T>` | Partial | Enqueue at the tail and dequeue at the head of `DoublyLinkedList`; iterator returns `null`. |
| `Queue` | `LinkedListBaseQueue<T>` | Partial | Own singly linked nodes with front/rear pointers; `size()` always returns 0 and the iterator returns `null`. |
| `Tree` | `BinarySearchTree<T extends Comparable<T>>` | Partial | Recursive add (rejects duplicates), contains and height; in-order and pre-order iterators that throw `ConcurrentModificationException` if the tree changes. `remove` is attempted but does not pick the in-order successor correctly; post-order and level-order return `null`. |
| `MyTree` | `Tree`, `BstTree` | Complete | Integer trees: pre-order recursion, depth-first with a stack, breadth-first with a queue, min/max, sorting through in-order traversal, height, node count, and two "balanced insert" exercises. |
| `HashTable` | `SeparateChainingHashTable<K, V>` | Stub | Constructor validates capacity and load factor and `hashCodeToIndex` is written, but the bucket array is never allocated, `insert` does not store anything, and `remove`/`iterator` return `null`. |

Status key: *Complete* means every method of the class has an implementation (there are no automated tests); *Partial* means some methods are missing or known to be wrong; *Stub* means the class is mostly unimplemented.

## Algorithm exercises

| File | Topic |
| --- | --- |
| `Array/TimSoNguyenTo.java` | Sieve of Eratosthenes |
| `Array/PrintSubArrayDegree.java` | Print strictly decreasing runs of a random array |
| `MyStack/BaseConversion.java` | Base conversion, recursive and with a stack |
| `MyStack/HaNoiTowerAlgorithm.java` | Tower of Hanoi (recursive; stack version not finished) |
| `Stack/StackTest.java`, `Queue/QueueTest.java` | Timing of array-based vs. linked implementations |
| `MyTree/exercise` | Exercise statement (Vietnamese) for the `BstTree` tasks |

## Project structure

```text
src/
├── Array/       # DynamicArray and array exercises
├── HashTable/   # Separate-chaining hash table (unfinished)
├── LinkedList/  # Doubly and singly linked lists
├── Stack/       # Generic stacks on DynamicArray / DoublyLinkedList
├── MyStack/     # Second round of stack exercises
├── Queue/       # Circular-array and linked queues
├── Tree/        # Generic binary search tree with iterators
└── MyTree/      # Integer tree exercises
```

## How to run

The project is an IntelliJ IDEA module (`DataStructuresAndAlgorithm.iml`) set to JDK 17; there is no Maven or Gradle build. Open the folder in IntelliJ and run any class that has a `main` method, for example `LinkedList.main`, `Tree.BSTTest` or `Stack.StackTest`.

From a terminal:

```bash
javac -d out $(find src -name "*.java")
java -cp out Tree.BSTTest
```

## Known limitations

- `DynamicArray.removeAt` decrements the source index instead of the target index when it reaches the removed slot, so the loop never advances; `remove(Object)` calls it and has the same problem.
- `DynamicArray.add` copies `arr.length` elements into the new array, which can overflow after `removeAtWithoutMoving` has lowered the capacity.
- `DoublyLinkedList.indexOf` and `remove(Object)` call `equals` on the argument, so passing `null` throws.
- The hash table, BST removal, two BST traversals and the queue iterators are unfinished.
- There are no automated tests; the `*Test` classes are `main`-method demos.

## Author

**Lê Văn Trung Tính** — Software Engineer | AI Product Builder

- Website: [trungtinh.site](https://trungtinh.site)
- GitHub: [@tinhne](https://github.com/tinhne)
