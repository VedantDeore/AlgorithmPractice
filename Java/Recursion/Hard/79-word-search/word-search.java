class Solution {
    private static boolean searchNext(int row,int col,char board[][], String word, int index, int m, int n){
        if(index == word.length()){
            return true;
        }

       if(row<0 || col<0 || row==m || col ==n || board[row][col] != word.charAt(index) || board[row][col] == '!')return false;

       char c = board[row][col];
       board[row][col] = '!';

       boolean top = searchNext(row-1,col,board,word,index+1,m,n);
       boolean right= searchNext(row,col+1,board,word,index+1,m,n);
       boolean bottom=searchNext(row+1,col,board,word,index+1,m,n);
       boolean left= searchNext(row,col-1,board,word,index+1,m,n);

       board[row][col] =c;

       return top || right || bottom || left;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int index=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(searchNext(i,j,board,word,index,m,n)){
                    return true;
                }
            }
        }
        return false;
    }
}