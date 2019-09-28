package lesson1;

public class Person {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        int b = 8;

        Person p = new Person("Ivan");
        Person p1 = new Person("Ivan");

        if(p.equals(p1)){
            System.out.println("equals");
        }else{
            System.out.println("no equals");
        }
        System.out.println(p.hashCode());
        System.out.println(p1.hashCode());

        int a = 8;
        inc(a);
        System.out.println(a);

        Person p2 = new Person("Ivan");
        updateName(p2);
        System.out.println(p2.getName());
    }

    public static void updateName(Person p){
        p.setName("Super "+ p.getName());
    }

    public static void inc(int a){
        a++;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        return getName().equals(((Person) obj).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31;
    }
}
