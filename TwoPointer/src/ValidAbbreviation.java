public class ValidAbbreviation {

    /*

    Examples of valid abbreviations for "substitution":

        "s10n" - keeps 's' and 'n', replaces the middle 10 characters
        "sub4u4" - keeps "sub", replaces 4 characters, keeps "u", replaces 4 characters
        "12" - replaces all 12 characters
        "substitution" - no replacements, the full word itself

    Examples of invalid abbreviations:

        "s55n" - adjacent replacements (5 and 5 are next to each other)
        "s010n" - leading zero in the number 010
        "s0ubstitution" - tries to replace 0 characters (empty substring)

    */

    private  static boolean isAbbreviation(String word,String abb){
        if(word.equals(abb)) return true;
        int i=0,j=0;
        while (i < word.length() && j < abb.length() ){
            if(Character.isDigit(abb.charAt(j))){
                if(abb.charAt(j) == '0') return false;

                int curr=0;

                while (j < abb.length() && Character.isDigit(abb.charAt(j)) ){
                    curr = curr * 10 + (abb.charAt(j) - '0');
                    j++;
                }

                i+=curr;

            }else {
                if(abb.charAt(j) != word.charAt(i)) return false;
                i++;j++;
            }

        }

        return i == word.length() && j == abb.length();
    }

    public static void main(String[] args) {
        String word="apple";
        String abb="apple";
        System.out.println(isAbbreviation(word,abb));
    }
}
