import java.util.HashMap;
import java.util.HashSet;

public class uniounANDintersection {
    private static void unioun(int arr1[],int arr2[]){
        HashSet<Integer> uni=new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            uni.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            uni.add(arr2[i]);
        }

        System.out.println("Unioun: "+uni.size());
    }

    private static void intersection(int arr1[],int arr2[]){
        int count=0;
        //using hashmap
    /*    HashMap<Integer,Integer> inter=new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            inter.put(arr1[i], inter.getOrDefault(arr1[i],0)+1);
        }
        for (int i = 0; i < arr2.length; i++) {
            inter.put(arr2[i], inter.getOrDefault(arr2[i],0)+1);
        }

        for (Integer num: inter.keySet()) {
            if(inter.get(num)>1) count++;
        }*/
//using hashset
        //if not make a method then use clear()
        HashSet<Integer> inters=new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            inters.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(inters.contains(arr2[i])){
                count++;
                inters.remove(arr2);
            }
        }
        System.out.println("Intersection: "+count);
    }
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,92,9,4};
        unioun(arr1,arr2);
        intersection(arr1,arr2);
    }
}
