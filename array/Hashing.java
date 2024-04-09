
public class Hashing {
    public static void main(String args[]){
        // HashMap<String,Integer> map = new HashMap<>();

        // map.put("India",10);
        // map.put("China",9);
        // map.put("UK",7);

        // System.out.println(map);
        // System.out.println(map.get("India"));

        int num[]={7,1,5,3,6,4};

        int ans =0;

        for(int i=0;i<num.length;i++){
            int buy=num[i];
            for(int j=i+1;j<num.length;j++){
                int sell= num[j];
                if(sell - buy >ans ){
                    ans = sell - buy;
                }
            }
        }

        System.out.println(ans);
        
    }
}
