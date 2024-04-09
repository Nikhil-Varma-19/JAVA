public class Decoding {
    public static int countDecoding(String s,int n){
        if(n==0 || n==1) return 1;

        if(s.charAt(0) == '0') return 0;

        int count =0;

        if(s.charAt(n-1) >'0'){
            count=countDecoding(s,n-1);
        }

        if(s.charAt(n-2)== '2' || s.charAt(n-2) == '1' && s.charAt(n-2) <'7'){
            count += countDecoding(s,n-2);
        }
        return count;
    }
    public static int ans(String s,int n){

        if(n== 0 || (n==1 && s.charAt(0) == '0')){
            return 0;
        }
        return countDecoding(s,n);
    }
    public static void main(String[] args) {
        String s="111";
        int n =s.length();
        System.out.println(ans(s,n));
    }
}
