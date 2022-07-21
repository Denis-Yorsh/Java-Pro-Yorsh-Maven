package com.hillel.hwYorsh7;

public class ExceptionA {
}

/**
 * ----------------------------- 1. Ключевые слова: try, catch, finally, throw, throws ----------------------------
 */
//throws:
//        Годится
class App {
    public static void main(String[] args) throws Throwable {
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//    Не годится
class App1 {
//    public static void main(String[] args) throws String {} - ОШИБКА КОМПИЛЯЦИИ
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//catch:
//        Годится
class App2 {
    public static void main(String[] args) {
        try {
        } catch (Throwable t) {
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Не годится
class App3 {
    public static void main(String[] args) {
//        try {
//        } catch (String s) {} - ОШИБКА КОМПИЛЯЦИИ
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//throw:
//        Годится
class App4 {
    public static void main(String[] args) {
        // Error - потомок Throwable
        throw new Error();
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Не годится
class App5 {
    public static void main(String[] args) {
//        throw new String("Hello!"); - ОШИБКА КОМПИЛЯЦИИ
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Кроме того, throw требуется не-null аргумент, иначе NullPointerException в момент выполнения
class App6 {
    public static void main(String[] args) {
        throw null;
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//throw и new — это две независимых операции. В следующем коде мы независимо создаем объект исключения и «бросаем» его
class App7 {
    public static void main(String[] args) {
        Error ref = new Error(); // создаем экземпляр
        throw ref;               // "бросаем" его
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Однако, попробуйте проанализировать вот это
class App8 {
    public static void main(String[] args) {
        f(null);
    }

    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }
    }
}

/**
 * ------------------------------- 2. Почему используем System.err, а не System.out ------------------------------
 */
//System.out — buffered-поток вывода, а System.err — нет. Таким образом вывод может быть как таким
class App9 {
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Так и вот таким (err обогнало out при выводе в консоль)
class App10 {
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
}

/**
 * --------------------------- 3. Компилятор требует вернуть результат (или требует молчать) ---------------------
 */
//Если в объявлении метода сказано, что он возвращает НЕ void, то компилятор зорко следит, что бы мы вернули
// экземпляр требуемого типа или экземпляр типа, который можно неявно привести к требуемому

class App11 {
    public double sqr(double arg) { // надо double
        return arg * arg;           // double * double - это double
    }
}


class App12 {
    public double sqr(double arg) { // надо double
        int k = 1;                  // есть int
        return k;                   // можно неявно преобразовать int в double
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
// на самом деле, компилятор сгенерирует байт-код для следующих исходников
class App13 {
    public double sqr(double arg) { // надо double
        int k = 1;                  // есть int
        return (double) k;          // явное преобразование int в double
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//    вот так не пройдет (другой тип)
class App14 {
//    public static double sqr(double arg) {
//        return "hello!"; - ОШИБКА КОМПИЛЯЦИИ
//    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Вот так не выйдет — нет возврата
class App15 {
//    public static double sqr(double arg) {  - ОШИБКА КОМПИЛЯЦИИ
//    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//и вот так не пройдет (компилятор не может удостовериться, что возврат будет)
class App16 {
//    public static double sqr(double arg) {
//        if (System.currentTimeMillis() % 2 == 0) {
//            return arg * arg; // если currentTimeMillis() - четное число, то все ОК
//        }
//        // а если нечетное, что нам возвращать?
//    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Компилятор отслеживает, что бы мы что-то вернули, так как иначе непонятно, что должна была бы напечатать данная программа
class App17 {
    public static void main(String[] args) {
        //double d = sqr(10.0); // ну, и чему равно d?
        //System.out.println(d);
    }
//    public static double sqr(double arg) {
//        // nothing
//    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Из-забавного, можно ничего не возвращать, а «повесить метод»
class App18 {
    public static double sqr(double arg) {
        while (true) ; // Удивительно, но КОМПИЛИРУЕТСЯ!
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Тут в d никогда ничего не будет присвоено, так как метод sqr повисает
class App19 {
    public static void main(String[] args) {
        double d = sqr(10.0);  // sqr - навсегда "повиснет", и
        System.out.println(d); // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
    }

    public static double sqr(double arg) {
        while (true) ; // Вот тут мы на века "повисли"
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Компилятор пропустит «вилку» (таки берем в квадрат ИЛИ висим)
class App20 {
    public static double sqr(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg; // ну ладно, вот твой double
        } else {
            while (true) ;     // а тут "виснем" навсегда
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Но механизм исключений позволяет НИЧЕГО НЕ ВОЗВРАЩАТЬ!
class App21 {
    public static double sqr(double arg) {
        throw new RuntimeException();
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Итак, у нас есть ТРИ варианта для компилятора
class App22 {
    public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            return arg * arg;             // ок, вот твой double
        } else if (time % 2 == 1) {
            while (true) ;                 // не, я решил "повиснуть"
        } else {
            throw new RuntimeException(); // или бросить исключение
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Но КАКОЙ ЖЕ double вернет функция, бросающая RuntimeException?
//        А НИКАКОЙ!
class App23 {
    public static void main(String[] args) {
        // sqr - "сломается" (из него "выскочит" исключение),
        double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
        // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
        System.out.println(d); // и печатать нам ничего не придется!
    }

    public static double sqr(double arg) {
        throw new RuntimeException(); // "бросаем" исключение
    }
}

/**
 * -------------------------- 4. Нелокальная передача управления (nonlocal control transfer) ---------------------
 */
//Механизм исключительных ситуация (исключений) — это механизм НЕЛОКАЛЬНОЙ ПЕРЕДАЧИ УПРАВЛЕНИЯ.
//        Что под этим имеется в виду?
//        Программа, в ходе своего выполнения (точнее исполнения инструкций в рамках отдельного потока),
//        оперирует стеком («стопкой») фреймов. Передача управления осуществляется либо в рамках одного фрейма
class App24 {
    public static void main(String[] args) {
        // Пример: ОПЕРАТОР ПОСЛЕДОВАТЕЛЬНОСТИ
        int x = 42;    // первый шаг
        int y = x * x; // второй шаг
        x = x * y;     // третий шаг
    }
}


class App25 {
    public static void main(String[] args) {
        // Пример: ОПЕРАТОР ВЕТВЛЕНИЯ
        if (args.length > 2) { //первый шаг
            // второй шаг или тут
        } else {
            // или тут
        }
        // третий шаг
    }
}


class App26 {
    public static void main(String[] args) {
        // Пример: ОПЕРАТОР ЦИКЛА do..while
        int x = 1;
        do {
        } while (x++ < 10);
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//return — выходим из ОДНОГО фрейма (из фрейма #4(метод h()))
class App27 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out");  //вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.RETURN");
            return; // выходим из текущего фрейма по 'return'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСКАЕМ
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//throw — выходим из ВСЕХ фреймов
class App28 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // ПРОПУСТИЛИ!
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//При помощи catch мы можем остановить летящее исключение (причина, по которой мы автоматически покидаем фреймы).
//Останавливаем через 3 фрейма, пролетаем фрейм #4(метод h()) + пролетаем фрейм #3(метод g()) + фрейм #2(метод f())
class App29 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        try {
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println("#1.CATCH");  // и работаем
        }
        System.err.println("#1.out");  // работаем дальше
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Останавливаем через 2 фрейма, пролетаем фрейм #4(метод h()) + пролетаем фрейм #3(метод g())
class App30 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        try {
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   #2.CATCH");  // и работаем
        }
        System.err.println(".   #2.out");  // работаем дальше
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Останавливаем через 1 фрейм (фактически аналог return, просто покинули фрейм «другим образом»)
class App31 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // вернулись и работаем
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        try {
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   .   #3.CATCH");  // и работаем
        }
        System.err.println(".   .   #3.out");  // работаем дальше
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

/**
 * --------------------------------- 5. try + catch (catch — полиморфен) -------------------------------------------
 */
//То, что исключения являются объектами важно для нас в двух моментах
//1. Они образуют иерархию с корнем java.lang.Throwable (java.lang.Object — предок java.lang.Throwable,
// но Object — уже не исключение)
//2. Они могут иметь поля и методы (в этой статье это не будем использовать)

//По первому пункту: catch — полиморфная конструкция, т.е. catch по типу Parent перехватывает летящие экземпляры
// любого типа, который является Parent-ом (т.е. экземпляры непосредственно Parent-а или любого потомка Parent-а)
class App32 {
    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            if (true) {throw new RuntimeException();}
//            System.err.print(" 1");
//        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
//            System.err.print(" 2");
//        }
        System.err.println(" 3");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Даже так: в блоке catch мы будем иметь ссылку типа Exception на объект типа RuntimeException
class App33 {
    public static void main(String[] args) {
//        try {
//            throw new RuntimeException();
//        } catch (Exception e) {
//            if (e instanceof RuntimeException) {
//                RuntimeException re = (RuntimeException) e;
//                System.err.print("Это RuntimeException на самом деле!!!");
//            } else {
//                System.err.print("В каком смысле не RuntimeException???");
//            }
//        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//catch по потомку не может поймать предка
class App34 {
//    public static void main(String[] args) throws Exception { // пока игнорируйте 'throws'
//        try {
//            System.err.print(" 0");
//            if (true) {throw new Exception();}
//            System.err.print(" 1");
//        } catch (RuntimeException e) {
//            System.err.print(" 2");
//        }
//        System.err.print(" 3");
//    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//catch по одному «брату» не может поймать другого «брата» (Error и Exception не находятся в отношении
// предок-потомок, они из параллельных веток наследования от Throwable)
class App35 {
    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            if (true) {throw new Error();}
//            System.err.print(" 1");
//        } catch (Exception e) {
//            System.err.print(" 2");
//        }
        System.err.print(" 3");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//А что будет, если мы зашли в catch, и потом бросили исключение ИЗ catch?
class App36 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {
                throw new Error();
            } // но бросили Error
        }
        System.err.println(" 3");          // пропускаем - уже летит Error
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Мы можем даже кинуть тот объект, что у нас есть «на руках»
class App37 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {
                throw e;
            }       // и бросили ВТОРОЙ раз ЕГО ЖЕ
        }
        System.err.println(" 3");      // пропускаем - опять летит RuntimeException
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//И мы не попадем в другие секции catch, если они есть
class App38 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {
                throw new Error();
            } // и бросили новый Error
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Обратите внимание, мы не напечатали «3», хотя у нас летит Error а «ниже» расположен catch по Error. Но важный
// момент в том, что catch имеет отношение исключительно к try-секции, но не к другим catch-секциям.
//        Как покажем ниже — можно строить вложенные конструкции, но вот пример, «исправляющий» эту ситуацию
class App39 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {
                    throw new Error();
                } // и бросили новый Error
                System.err.print(" 2.3");
            } catch (Throwable t) {            // перехватили Error
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}

/**
 * --------------------------------------- 6. try + catch + catch + ...--------------------------------------------
 */
//Как вы видели, мы можем расположить несколько catch после одного try.
//        Но есть такое правило — нельзя ставить потомка после предка! (RuntimeException после Exception)
class App40 {
    public static void main(String[] args) {
//        try {
//        } catch (Exception e) {
//        } catch (RuntimeException e) {
//        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Ставить брата после брата — можно (RuntimeException после Error)
class App41 {
    public static void main(String[] args) {
        try {
        } catch (Error e) {
        } catch (RuntimeException e) {
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Как происходит выбор «правильного» catch? Да очень просто — JVM идет сверху-вниз до тех пор, пока не найдет
// такой catch что в нем указано ваше исключение или его предок — туда и заходит. Ниже — не идет.
class App42 {
    public static void main(String[] args) {
//        try {
//            throw new Exception();
//        } catch (RuntimeException e) {
//            System.err.println("catch RuntimeException");
//        } catch (Exception e) {
//            System.err.println("catch Exception");
//        } catch (Throwable e) {
//            System.err.println("catch Throwable");
//        }
        System.err.println("next statement");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Выбор catch осуществляется в runtime (а не в compile-time), значит учитывается не тип ССЫЛКИ
// (Throwable), а тип ССЫЛАЕМОГО (Exception)
class App43 {
    public static void main(String[] args) {
//        try {
//            Throwable t = new Exception(); // ссылка типа Throwable указывает на объект типа Exception
//            throw t;
//        } catch (RuntimeException e) {
//            System.err.println("catch RuntimeException");
//        } catch (Exception e) {
//            System.err.println("catch Exception");
//        } catch (Throwable e) {
//            System.err.println("catch Throwable");
//        }
        System.err.println("next statement");
    }
}

/**
 * ----------------------------------------- 7. try + finally -------------------------------------------------
 */
//finally-секция получает управление, если try-блок завершился успешно
class App44 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//finally-секция получает управление, даже если try-блок завершился исключением
class App45 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//finally-секция получает управление, даже если try-блок завершился директивой выхода из метода
class App46 {
    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//finally-секция НЕ вызывается только если мы «прибили» JVM
class App47 {
    public static void main(String[] args) {
        try {
            System.exit(42);
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//System.exit(42) и Runtime.getRuntime().exit(42) — это синонимы
class App48 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exit(42);
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//И при Runtime.getRuntime().halt(42) — тоже не успевает зайти в finally
class App49 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().halt(42);
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Однако finally-секция не может «починить» try-блок завершившийся исключение (заметьте, «more» — не выводится в консоль)
class App50 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {
                throw new RuntimeException();
            }
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Трюк с «if (true) {...}» требуется, так как иначе компилятор обнаруживает недостижимый
// код (последняя строка) и отказывается его компилировать
class App51 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
//        System.err.println("more");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//И finally-секция не может «предотвратить» выход из метода, если try-блок вызвал
// return («more» — не выводится в консоль)
class App52 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {
                return;
            }
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Однако finally-секция может «перебить» throw/return при помощи другого throw/return
class App53 {
    public static void main(String[] args) {
        System.err.println(f());
    }

    public static int f() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
}

class App54 {
    public static void main(String[] args) {
        System.err.println(f());
    }

    public static int f() {
        try {
            throw new RuntimeException();
        } finally {
            return 1;
        }
    }
}

class App55 {
    public static void main(String[] args) {
        System.err.println(f());
    }

    public static int f() {
        try {
            return 0;
        } finally {
            throw new RuntimeException();
        }
    }
}

class App56 {
    public static void main(String[] args) {
        System.err.println(f());
    }

    public static int f() {
        try {
            throw new Error();
        } finally {
            throw new RuntimeException();
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Вообще говоря, в finally-секция нельзя стандартно узнать было ли исключение.
//        Конечно, можно постараться написать свой «велосипед»
class App57 {
//    public static void main(String[] args) {
//        System.err.println(f());
//    }
//    public static int f() {
//        long rnd = System.currenttimeMillis();
//        boolean finished = false;
//        try {
//            if (rnd % 3 == 0) {
//                throw new Error();
//            } else if (rnd % 3 == 1) {
//                throw new RuntimeException();
//            } else {
//                // nothing
//            }
//            finished = true;
//        } finally {
//            if (finished) {
//                // не было исключений
//            } else {
//                // было исключение, но какое?
//            }
//        }
//    }
}

/**
 * ------------------------------------------ 8. try + catch + finally ---------------------------------------------
 */
//Нет исключения
class App58 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            // nothing
            System.err.print(" 1");
        } catch (Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Есть исключение и есть подходящий catch
class App59 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new Error();
            }
            System.err.print(" 1");
        } catch (Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Есть исключение но нет подходящего catch
class App60 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

/**
 * ------------------------------------ 9. Вложенные try + catch + finally ---------------------------------------
 */
//Операторы обычно допускают неограниченное вложение.
//        Пример с if
class App61 {
    public static void main(String[] args) {
        if (args.length > 1) {
            if (args.length > 2) {
                if (args.length > 3) {
                }
            }
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Пример с for
class App62 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; i++) {
                for (int k = 0; k < 10; k++) {
                }
            }
        }
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Суть в том, что try-cacth-finally тоже допускает неограниченное вложение.
//        Например вот так
class App63 {
//    public static void main(String[] args) {
//        try {
//            try {
//                try {
//                } catch (Exception e) {
//                } finally {}
//            } catch (Exception e) {
//            } finally {}
//        } catch (Exception e) {
//        } finally {}
//    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Или даже вот так
class App64 {
//    public static void main(String[] args) {
//        try {
//            try {
//
//            } catch (Exception e) {
//
//            } finally {
//
//            }
//        } catch (Exception e) {
//            try {
//
//            } catch (Exception e) {
//
//            } finally {
//
//            }
//        } finally {
//            try {
//
//            } catch (Exception e) {
//
//            } finally {
//
//            }
//        }
//    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Вложенный try-catch-finally без исключения
class App65 {
    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            try {
//                System.err.print(" 1");
//                // НИЧЕГО
//                System.err.print(" 2");
//            } catch (RuntimeException e) {
//                System.err.print(" 3"); // НЕ заходим - нет исключения
//            } finally {
//                System.err.print(" 4"); // заходим всегда
//            }
//            System.err.print(" 5");     // заходим - выполнение в норме
//        } catch (Exception e) {
//            System.err.print(" 6");     // НЕ заходим - нет исключения
//        } finally {
//            System.err.print(" 7");     // заходим всегда
//        }
        System.err.print(" 8");         // заходим - выполнение в норме
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Вложенный try-catch-finally с исключением, которое ПЕРЕХВАТИТ ВНУТРЕННИЙ catch
class App66 {
    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            try {
//                System.err.print(" 1");
//                if (true) {throw new RuntimeException();}
//                System.err.print(" 2");
//            } catch (RuntimeException e) {
//                System.err.print(" 3"); // ЗАХОДИМ - есть исключение
//            } finally {
//                System.err.print(" 4"); // заходим всегда
//            }
//            System.err.print(" 5");     // заходим - выполнение УЖЕ в норме
//        } catch (Exception e) {
//            System.err.print(" 6");     // не заходим - нет исключения, УЖЕ перехвачено
//        } finally {
//            System.err.print(" 7");     // заходим всегда
//        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Вложенный try-catch-finally с исключением, которое ПЕРЕХВАТИТ ВНЕШНИЙ catch
class App67 {
    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            try {
//                System.err.print(" 1");
//                if (true) {throw new Exception();}
//                System.err.print(" 2");
//            } catch (RuntimeException e) {
//                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
//            } finally {
//                System.err.print(" 4"); // заходим всегда
//            }
//            System.err.print(" 5");     // не заходим - выполнение НЕ в норме
//        } catch (Exception e) {
//            System.err.print(" 6");     // ЗАХОДИМ - есть подходящее исключение
//        } finally {
//            System.err.print(" 7");     // заходим всегда
//        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

/**
 * ---------------------------------------------------------------------------------------------------------------
 */
//Вложенный try-catch-finally с исключением, которое НИКТО НЕ ПЕРЕХВАТИТ
class App68 {
    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            try {
//                System.err.print(" 1");
//                if (true) {throw new Error();}
//                System.err.print(" 2");
//            } catch (RuntimeException e) {
//                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
//            } finally {
//                System.err.print(" 4"); // заходим всегда
//            }
//            System.err.print(" 5");     // НЕ заходим - выполнение НЕ в норме
//        } catch (Exception e) {
//            System.err.print(" 6");     // не заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
//        } finally {
//            System.err.print(" 7");     // заходим всегда
//        }
        System.err.print(" 8");         // не заходим - выполнение НЕ в норме
    }
}
/**
 * ---------------------------------------------------------------------------------------------------------------
 */