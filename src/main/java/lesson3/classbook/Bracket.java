package lesson3.classbook;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Практический пример стека.
 * Представим, что мы пишем I DE для языка Java, и в этой среде разработки необходимо проверять код
 * программы на правильность написания скобок.
 * Задача нашей программы — проверить соответствие открывающих и закрывающих круглых,
 * фигурных и квадратных скобок в представленном методе. Каждая открывающаяся скобка должна
 * иметь пару. Если это соответствие нарушено, программа должна выводить на экран ошибку.
 * Здесь реализован класс StackExam , который содержит методы по добавлению и удалению элемента
 * стека. Класс Bracket содержит метод проверки строки на соответствие скобок. В пользовательском
 * классе JavaStack создан метод getString() , который принимает строку, введенную с клавиатуры.
 */
class Bracket{
    private String input;

    public Bracket ( String in ){
        input = in;
    }

    public void check (){
        int size = input . length ();
        StackExam st = new StackExam ( size );
        for ( int i = 0 ; i < input . length (); i ++){
            char ch = input . charAt ( i );
            switch ( ch ){
                case '[':
                case '{':
                case '(':
                    st . push ( ch );
                    break;
                case ']':
                case '}':
                case ')':
                    if (! st . isEmpty ()){
                        char chr = st . pop ();
                        if (( ch == '}' && chr != '{' ) || ( ch == ']' && chr !=
                                '[' ) || ( ch == ')' && chr != '(' )){
                            System . out . println ( "Error: " + ch + " at " + i );
                        }
                    } else {
                        System . out . println ( "Error: " + ch + " at " + i );
                    }
                    break;
                default:
                    break;
            }
        }
        if (! st . isEmpty ()){
            System . out . println ( "Error: missing right delimiter" );
        }
    }
}
