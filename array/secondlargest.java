public class secondlargest {

    static int secondelement(int num[]){
        int first =0;
        int second =0;
        for(int i=0;i<num.length;i++){
            if(num[i]>first){
                second = first;
                first=num[i];
            }else if( num[i] != first && second<num[i] ){
                second=num[i];
            }
        }
        return second;
    }
    public static void main(String args[]){
        int arr[]={12,13,1,10,34,16};
        int ans =secondelement(arr);
        System.out.println(ans);
    }

}
