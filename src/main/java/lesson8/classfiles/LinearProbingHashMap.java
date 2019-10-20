package lesson8.classfiles;

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
    private int capacity = 7;
    private int size = 0;

    private Key[] keys = (Key[]) new Object[capacity];
    private Value[] values = (Value[]) new Object[capacity];

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

    void put(Key key, Value value) {
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
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

}
