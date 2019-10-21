package lesson8.hw.task2;

import java.util.TreeSet;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 8. Хеш-таблицы
 * Быстрый поиск и вставка с помощью хеш-таблиц.
 * Рассмотрим метод открытой адресации.
 * Разберем линейное и квадратичное пробирование и двойное хеширование
 * Линейное.
 * Метод линейного пробирования заключается в последовательном поиске свободной ячейки. Если
 * ячейка, которая была рассчитана с помощью хеш-функции, занята, выбирается следующая. Если и
 * она занята, переходим к последующей. И так далее, пока не будет обнаружена свободная.
 */
public class LinearProbingHashMap<Key, Value> {
    //TODO less8hwTask2.Deleted
//    private int capacity = 7;
//    private int size = 0;
    //TODO less8hwTask2.Added
    private int capacity;
    private int size;
    //инициируем объекты удаленных ключа и значения
    private final Key DELETED_KEY = (Key) new Integer(Integer.MIN_VALUE);//(Key) new Object();
    private final Value DELETED_VALUE = (Value) "DELETED";//(Value) new Object();

    private Key[] keys;
    private Value[] values;

    //TODO временно
    private TreeSet<String> set = new TreeSet<>();

    //TODO less8hwTask2.Added
    LinearProbingHashMap(int capacity) {
        this.capacity = capacity;
        size = 0;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Метод возвращает вычисленный хэшкод ключа
    private int hash(Key key) {
        //& 0x7fffffff(0 и 31-а 1-ка) - побитовое логическое "и", чтобы преобразовать
        // отрицательные int числа
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key null");
        }
        return true;
    }

    //TODO less8hwTask2.Deleted
    /*void put(Key key, Value value) {
        isKeyNotNull(key);
        if (size == capacity - 1) {
            throw new ArrayIndexOutOfBoundsException("size == capacity -1");
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }*/
    //TODO less8hwTask2.Added
    void put(Key key, Value value) {
        isKeyNotNull(key);
        if (size == capacity - 1) {
            throw new ArrayIndexOutOfBoundsException("size == capacity -1");
        }
        int h = hash(key);

        //TODO временно
        set.add("" + h + ":" + key + "(" + value + ")");

        //если массив пустой, то просто добавляем элемент и выходим
        if(isEmpty()){
            keys[h] = key;
            values[h] = value;
            size++;
            return;
        }
        //ищем пока не найдем ключ или не пройдем весь цикл
        int index = -1;
        int n = 0;//дополнительный счетчик, чтобы выйти, если проверили весь массив
        int i;
        for (i = h; keys[i] != null; i = (i + 1) % capacity) {
            if(n >= keys.length){
                return;
            }
            //если нашли такой ключ, меняем значение и выходим
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            //если первый проверяемый ключ был удален, то запоминаем индекс
            //возможна ситуация, когда было добавлено несколько ключей с одинаковым hash,
            //а потом удалены какие-то из первых
            if(keys[i].equals(DELETED_KEY) && index == -1){
                index = i;
            }
            n++;
        }
        //если вышли из цикла, значит не нашли такой ключ
        //если не было удаленного ключа, то просто сохраняем
        if(index == -1){
            keys[i] = key;
            values[i] = value;
        } else{//если был удаленный ключ, сохраняем на место первого удаленного
            keys[index] = key;
            values[index] = value;
        }
        size++;
    }

    //TODO less8hwTask2.Deleted
    /*public Value get(Key key) {
        isKeyNotNull(key);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }*/
    //TODO less8hwTask2.Added
    public Value get(Key key) {
        isKeyNotNull(key);
        int n = 0;//дополнительный счетчик, чтобы выйти, если проверили весь массив
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if(n >= keys.length){
                break;
            }
            if (keys[i].equals(key)) {
                return values[i];
            }
            n++;
        }
        return null;
    }

    //TODO less8hwTask2.Added
    Value delete(Key key){
        isKeyNotNull(key);
        if(isEmpty()){
            return null;
        }
        int n =0;//дополнительный счетчик, чтобы выйти, если проверили весь массив
        int h = hash(key);
        for (int i = h; keys[i] != null; i = (i + 1) % capacity){
            if(n >= keys.length){
                break;
            }
            if(keys[i].equals(key)){
                Value tempValue = values[i];
                keys[i] = DELETED_KEY;
                values[i] = DELETED_VALUE;
                size--;
                return tempValue;
            }
            n++;
        }
        return null;
    }

    //TODO L8hwTask2.Added
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***LinearProbingHashMap***\n");
        sb.append("[");
        for (int i = 0; i < capacity; i++) {
            sb.append(keys[i]).append("(").append(values[i]).append(")");
            if(i != keys.length - 1){
                sb.append(", ");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    TreeSet<String> getSet() {
        return set;
    }
}
