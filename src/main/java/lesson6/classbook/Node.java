package lesson6.classbook;

class Node{
    public Person person;
    public Node leftChild;
    public Node rightChild;
    public void display (){
        System . out . println ( "Name: " + person . name + ", age: " + person . age );
    }
}
