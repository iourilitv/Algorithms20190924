package lesson3.hw.task3;

import java.util.EmptyStackException;

public class MyDeque<Item extends Comparable> {
    private Item[] list;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;
    private int startBeginEnd;

    protected MyDeque() {
        list = (Item[]) new Comparable [DEFAULT_CAPACITY];
        initDeque();
    }

    protected MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Comparable[capacity];
        initDeque();
    }

    protected MyDeque(int capacity, int startBeginEnd) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Comparable[capacity];
        initDeque(startBeginEnd);
    }

    //Устанавливаем начальные значения индексов начала и конца очереди по умолчанию
    private void initDeque(){
        begin = list.length / 2;
        end = begin;
    }

    //Устанавливаем начальные значения индексов начала и конца очереди
    private void initDeque(int startBeginEnd){
        begin = startBeginEnd;
        end = begin;
    }

    //добавляем элемент в конец очереди(справа при нормальном порядке)
    void insertRight(Item item) {
        if (isFull()) {
            //если массив заполнен полностью, увеличиваем его
            reCapacity(list.length + DEFAULT_CAPACITY);
        }
        //сдвигаем хвост очереди наружу, кроме случая если очередь пустая
        if(!isEmpty()){
            end = shiftEndOutward();
        }
        list[end] = item;
    }

    //добавляем элемент в начало очереди(слева при нормальном порядке)
    void insertLeft(Item item) {
        if (isFull()) {
            reCapacity(list.length + DEFAULT_CAPACITY);
        }
        //сдвигаем голову очереди наружу, кроме случая если очередь пустая
        if(!isEmpty()){
            begin = shiftBeginOutward();
        }
        list[begin] = item;
    }

    //удаляем элемент из начала очереди(левый при нормальном порядке)
    Item removeLeft() {
        //запоимнаем элемент в начале очереди
        Item value = peekLeft();
        //обнуляем ссылку на объект в ячейке элемента
        list[begin] = null;
        //сдвигаем начало внутрь
        begin = shiftBeginInward();

        //FIXME добавить тримминг, если пусто
        isEmpty();
        return value;
    }

    //удаляем элемент из конца очереди(правый при нормальном порядке)
    protected Item removeRight() {
        Item value = peekRight();
        list[end] = null;
        end = shiftEndInward();
        isEmpty();
        return value;
    }

    //читаем элемент в начале очереди(левый при нормальном порядке)
    Item peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }

    //читаем элемент в конце очереди(правый при нормальном порядке)
    protected Item peekRight() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[end];
    }

    //сдвигаем индекс на следующий элемент справа
    private int nextRightIndex(int index) {
        return (index + 1) % list.length;
    }

    //сдвигаем индекс на следующий элемент слева, если не ноль и сдвигаем на конец массива, если ноль
    private int nextLeftIndex(int index) {
        return index != 0 ? index - 1 : list.length - 1;
    }

    //сдвигает начало очереди наружу вне зависимости от порядка
    private int shiftBeginOutward(){
        return nextLeftIndex(begin);
    }

    //сдвигает конец очереди наружу вне зависимости от порядка
    protected int shiftEndOutward(){
        return nextRightIndex(end);
    }

    //сдвигает начало очереди внутрь вне зависимости от порядка
    private int shiftBeginInward(){
        return nextRightIndex(begin);
    }

    //сдвигает конец очереди внутрь вне зависимости от порядка
    private int shiftEndInward(){
        return nextLeftIndex(end);
    }

    //возвращает длину очереди - ноль, если нет элементов, или положительное, если не ноль
    //при не нулевой очереди всегда end != begin
    private int queueLength() {
        //если индексы начала и конца не равны
        if(end != begin && list[begin] != null && list[end] != null){
            //если есть, возвращаем количество элементов в очереди
            return isOrder() ? end - begin + 1: list.length - begin + end + 1;//e2 b5 = 8 (10 - 5 + 2 + 1)
        } else {//если равны
            //если они указывают на не нулевые элементы
            if (list[begin] != null && list[end] != null) {
                //значит в очереди один элемент
                return 1;
            } else {
                //если какой-то элемент нулевой, значит в очереди никого нет
                return 0;
            }
        }
    }

    //проверяем не пустой ли массив. Да - длина очереди равна нулю
    //Если пустой, уменьшаем его до дефолтной вместимости
    protected boolean isEmpty() {
        if(queueLength() == 0 && list.length > DEFAULT_CAPACITY){
            resetCapacity();
            return true;
        }
        return queueLength() == 0;
    }

    //уменьшаем массив до дефолтной вместимости
    private void resetCapacity() {
        Item[] tempArr = (Item[]) new Comparable[DEFAULT_CAPACITY];
        list = tempArr;
        //устанавливаем начальные значения начала и конца очереди
        initDeque();
    }

    //проверяем полностью ли заполнен массив. да - длина очереди равна длине массива
    protected boolean isFull() {
        return queueLength() == list.length;
    }

    //определяем какой порядок расположения.
    // Прямой порядок(true) - если конец очереди справа от начала или их индексы равны
    private boolean isOrder(){
        return end >= begin;
    }

    //увеличивает массив при полном его заполнении(создает новую копию большего размера)
    protected void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Comparable[newCapacity];
        //рассчитаваем приращение размера массива
        int delta = newCapacity - list.length;
        //если порядок в очереди прямой или длина очереди 1
        if(isOrder()){
            System.arraycopy(list, begin, tempArr, begin + delta / 2, queueLength());
            //вычисляем новые значения начала и конца очереди
            begin += delta / 2;
            end += delta / 2;
        } else {//если порядок очереди обратный
            //копируем левый кусок
            System.arraycopy(list, 0, tempArr, 0, end + 1);
            //копируем правый кусок
            System.arraycopy(list, begin, tempArr, begin + delta, list.length - begin);
            //вычисляем новые значения начала очереди(индекс конца не меняется)
            begin += delta;
        }
        list = tempArr;
    }

    //очистить очередь
    public void eraseQueue(){
        resetCapacity();
    }

    public Item[] getList() {
        return list;
    }

    public void setList(Item[] list) {
        this.list = list;
    }

    //возвращает размер массива
    public int size() {
        return list.length;
    }

    protected int getQueueLength() {
        return queueLength();
    }

    int getBegin() {
        return begin;
    }

    protected int getEnd() {
        return end;
    }

    protected void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(list[i] + " ");
        }
        return sb.toString();
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }
}
