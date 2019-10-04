package lesson3.hw.task1b;

import lesson3.hw.task3.MyDeque;

class MyPriorityQueue<Item extends Comparable> extends MyDeque {
    //индекс самого большого отсортированного элемента
    private int maxSortedIndex = 0;
    private Item maxSortedItem;

    public MyPriorityQueue() {
        super();
    }

    public MyPriorityQueue(int capacity) {
        super(capacity, 0);
    }

    void insert(Item item) {
        //добавляем элемент в конец очереди
        insertRightInternal(item);
        //сортируем очередь в соотвествии с приоритетом(самое большое справа)
        sortQueueByPriority();
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

    //сортируем очередь в соотвествии с приоритетом(самое большое справа)
    private void sortQueueByPriority(){
        int i = getEnd();
        int currentSortedIndex = maxSortedIndex;
        //максимальный элемент диапазона отсортированных элементов отличающихся на 1
        maxSortedItem = (Item)getList()[maxSortedIndex];
        //листаем всю очередь
        while (i > 0) {
            System.out.println("compareTo: " + getList()[i].compareTo(maxSortedItem));

            while (getList()[i].compareTo(getList()[i - 1]) < 0) {//правый меньше левого < 0
                swap(i, i - 1);
                i--;
            }

            /*//если проверяемый элемент больше максимального отсортированного элемента на 1
            if (getList()[i].compareTo(maxSortedItem) == 1) {//< 0
                //ищем совпадение и меняем
                while (getList()[i].compareTo(getList()[i - 1]) < 0) {//правый меньше левого < 0
                    swap(i, i - 1);
                    i--;
                }
            } else{
                //если правый(новый элемент) больше меняем индекс маскимального отсортированного элемента
                maxSortedIndex = i;
                //и выходим
                return;
            }*/
        }
        /*//после полной проверки обновляем индекс маскимального отсортированного элемента
        if(currentSortedIndex < maxSortedIndex){
            maxSortedIndex = currentSortedIndex;
        }*/

        /*

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

    //проверяем лежит ли
    private boolean isInSortedItemsDiapason(Item item) {

        return false;
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
