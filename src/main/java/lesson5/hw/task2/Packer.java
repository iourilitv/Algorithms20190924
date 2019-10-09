package lesson5.hw.task2;

class Packer {
    private Box[] boxes;//массив объектов коробок, которые нужно уложить
    private Knapsack knapsack;//объект рюкзака

    Packer(Box[] boxes, Knapsack knapsack) {
        this.boxes = boxes;
        this.knapsack = knapsack;
    }
}
