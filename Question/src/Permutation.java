/*
Print all permutation of string
eg: "abc"   ans = abc,acb,bac,bca,cab.cba
(same choices)


NewStr bzc the curr char ko hata ho or baki char sa choice lo
 */
public class Permutation {
    static void permutationprint(String s,String ans){
        if(s.length() == 0){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
             String NewStr=s.substring(0,i)+s.substring(i+1);// substring(startidx,endind) endidx not include
             permutationprint(NewStr,ans+curr);
        }


    }
    public static void main(String[] args) {
        String s="abc";
        permutationprint(s,"");
    }
}
