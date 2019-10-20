package lesson8.classbook.linear;

class HashTable{
    private Item [] hashArr;
    private int arrSize;
    private Item nonItem;

    //TODO Correction.Added
    private int size;//текущий размер

    HashTable(int arrSize){
        this . arrSize = arrSize;
        hashArr = new Item [ arrSize ];
        nonItem = new Item (- 1 );

        //TODO Correction.Added
        size = 0;
    }

    //TODO Correction.Deleted
    /*public void display (){
        for ( int i = 0 ; i < arrSize ; i ++){
            if ( hashArr [ i ] != null ){
                System . out . println ( hashArr [ i ]. getKey ());
            } else {
                System . out . println ( "***" );
            }
        }
    }*/
    //TODO Correction.Added
    void display (){
        System.out.print("[");
        for (int i = 0; i < arrSize; i++){
            if (hashArr[i] != null){
                System.out.print(hashArr[i].getKey());
            } else{
                System.out.print("null");
            }
            if (i != arrSize - 1){
                System.out.print(", ");
            } else{
                System.out.println("]");
            }
        }
    }

    private int hashFunc(int key){
        return key % arrSize;
    }

    //TODO Correction.Deleted
    /*public void insert ( Item item ){
        int key = item . getKey ();
        int hashVal = hashFunc ( key );
        while (hashArr [ hashVal ] != null && hashArr [ hashVal ]. getKey () != - 1 ) {
            ++ hashVal;
            hashVal %= arrSize;
        }
        hashArr [ hashVal ] = item;
    }*/
    //TODO Correction.Added
    void insert ( Item item ){
        int key = item . getKey ();
        int hashVal = hashFunc ( key );
        while (hashArr [ hashVal ] != null && hashArr [ hashVal ] != nonItem ) {
            ++ hashVal;
            hashVal %= arrSize;
        }
        hashArr [ hashVal ] = item;
        size++;
    }

    Item delete ( int key ){
        int hashVal = hashFunc ( key );
        while ( hashArr [ hashVal ] != null ) {
            if ( hashArr [ hashVal ]. getKey () == key ){
                Item temp = hashArr [ hashVal ];
                hashArr [ hashVal ] = nonItem;

                //TODO Correction.Added
                size--;
                System.out.println("Deleted item: " + temp.getKey());

                return temp;
            }
            ++ hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    Item find ( int key ){
        int hashVal = hashFunc ( key );
        while ( hashArr [ hashVal ] != null ) {
            if ( hashArr [ hashVal ]. getKey () == key ){
                return hashArr [ hashVal ];
            }
            ++ hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    //Метод getPrime возвращает следующее простое число после текущего,
    // которое будет новой размерностью массива
    private int getPrime ( int min ){
        for ( int i = min + 1 ; true ; i ++)
            if ( isPrime ( i ))
                return i;
    }

    //Как правило, новый массив, должен быть вдвое больше предыдущего. Размер массива
    // должен быть простым числом, и его вычисление является частью процесса перехеширования
    private boolean isPrime ( int n ){
        for ( int j = 2 ; ( j * j <= n ); j ++)
            if ( n % j == 0)
                return false;
        return true;
    }

    //TODO Correction.Added
    boolean isFull() {
        return size >= arrSize;
    }


}
