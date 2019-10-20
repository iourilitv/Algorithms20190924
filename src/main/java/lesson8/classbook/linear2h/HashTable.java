package lesson8.classbook.linear2h;

class HashTable{
    private Item [] hashArr;
    private int arrSize;
    private Item nonItem;

    HashTable(int size){
        this . arrSize = size;
        hashArr = new Item [ arrSize ];
        nonItem = new Item (- 1 );
    }

    void display (){
        for ( int i = 0 ; i < arrSize ; i ++){
            if ( hashArr [ i ] != null ){
                System . out . println ( hashArr [ i ]. getKey ());
            } else {
                System . out . println ( "***" );
            }
        }
    }

    private int hashFunc(int key){
        return key % arrSize;
    }

    private int hashFuncDouble(int key){
        return 5 - key % 5;
    }

    void insert ( Item item ){
        int key = item . getKey ();
        int hashVal = hashFunc ( key );
        int stepSize = hashFuncDouble ( key );
        while ( hashArr [ hashVal ] != null && hashArr [ hashVal ]. getKey () != - 1 ) {
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArr [ hashVal ] = item;
    }

    Item delete(int key){
        int hashVal = hashFunc ( key );
        int stepSize = hashFuncDouble ( key );
        while ( hashArr [ hashVal ] != null ) {
            if ( hashArr [ hashVal ]. getKey () == key ){
                Item temp = hashArr [ hashVal ];
                hashArr [ hashVal ] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    Item find ( int key ){
        int hashVal = hashFunc ( key );
        int stepSize = hashFuncDouble ( key );
        while ( hashArr [ hashVal ] != null ) {
            if ( hashArr [ hashVal ]. getKey () == key ){
                return hashArr [ hashVal ];
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    private int getPrime ( int min ){
        for ( int i = min + 1 ; true ; i ++)
            if ( isPrime ( i ))
                return i;
    }

    private boolean isPrime ( int n ){
        for ( int j = 2 ; ( j * j <= n ); j ++)
            if ( n % j == 0)
                return false;
        return true;
    }
}
