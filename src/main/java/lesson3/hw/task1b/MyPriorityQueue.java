package lesson3.hw.task1b;

import lesson3.hw.task3.MyDeque;

class MyPriorityQueue<Item extends Comparable> extends MyDeque {
    //private Item[] list = (Item[])super.getList();

    public MyPriorityQueue() {
        super();
    }

    public MyPriorityQueue(int capacity) {
        super(capacity, 0);
    }

    void insert(Item item) {
        insertRightInternal(item);

        int i = getEnd();
        while (i > 0 && getList()[i].compareTo(getList()[i - 1]) < 0) {//правый меньше левого < 0
            swap(i, i - 1);
            i--;
        }

        /*int sortedMinIndex = -1;
        int sortedMaxIndex = size + 1;

        list[size] = item;
        size++;
        int i = size - 1;

        while (i > 0 && list[i].compareTo(list[i - 1]) < 0) {//(list[i]//правый меньше// - list[i - 1]) < 0

            //если проверяемый элемент больше индекса максимального элемента в сортированной части на 1
            if(0 <= list[i].compareTo(list[sortedMaxIndex]) && list[i].compareTo(list[sortedMaxIndex]) <= 1){
                sortedMaxIndex = i;
                break;
            }else{
                swap(i, i - 1);
            }
            i--;
        }*/
    }

    //добавляем элемент в конец очереди(справа при нормальном порядке)
    private void insertRightInternal(Item item) {
        if (isFull()) {
            //если массив заполнен полностью, увеличиваем его
            reCapacity(getList().length + getDEFAULT_CAPACITY());
        }
        //сдвигаем хвост очереди наружу, кроме случая если очередь пустая
        if(!isEmpty()){
            setEnd(shiftEnd());
        }
        getList()[getEnd()] = item;
    }

    public Item remove() {
        return (Item)super.removeRight();
    }

    Item peek() {
        return (Item)super.peekRight();
    }

    //размер массива
    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    //увеличивает массив при полном его заполнении(создает новую копию большего размера)
    @Override
    protected void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Comparable[newCapacity];
        //рассчитаваем приращение размера массиа
        //int delta = newCapacity - list.length;
        //если порядок в очереди прямой или длина очереди 1
        System.arraycopy(getList(), 0, tempArr, 0, getQueueLength());
        super.setList(tempArr);
    }

    private void swap(int index1, int index2) {
        Item temp = (Item)getList()[index1];
        getList()[index1] = getList()[index2];
        getList()[index2] = temp;
    }

    //сдвигает конец очереди наружу вне зависимости от порядка
    private int shiftEnd(){
        return super.shiftEndOutward();
    }


}
