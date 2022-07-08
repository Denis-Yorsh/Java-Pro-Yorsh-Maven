# Java Pro Maven
## Homework:

### Homework 1:

Написать реализацию интерфейса List - аналог ArrayList<Integer>

- Список методов:
- void add(int element);
- boolean add(int index, int element);
- void clear();
- int get(int index);
- boolean isEmpty();
- boolean remove(int index);
- boolean removeByValue(int value);
- boolean set(int index, int element);
- int size();
- IntList subList(int fromIndex, int toIndex);
- int[] toArray();

Методы с типом возврата boolean(add, remove, set), возращают true 
если операция прошла успешно.
Реализуйте те методы, которые сможете.

### Homework 2:

Написать реализацию интерфейса List и Deque - аналог LinkedList<Integer>

Реализуйте те методы, которые сможете.

### Homework 3:

1. Разобраться с методом hashCode() и придумать свою реализацию;
2. Разобраться с типами ссылок, это важно. (Strong reference, 
   Soft reference, Weak reference, Phantom reference)
3. Разобраться с методом equals() - симметричность, рефлексивность, 
   транзитивность. Написать свою реализацию.

### Homework 4:

Написать свой проектик на принципах ООП с использованием 
List, HashSet, HashMap

- [x] Проектик называется Crazy Menu
- Вы приходите в ресторан Вам приносят электронное меню, и все 
  что Вам остается это сделать свой выбор =)
- Enjoy your meal