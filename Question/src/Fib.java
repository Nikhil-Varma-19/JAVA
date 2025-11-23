import java.util.*;

public class Fib {
  public static void main(String[] args) {
    // Input string containing digits
    String a = "145367";

    // Split the string into an array of individual characters (digits)
    String[] arr = a.split("");
  int ans=0;
    // Create an integer array of the same length to store the digits as integers
    int[] arr1 = new int[arr.length];

    // Convert each character in the string array to an integer and store it in the integer array
    for (int i = 0; i < arr.length; i++) {
      arr1[i] = Integer.parseInt(arr[i]);
      ans=ans^arr1[i];
    }
    System.out.println(ans);


  }
}

