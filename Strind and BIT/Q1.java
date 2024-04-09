import java.util.Scanner;

public class Q1 {
    static void addDot(StringBuilder input){

        String a[]=input.toString().split(" ");
        input.setLength(0);
        for (int i=a.length -1 ;i>=0;i--){
            input.append(a[i]);

            if(i >0){
                input.append(".");
            }
        }
        System.out.println(input);
    }
    public static void main(String[] args) {

       // String input ="winner make lose you";
        StringBuilder input =new StringBuilder("winner make lose you");
       addDot(input);

    }

}


