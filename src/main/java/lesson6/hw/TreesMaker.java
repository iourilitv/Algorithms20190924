package lesson6.hw;

import java.util.Random;

//TODO less6hw.Added
public class TreesMaker {
    private int numberOfTrees;//количество деревьев
    private MyTreeMap[] trees;//массив объектов деревьев
    private final int height;//высота дерева

    public TreesMaker(int numberOfTrees) {
        this.numberOfTrees = numberOfTrees;
        height = 6;
    }

    void init(){
        //инициируем пустой массив деревьев
        trees = new MyTreeMap[numberOfTrees];
        //создаем и наполняем деревья
        for (int i = 0; i < trees.length; i++) {
            MyTreeMap<Integer, Integer> mtm = new MyTreeMap<>(height);
            trees[i] = mtm;
            makeTree(trees[i]);
        }
    }

    private void makeTree(MyTreeMap<Integer, Integer> tree){
        Random random = new Random();
        //заполняем дерево пока его высота не станет равна заданной
        while(!isMaxHeight(tree, tree.height())){//FIXME добавить условие для height
            //генерируем случайные ключи в диапазоне от -100 до 100
            int key = random.nextInt(200) - 100;
            //инициируем значения(здесь не важно как)
            int value = key * 10;
            //добавляем узел в дерево(new Node создастся автоматически)
            tree.put(key, value);

        }
    }

    private boolean isMaxHeight(MyTreeMap<Integer, Integer> tree, int height){
        return false;
    }
}
