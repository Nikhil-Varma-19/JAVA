public class usenameVaild {
    public static String CodelandUsernameValidation(String str) {
        String ans = "true";
        if (str.length() < 4 || str.length() > 26) {
            ans = "false";
            return ans;
        }
        int c=str.charAt(0);
        if(!((c>='a' && c<='z')||(c>='A' && c<='Z'))){
            ans = "false";
            return ans;
        }

        if ( (str.charAt(str.length() - 1) == '_')) {
            ans = "false";
            return ans;
        }
         str = str.replaceAll("[_0-9A-Za-z]", "");
        if (str.length() != 0) {
            ans = "false";
            return ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "A__hello_world123";
        System.out.println(CodelandUsernameValidation(s));;

    }
}
