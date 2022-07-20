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

1. Есть документ со списком URL:
   https://drive.google.com/open?id=1wVBKKxpTKvWwuCzqY1cVXCQZYCsdCXTl
   Вывести топ 10 доменов которые встречаются чаще всего. В документе 
   могут встречается пустые и недопустимые строки.

2. Сделать дерево с балансировкой, черно-белое. Еще раз перечитать о 
   TreeMap.
   https://javarush.ru/groups/posts/2584-osobennosti-treemap

3. Есть фрагмент кода, который при запуске выдает ошибку 
   NullPointerException. Найдите и исправьте ошибку:

- import java.util.ArrayList;
- import java.util.List;

public class Main {
private static class Ball {
}

    private static class Board {
        private List balls;


        public Board() {
            List balls = new ArrayList<>();
            balls.add(new Ball());
            balls.add(new Ball());
            balls.add(new Ball());
        }

        public int count() {
            return balls.size();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.count());
    }
}

### Homework 7:

- Пройтись по статье и руками повторить каждый пример. Это важно.
- https://habr.com/ru/company/golovachcourses/blog/223821/
- https://habr.com/ru/company/golovachcourses/blog/225585/
- Для закрепления, повторить данные вариации в своем проекте. Что бы 
понять как исключения работают.