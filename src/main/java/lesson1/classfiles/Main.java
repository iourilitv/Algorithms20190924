package lesson1.classfiles;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        String[] logins = {"dfg","fgdf", "string"};

        //System.out.println(uniq(logins, "string"));

        System.out.println("counter: " + someThink());
    }

    static boolean uniq(String[] logins, String userLogin){
        for (int i = 0; i < logins.length; i++) {
            if(userLogin.equals(logins[i])){
                return false;
            }
        }
        return true;
    }

    public static int someThink(){
        int n = 10000;
        int k = 0;
        int[] arr = new int[n];

        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]){
                    k++;
                }
            }
        }
        return k;
    }
}
