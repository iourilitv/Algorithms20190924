package lesson5.hw.task2.draft;

import java.util.Arrays;

class Packer {
    private Box[] boxes;//массив объектов коробок, которые нужно уложить
    private Knapsack knapsack;//объект рюкзака
    private int[] weights;//массив весов всех вещей
    private int[] values;//массив ценностей всех вещей

    Packer(Box[] boxes, Knapsack knapsack) {
        this.boxes = boxes;
        this.knapsack = knapsack;
        this.weights = createWeights();
        this.values = createValues();
    }

    private int[] createWeights(){
        int[] weights = new int[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            weights[i] = boxes[i].getWeight();
        }

        //TODO временно
        System.out.println("weights: " + Arrays.toString(weights));

        return weights;
    }

    private int[] createValues(){
        int[] values = new int[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            values[i] = boxes[i].getValue();
        }

        //TODO временно
        System.out.println("values:  " + Arrays.toString(values));

        return values;
    }


    int[] fillKnapsack() {
        //int[] knapsack = new int[boxes.length];
        
        //return knapsack;
        return null;
    }
}
