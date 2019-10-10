package lesson5.hw.task2;

class Box {
    private int weight; //вес коробки
    private int value;//ценность коробки

    Box(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
