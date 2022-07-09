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

### Homework 5:

1. Написать метод который принимает коллекцию Котов, а возвращает 
коллекцию с теме же котами, но изменяет адрес котов (переехали коты 
на новое место жительства))
- public List<Cat> eat (List<Cat>){ логика }

2. Написать метод который возвращает список книг по имени автора
- public Set<Book> listBooksByAuthors (Map<String, Book>){ логика }

3. Написать метод который позволяет управлять автомобилем группе людей, 
только тем, кто имеет водительское удостоверение, паспорт и отсутствие 
штрафов в последних 365 дней года.

### Homework 6: