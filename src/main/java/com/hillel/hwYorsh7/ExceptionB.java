package com.hillel.hwYorsh7;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionB {
}
/**
 * ---------------------------------------- 1. «Магия» checked/unchecked ------------------------------------------
 * <p>
 * Напомним иерархию исключений
 * Object
 * |
 * Throwable
 * /      \
 * Error     Exception
 * |
 * RuntimeException
 * <p>
 * <p>
 * <p>
 * Расставим значение свойства checked/unchecked
 * Object
 * |
 * Throwable(CHECKED)
 * /            \
 * Error(UNCHECKED)    Exception(CHECKED)
 * |
 * RuntimeException(UNCHECKED)
 */
/**
 * Напомним иерархию исключений
 *                    Object
 *                       |
 *                   Throwable
 *                   /      \
 *               Error     Exception
 *                             |
 *                     RuntimeException
 *
 *
 *
 * Расставим значение свойства checked/unchecked
 *                    Object
 *                       |
 *                Throwable(CHECKED)
 *                /            \
 *      Error(UNCHECKED)    Exception(CHECKED)
 *                             |
 *                   RuntimeException(UNCHECKED)
 */

/**
 * ---------------------------------------- 2. Пессимистичный механизм -------------------------------------------
 */
//Мы не можем бросать, но не предупредить
class App69 {
    public static void main(String[] args) {
//        throw new Exception(); // тут ошибка компиляции
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Мы не можем бросать, но предупредить о «меньшем»
class App70 {
    public static void main(String[] args) throws IOException {
//        throw new Exception(); // тут ошибка компиляции
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Мы можем предупредить точно о том, что бросаем
class App71 {
    public static void main(String[] args) throws Exception { // предупреждаем о Exception
        throw new Exception(); // и кидаем Exception
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Мы можем предупредить о большем, чем мы бросаем
class App72 {
    public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
        throw new Exception(); // а кидаем только Exception
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Можем даже предупредить о том, чего вообще нет
class App73 {
    public static void main(String[] args) throws Exception { // пугаем
        // но ничего не бросаем
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Даже если предупреждаем о том, чего нет — все обязаны бояться
class App74 {
    public static void main(String[] args) {
//        f(); // тут ошибка компиляции
    }

    public static void f() throws Exception {
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Хотя они (испугавшиеся) могут перепугать остальных еще больше
class App75 {
    // они пугают целым Throwable
    public static void main(String[] args) throws Throwable {
        f();
    }

    // хотя мы пугали всего-лишь Exception
    public static void f() throws Exception {
    }
}

/**
 * ----------------------------- 3. throws с непроверяемым (unckecked) исключением -------------------------------
 */
//Вызов метода, который «пугает» unchecked исключением не накладывает на нас никаких обязанностей.
class App76 {
    public static void main(String[] args) {
        f();
    }

    public static void f() throws RuntimeException {
    }
}

/**
 * --------------------------------------- 4. Множественные исключения -------------------------------------------
 */
//Мы можем точно указать, что выбрасываем
class App77 {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//или вот так
class App78 {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        f0();
        f1();
    }

    public static void f0() throws EOFException {
    }

    public static void f1() throws FileNotFoundException {
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//А можем «испугать» сильнее (предком обоих исключений)
class App79 {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//или вот так
class App80 {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        f0();
        f1();
    }

    public static void f0() throws EOFException {
    }

    public static void f1() throws FileNotFoundException {
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Можно и вот так: EOFException и FileNotFoundException «обобщаем до» IOException, а InterruptedException
// «пропускаем нетронутым» (InterruptedException — НЕ потомок IOException)
class App81 {
    public static void main(String[] args) throws IOException, InterruptedException {
        f0();
        f1();
        f2();
    }

    public static void f0() throws EOFException {
    }

    public static void f1() throws FileNotFoundException {
    }

    public static void f2() throws InterruptedException {
    }
}

/**
 * ----------------------------------------- 5. Или catch, или throws --------------------------------------------
 */
//Не надо пугать тем, что вы перехватили
//так
class App82 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            // ...
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//или так (ставим catch по предку и точно перехватываем)
class App83 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Throwable e) {
            // ...
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Но если перехватили только потомка, то не выйдет
class App84 {
    public static void main(String[] args) {
        try {
//            throw new Throwable();
        } catch (Exception e) {
            // ...
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Не годится, естественно, и перехватывание «брата»
class App85 {
    public static void main(String[] args) {
        try {
//            throw new Exception();
        } catch (Error e) {
            // ...
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Если вы часть перехватили, то можете этим не пугать
class App86 {
    // EOFException перехватили catch-ом, им не пугаем
    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (EOFException e) {
            // ...
        }
    }
}

/**
 * --------------------------------------- 6. Поведение компилятора/JVM -----------------------------------------
 */
//Необходимо понимать, что
//— проверка на cheched исключения происходит в момент компиляции (compile-time checking)
//— перехват исключений (catch) происходит в момент выполнения (runtime checking)
class App87 {
    // пугаем Exception
    public static void main(String[] args) throws Exception {
        Throwable t = new Exception(); // и лететь будет Exception
//        throw t; // но тут ошибка компиляции
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Полная аналогия с
class App88 {
    public static void main(String[] args) throws Exception {
        Object ref = "Hello!";  // ref указывает на строку
//        char c = ref.charAt(0); // но тут ошибка компиляции
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
// НЕ КОМПИЛИРУЕТСЯ! ИССЛЕДУЕМ ГИПОТЕТИЧЕСКУЮ СИТУАЦИЮ!
class App89 {
    public static void f0(Throwable t) throws Exception {
//        throw t;
    }

    public static void f1(Object ref) {
//        char c = ref.charAt(0);
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Компилятор не пропустит этот код, хотя метод main ГАРАНТИРОВАННО НЕ ВЫБРОСИТ ИСКЛЮЧЕНИЯ
class App90 {
    // пугаем Exception
    public static void main(String[] args) throws Exception {
        try {
            Throwable t = new Exception(); // и лететь будет Exception
//            throw t; // но тут ошибка компиляции
        } catch (Exception e) {
            System.out.println("Перехвачено!");
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
class App91 {
    // ТЕПЕРЬ пугаем Throwable
    public static void main(String[] args) throws Throwable {
        try {
            Throwable t = new Exception(); // а лететь будет Exception
            throw t;
        } catch (Exception e) { // и мы перехватим Exception
            System.out.println("Перехвачено!");
        }
    }
}

/**
 * ---------------------------------------- 7. Overriding и throws -----------------------------------------------
 */
//При переопределении (overriding) список исключений потомка не обязан совпадать с таковым у предка.
//Но он должен быть «не сильнее» списка предка:
class Parent92 {
    // предок пугает IOException и InterruptedException
    public void f() throws IOException, InterruptedException {
    }
}

class Child extends Parent92 {
    // а потомок пугает только потомком IOException
    @Override
    public void f() throws FileNotFoundException {
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Однако тут мы попытались «расширить тип» бросаемых исключений
class Parent93 {
    public void f() throws IOException, InterruptedException {
    }
}

class ChildB extends Parent93 {
//    @Override
//    public void f() throws Exception {}
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Почему можно сужать тип, но не расширять?
//Рассмотрим следующую ситуацию:
class Parent94 {
    // предок пугает Exception
    public void f() throws Exception {
    }
}

// тут ошибка компиляции в Java, но, ДОПУСТИМ, ее нет
//class Child extends Parent94 {
//    // потомок расширил Exception до Throwable
//    public void f() throws Throwable {}
//}
class Demo {
    public static void test(Parent94 ref) {
        // тут все компилируется, Parent.f() пугает Exception и мы его ловим catch
        try {
            ref.f();
        } catch (Exception e) {
        }
    }
}

class App95 {
    public static void main(String[] args) {
        // тут все компилируется, Demo.test хотел Parent и мы дали ему подтип - Child
//        Demo.test(new Child());
    }
}
/**
 * ---------------------------------------------------------------------------------------------------------------
 */