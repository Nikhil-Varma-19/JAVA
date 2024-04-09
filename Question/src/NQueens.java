import java.util.Scanner;
// But to print the aonly one possible solution then can the
/*
*  1. change the data type of Nqueens to boolean and return true && print2DArry comment
*  2. function call step (recurision call) ko if statement ma karo aur retuem true ;
*
*/


public class NQueens {
    static  int count=0;
    static boolean isSafe(char[][] board,int row,int col)
    {
        //vertically up check
        for (int i = row-1; i >=0 ; i--) {
            if(board[i][col]=='Q') return false;
        }
        // diag left up

        for (int i=row-1,j=col-1; i>=0 && j>=0;i--,j--){
            if (board[i][j]== 'Q') {
                return false;
            }
        }

        //diag right up
        for(int i=row-1,j=col+1;i>=0 && j< board.length;i--,j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
    static boolean Nqueens(char[][] board,int row){
        //base
        if(row == board.length){
           // print2Darr(board);
            count++;
            return true;
        }

        for (int i=0;i< board.length;i++){
           if(isSafe(board,row,i)){
               board[row][i]='Q';
               if(Nqueens(board,row+1))  return true; // function call remain
               board[row][i]='-';//backtracking step
           }

        }
        return false;
    }
    static void print2Darr(char [][] board){
        System.out.println("-------------chess Board ------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.printf(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
       // int n =4;
        //chaseboard
        char [][] chaseBoard=new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 chaseBoard[i][j]='-';
            }
        }

        if(Nqueens(chaseBoard,0)){
            System.out.println("Possible solution");
            print2Darr(chaseBoard);
        }else{
            System.out.println("Not Possible solution");
         }

       // System.out.println("total way Queen can place is "+count);

    }
}
