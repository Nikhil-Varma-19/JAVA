import java.util.*;
public class targetsum {
    public static void main(String[] args) {
        int[] array= {3,4,6,7,1};
        
        Scanner sc = new Scanner(System.in);
        int Targetsum= sc.nextInt();
        int pairs =0;
        for(int i=0;i<6;i++){
            for (int j =i+1; j<5; j++)
            {
               if (array[i]+array[j]==Targetsum)
               {  
                  pairs++;
               }  
            }
        }
         System.out.println("No of Pairs:"+pairs); 
    }
}
