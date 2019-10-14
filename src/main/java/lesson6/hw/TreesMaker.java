package lesson6.hw;

import java.util.Random;

//TODO less6hw.Added
class TreesMaker {
    private int numberOfTrees;//количество деревьев
    private MyTreeMap[] trees;//массив объектов деревьев
    private int maxTreeHeight;//заданная высота дерева
    private int[] treesHeights;//массив заданных высот деревьев

    //конструктор с дефолтными количеством одинаковых деревьев с дефолтной высотой
    TreesMaker() {
        numberOfTrees = 1;
        maxTreeHeight = 1;
        init();
    }

    //конструктор с заданным количеством одинаковых деревьев с дефолтной высотой
    TreesMaker(int numberOfTrees, int maxTreeHeight) {
        this.numberOfTrees = numberOfTrees;
        this.maxTreeHeight = maxTreeHeight;
        init();
    }

    //конструктор с заданным количеством одинаковых деревьев с дефолтной высотой
    TreesMaker(int[] treesHeights) {
        this.numberOfTrees = treesHeights.length;
        this.treesHeights = treesHeights;
        init(treesHeights);
    }

    /**
     * Метод инициализации для создания деревьев с одинаковой дефолтной высотой
     */
    private void init(){
        //инициируем пустой массив деревьев
        trees = new MyTreeMap[numberOfTrees];
        //создаем и наполняем деревья
        for (int i = 0; i < trees.length; i++) {

            System.out.println("***Creating tree #" + i + "***");

            MyTreeMap<Integer, Integer> mtm = new MyTreeMap<>();
            trees[i] = mtm;
            makeTree(trees[i], maxTreeHeight);

            System.out.println(toString(trees[i]));
        }
    }

    /**
     * Метод инициализации для создания деревьев с разными заданными высотами
     * @param treesHeights - массив заданных высот деревьев
     */
    private void init(int[] treesHeights){
        //инициируем пустой массив деревьев
        trees = new MyTreeMap[numberOfTrees];
        //создаем и наполняем деревья
        for (int i = 0; i < trees.length; i++) {

            System.out.println("***Creating tree #" + i + "***");

            MyTreeMap<Integer, Integer> mtm = new MyTreeMap<>();
            trees[i] = mtm;
            makeTree(trees[i], treesHeights[i]);

            System.out.println(toString(trees[i]));
        }
    }

    /**
     * Метод заполнения дерева случайными ключами в диапазоне от -100 до 100 и значениями
     * @param tree - текущее дерево для наполнения
     */
    private void makeTree(MyTreeMap<Integer, Integer> tree, int maxTreeHeight){
        Random random = new Random();
        //заполняем дерево пока его высота не станет равна заданной
        while(!isMaxHeight(tree, maxTreeHeight)){
            //генерируем случайные ключи в диапазоне от -100 до 100
            int key = random.nextInt(200) - 100;
            //инициируем значения(здесь не важно как)
            int value = key * 10;
            //добавляем узел в дерево(new Node создастся автоматически)
            tree.put(key, value);
        }
    }

    /**
     * Метод определяем достигло ли дерево максимальной высоты
     * @param tree - проверяемое дерево
     * @param maxHeight - заданная высота дерева
     * @return true - дерево достигло заданной высоты
     */
    private boolean isMaxHeight(MyTreeMap<Integer, Integer> tree, int maxHeight){
        return tree.height() >= maxHeight;
    }

    @Override
    public String toString(){
        if (trees == null || trees.length == 0) {
            return "There is no trees!";
        }
        StringBuilder sb = new StringBuilder();
        for (MyTreeMap tree: trees) {
            sb.append(toString(tree));
        }
        return sb.toString();
    }

    private String toString(MyTreeMap tree){
        if (tree == null) {
            return "";
        }
        return tree.toString() + "\nTree balance: " + tree.isBalanced() + "\n";
    }
}
