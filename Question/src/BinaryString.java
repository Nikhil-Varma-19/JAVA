import java.util.Scanner;
/*
* Print all the binary strings of size N without consecution ones { 1001011 so at last the 1 and 1 are come one after other so not to print }
* eg: n= 2   so  "00" "01" "10"
* */
public class BinaryString {
    static void binaryprint(int n,int lastidx,String str){
        if( n==0) {
            System.out.println(str);
            return;
        }
        binaryprint(n-1,0,str+"0");

        if(lastidx ==0){
            binaryprint(n-1,1,str+"1");
        }


    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.printf("Enter the number: ");
        int n = sc.nextInt();

        binaryprint(n,0,"");

    }
}
