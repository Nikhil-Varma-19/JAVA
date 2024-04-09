
public class maxsubarrysum {
    public static void subArray(int num[]){
            int currSum=0;
            int maxSum= Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            int start=i;
            for(int j=i;j<num.length;j++){
                int end=j;
                currSum=0;
                for(int k=start;k<=end;k++){
                   currSum += num[k];
                }
                System.out.println(currSum);
                if(maxSum < currSum){
                    maxSum = currSum;
                }
               
            }
            
       
    }
    System.out.println("Max Subarray sum is "+ maxSum);
  }
    public static void prefixsubArray(int num[]){
            int currSum=0;
            int maxSum= Integer.MIN_VALUE;
            int prefix[]=new int[num.length];
            prefix[0]=num[0];
            for(int i=1;i<prefix.length;i++){
                prefix[i]=prefix[i-1]+num[i];
            }
        for(int i=0;i<num.length;i++){
            int start=i;
            for(int j=i;j<num.length;j++){
                int end=j;
                currSum= start == 0 ? prefix[end]: prefix[end] - prefix[start - 1];
                
                if(maxSum < currSum){
                    maxSum = currSum;
                }
               
            }
            
       
    }
    System.out.println("Max Subarray sum is "+ maxSum);
  }

  public static void kadanes(int num[]){
        int crrSum = 0;
        int maxSum= Integer.MIN_VALUE;
    for(int i =0;i<num.length;i++){
            crrSum += num[i];
            maxSum= Math.max(crrSum,maxSum);
            if(crrSum<0) crrSum=0 ;
        }
    System.out.println("max sums is "+maxSum);



  }

    public static void main(String args[]){
        int num[]={-2,1,-3,4,-1,2,1,-5,4};
        //subArray(num);
      //  prefixsubArray(num);
         kadanes(num);
    }

}

