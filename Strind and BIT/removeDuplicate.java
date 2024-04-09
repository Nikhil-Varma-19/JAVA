public class removeDuplicate {
//     static void removeduplicate(String str,StringBuilder newStr,int idx,boolean map[] ){
//         if(idx >= str.length()){
//             System.out.println(newStr);
//         }
//
//         char currChar = str.charAt(idx);
//
//         if(map[currChar - 'a'] == true){
//                 removeduplicate(str,newStr,idx+1,map);
//         }else{
//             map[currChar -'a'] =true;
//             removeduplicate(str,newStr.append(currChar),idx+1,map);
//         }
//
//
//     }
public static void removeduplicate(String str,int idx,StringBuilder newStr,boolean map[]){

    if( idx == str.length()){
        System.out.println(newStr);
       return;//imppp
    }

    char currChar = str.charAt(idx);

    if(map[currChar - 'a']==true){
        removeduplicate(str,idx+1,newStr,map);
    }else{
        map[currChar - 'a']= true;
        removeduplicate(str,idx+1,newStr.append(currChar),map);
    }
}
//public static void removeduplicate(String str,int idx,StringBuilder newStr,boolean map[]){
//    if(idx == str.length()) {System.out.println(newStr); return;}
//    char currChar = str.charAt(idx);
//    if(map[currChar-'a']==true){
//        removeduplicate(str,idx+1,newStr,map);
//    }else{
//        map[currChar-'a']=true;
//        removeduplicate(str,idx+1,newStr.append(currChar),map);
//    }

//}
    public static void main(String[] args) {
      String s="nikhilkumarvarma";
//       StringBuilder newStr=new StringBuilder("");
//      boolean map[]=new boolean[26];
      
        removeduplicate(s,0,new StringBuilder(""),new boolean[26]);

//       removeduplicate(s,newStr,0,map);
    }
}
