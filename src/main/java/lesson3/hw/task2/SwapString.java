package lesson3.hw.task2;

import lesson3.hw.task1a.MyStack;
import java.io.IOException;

public class SwapString {
    private String inputString;
    private MyStack stack;

    SwapString(String inputString) throws IOException {
        this.inputString = inputString;
    }

    //переворачиваем строку задом на перед
    String swap(){
        turnStringIntoCharArray();
        StringBuilder sb = new StringBuilder();
        //преобразуем строку в массив символов в стеке
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    //переворачиваем строку задом на перед
    private void turnStringIntoCharArray(){
        int size = inputString.length();
        stack = new MyStack(size);
        //преобразуем строку в массив символов в стеке
        for (int i = 0; i < size; i ++){
            char ch = inputString.charAt(i);
            stack.push(ch);
        }

        //TODO Временно
        //System.out.println(stack.toString());

    }

    public String getInputString() {
        return inputString;
    }
}