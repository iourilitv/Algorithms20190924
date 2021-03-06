package lesson6.hw;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;//корневой узел - вершина дерева

    /**
     * Внутренний класс определяющий узлы дерева
     */
    private class Node {
        Key key;//ключ узла
        Value value;//значение узла
        Node left;//левый потомок узла
        Node right;//правый потомок узла
        int size;//размер дерева

        //TODO less6hw.Added
        int height;//высота дерева
        boolean balance;//сбалансированность дерева

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;//как только создали корень, размер дерева стал 1
            height = 0;//при создании любого узла - его высота равна 0
            balance = true;//при создании любого узла он считается сбалансированным
        }
    }

    /**
     * Публичный метод начала получения размера дерева
     * @return размер дерева
     */
    public int size() {
        //запускаем рекурсивный метод получения размера, начиная с корня
        return size(root);
    }

    /**
     * Рекурсивный метод получения размера дерева
     * @param node - текущий узел(вершина)
     * @return размер текущего поддерева(узла)
     */
    private int size(Node node) {
        //базовый случай рекурсии, дошли до нулевого узла, возвращаем 0
        if (node == null) {
            return 0;
        }
        //возвращаем размер текущего поддерева
        return node.size;
    }

    //TODO less6hw.Added
    /**
     * Публичный метод начала получения высоты дерева
     * @return размер дерева
     */
    int height() {
        return height(root);
    }

    //TODO less6hw.Added
    /**
     * Рекурсивный метод получения высоты дерева
     * @param node - текущий узел(вершина)
     * @return высота текущего поддерева(узла)
     */
    private int height(Node node) {
        //базовый случай рекурсии, дошли до нулевого узла или узла нулевой высотой, возвращаем 0
        if (node == null) {//начальный случай, когда даже root еще не создан
            return 0;
        }
        //возвращаем высоту текущего поддерева
        return node.height;
    }

    //TODO less6hw.Added
    /**
     * Публичный метод начала получения сбалансированности дерева
     * @return true - дерево сбалансировано(разница высот его детей не превышает 1)
     */
    boolean isBalanced() {
        return isBalanced(root);
    }

    //TODO less6hw.Added
    /**
     * Рекурсивный метод получения сбалансированности дерева
     * @param node - текущий узел(вершина)
     * @return true - дерево сбалансировано(разница высот его детей не превышает 1)
     */
    private boolean isBalanced(Node node) {
        //базовый случай рекурсии, дошли до нулевого узла или узла нулевой высотой, возвращаем 0
        if (node == null) {//начальный случай, когда даже root еще не создан
            return true;
        }
        //если любой узел потомок несбалансирован, то все дерево - несбалансировано
        //возвращаем сбалансированность текущего поддерева
        return node.balance;
    }

    /**
     * Метод проверки не пустое ли дерево
     * @return true - дерево пустое(корня нет)
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Метод проверки на пустой ключ
     * @param key - проверяемый ключ
     */
    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key не должен быть null");
        }
    }

    /**
     * Публичный метод поиска, содержится ли элементт в дереве
     * @param key - ключ проверяемого элемента
     * @return true - узел с таким ключем есть в дереве
     */
    public boolean contains(Key key) {
        //запускаем рекурсивный метод поиска узла по ключу, начиная с корня
        return get(root, key) != null;
    }

    /**
     * Публичный метод поиска узла по ключу
     * @param key - ключ проверяемого элемента
     * @return значение найденного узла
     */
    public Value get(Key key) {
        //запускаем рекурсивный метод поиска узла по ключу, начиная с корня
        return get(root, key);
    }

    /**
     * Рекурсивный метод поиска узла по ключу
     * @param node - текущий (проверяемый) узел
     * @param key - ключ узла, который ищем
     * @return значение найденного узла
     */
    private Value get(Node node, Key key) {
        isKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    /**
     * Публичный метод добавления узла в дерево
     * @param key - ключ узла на добавление
     * @param value - значение узла на добавление
     */
    void put(Key key, Value value) {
        //TODO временно
        System.out.println("putting the key: " + key);

        //ключ и значение не должны быть пустыми
        isKeyNotNull(key);
        if (value == null) {
            //выходим
            return;
        }
        //запускаем рекурсивный метод добавления узла, начинай с корня
        root = put(root, key, value);
    }

    /**
     * Рекурсивный метод добавления узла в дерево
     * @param node - текущий узел на добавление
     * @param key - ключ узла на добавление
     * @param value - значение узла на добавление
     * @return добавленный узел
     */
    private Node put(Node node, Key key, Value value) {
        //базовый случай рекурсии
        if (node == null) {
            //возвращаем новый узел с ключем и значением
            return new Node(key, value);
        }
        //запоминаем результат сравнения искомого ключа с текущим ключем
        int cmp = key.compareTo(node.key);
        //если искомый ключ - это текущий(нашли узел с таким же ключем)
        if (cmp == 0) {
            //просто меняем у узла значение на новое
            node.value = value;
        //если искомый ключ меньше текущего
        } else if (cmp < 0) {
            //ищем в ветке с левым потомком
            node.left = put(node.left, key, value);
        //если искомый ключ больше текущего
        } else {
            //ищем в ветке с правым потомком
            node.right = put(node.right, key, value);
        }

        //TODO less6hw.Deleted
        //пересчитываем размер дерева
        //node.size = size(node.left) + size(node.right) + 1;
        //TODO less6hw.Added
        //пересчитываем размер, высоту и сбалансированность дерева
        recalculate(node);

        //возврашаем добавленный узел
        return node;
    }

    //TODO less6hw.Added
    /**
     * Метод пересчета размера, высоты и сбалансированности дерева
     * @param node - текущий узел
     */
    private void recalculate(Node node) {
        calculateSize(node);
        calculateHeightAndBalance(node);
    }

    //TODO less6hw.Added
    /**
     * Рекурсивный метод расчета размера дерева
     * @param node - текущий узел
     */
    private void calculateSize(Node node) {
        //пересчитываем размер дерева
        node.size = size(node.left) + size(node.right) + 1;
    }

    //TODO less6hw.Added
    /**
     * Рекурсивный метод расчета высоты и баланса дерева
     * @param node - текущий узел
     */
    private void calculateHeightAndBalance(Node node) {
        //пересчитываем высоты детей дерева
        int leftH = height(node.left);
        int rightH = height(node.right);
        //пересчитываем высоту самого дерева
        calculateHeight(node, leftH, rightH);
        //если высота одно из деревьев отличается от другого больше, чем на 1, дерево несбалансированно.
        calculateBalance(node, leftH, rightH);
    }

    //TODO less6hw.Added
    /**
     * Метод расчета высоты дерева
     * @param node - текущий узел
     */
    private void calculateHeight(Node node, int leftH, int rightH) {
        //высота равна высоте самого большого плеча + 1
        node.height = Math.max(leftH, rightH) + 1;
    }

    //TODO less6hw.Added
    /**
     * Метод расчета сбалансированности дерева
     * @param node - текущий узел
     */
    private void calculateBalance(Node node, int leftH, int rightH) {
        //если высота одно из деревьев отличается от другого больше, чем на 1, то
        // дерево несбалансированно
        node.balance = !(Math.abs(leftH - rightH) > 1);
    }

    /**
     * Публичный метод поиска узла с самым маленьким ключем
     * @return - узет с наименьшим ключем
     */
    public Key minKey() {
        return min(root).key;
    }

    /**
     * Рекурсивный метод поиска узла с самым маленьким ключем
     * @param node - текущий (проверяемый) узел
     * @return - текущий узел
     */
    private Node min(Node node) {
        //базовый случай рекурсии, возвращаем текущий узел, если дошли до конца
        if (node.left == null) {
            return node;
        }
        //идем дальше влево
        return min(node.left);
    }

    /**
     * Публичный метод поиска узла с самым большим ключем
     * @return - узет с самым большим ключем
     */
    public Key maxKey() {
        return max(root).key;
    }

    /**
     * Рекурсивный метод поиска узла с самым большим ключем
     * @param node - текущий (проверяемый) узел
     * @return - текущий узел
     */
    private Node max(Node node) {
        //базовый случай рекурсии, возвращаем текущий узел, если дошли до конца
        if (node.right == null) {
            return node;
        }
        //идем дальше вправо
        return max(node.right);
    }

    /**
     * Рекурсивный метод удаления узла с самым маленьким ключем
     * @param node - проверяемый узел
     * @return - текущий узел
     */
    private Node deleteMin(Node node) {
        //базовый случай рекурсии, если слева пусто
        if (node.left == null) {
            //возвращаем правого потомка
            return node.right;
        }
        //рекурсивно идем все левее и левее пока не дойдем до конца
        //и удаляем узел с самым маленьким ключем(в идеале - самый левый)
        node.left = deleteMin(node.left);

        //TODO less6hw.Deleted
        //пересчитываем размер дерева после удаления узла
        //node.size = size(node.left) + size(node.right) + 1;
        //TODO less6hw.Added
        //пересчитываем размер, высоту и сбалансированность дерева
        recalculate(node);

        //возвращаем удаленный узел
        return node;
    }

    /**
     * Публичный метод удаления узла
     * @param key - ключ узла на удаление
     */
    void delete(Key key) {
        //проверяем не пустой ли ключ
        isKeyNotNull(key);
        //запускаем рекурсивный метод удаления
        delete(root, key);
    }

    /**
     * Рекурсивный метод удаления узла дерева
     * @param node - текущий узел
     * @param key - ключ узла на удаление
     * @return удаленный узел
     */
    private Node delete(Node node, Key key) {
        //базовый случай рекурсии - дошли до конца ветки
        if (node == null) {
            //возвращаем null, если узел пустой
            return null;
        }
        //запоминаем результат сравнения искомого ключа с текущим ключем
        int cmp = key.compareTo(node.key);
        //если искомый ключ меньше текущего
        if (cmp < 0) {
            //идем в левое плечо
            node.left = delete(node.left, key);
        //если искомый ключ больше текущего
        } else if (cmp > 0) {
            //идем в правое плечо
            node.right = delete(node.right, key);

        //***они равны - нашли узел для удаления
        } else {
            //**если у узла нет левого плеча
            if (node.left == null) {
                //возвращаем правый узел
                return node.right;
            }
            //**если у узла нет правого плеча
            if (node.right == null) {
                //возвращаем левый узел
                return node.left;
            }
            //**если у удаляемого узла есть оба потомка, то меняем его на самый маленький в правом плече
            //запоминаем удаляемый узел
            Node temp = node;
            //меняем узел на самый маленький в правом плече
            node = min(node.right);
            //прописываем у него ссылку на правого потомка
            node.right = deleteMin(temp.right);
            //прописываем у него ссылку на левого потомка
            node.left = temp.left;

        }

        //TODO less6hw.Deleted
        //пересчитываем размер дерева
        //node.size = size(node.left) + size(node.right) + 1;
        //TODO less6hw.Added
        //пересчитываем размер, высоту и сбалансированность дерева
        recalculate(node);

        //возвращаем удаленный узел, если нашли
        return node;
    }

    //начинает вывод элементов дерева, начиная с корня, далее рекурсивно выводятся остальные элементы
    @Override
    public String toString() {
        return toString(root);
    }

    //рекурсивный метод вывода элементов(вершин, узлов) дерева
    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        //сначала выводим все левые, начиная с самого левого, затем правые,
        // возвращаясь от самого левого на верх
        return toString(node.left) +
                node.key.toString() + "(" + node.value.toString() + ")" + ", " +
                toString(node.right);


    }

}
