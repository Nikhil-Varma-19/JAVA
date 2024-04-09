import java.util.*;
public class Triplepair {
   
    public static void main(String[] args) {
        int[] array={5,2,3,2,1,4};
         Scanner sc = new Scanner(System.in);
     System.out.printf("Enter the triplets:");
      int triplets= sc.nextInt();
    int pairs3 = 0;

    for (int i = 0; i < array.length; i++){
        for (int j = i+1; j< array.length; j++)
        {
          for (int k = j+1; k < array.length; k++)
          {
            if(array[i]+array[j]+array[k]==triplets){
              pairs3++;
            }
          }
          
        }
    }
    System.out.println("No of pairs:"+pairs3);
    }
}
