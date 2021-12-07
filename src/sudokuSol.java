public class sudokuSol{
	private static final int Grid_size = 9;
	public static void main(String[] args) {
	    int[][] board = {
	            {7, 0, 2, 0, 5, 0, 6, 0, 0},
	            {0, 0, 0, 0, 0, 3, 0, 0, 0},
	            {1, 0, 0, 0, 0, 9, 5, 0, 0},
	            {8, 0, 0, 0, 0, 0, 0, 9, 0},
	            {0, 4, 3, 0, 0, 0, 7, 5, 0},
	            {0, 9, 0, 0, 0, 0, 0, 0, 8},
	            {0, 0, 9, 7, 0, 0, 0, 0, 5},
	            {0, 0, 0, 2, 0, 0, 0, 0, 0},
	            {0, 0, 7, 0, 4, 0, 2, 0, 3} 
	          };
	        
	        printBoard(board);
	        
	        if (solveBoard(board)) {
	          System.out.println("Solved successfully!");
	        }
	        else {
	          System.out.println("Unsolvable board :(");
	        }
	        
	        printBoard(board);
	        
	}
	private static boolean isNoInRow(int[][] board, int no, int row) {
		for(int i=0;i<Grid_size; i++ )
			if(board[row][i] == no)
				return true;
		return false;
	}
	private static boolean isNoInCol(int[][] board, int no, int col) {
		for(int i=0;i<Grid_size; i++ )
			if(board[i][col] == no)
				return true;
		return false;
	}
	private static boolean isNoInMatrix(int[][] board, int no, int row, int col) {
		int localRow = row - row % 3;
		int localCol = col - col% 3;
		for(int i=localRow;i<localRow+3; i++ )
			for(int j=localCol;j<localCol+3; j++ )
				if(board[i][j] == no)
					return true;
		return false;
	}
	private static boolean isValidPlacement(int[][] board, int no, int row, int col) {
	return (!isNoInRow(board,no,row)&&!isNoInCol(board,no,col)&&!isNoInMatrix(board,no,row,col));
	}
	
	private static boolean solveBoard(int[][] board) {
		for(int i = 0; i<Grid_size;i++) {
			for(int j = 0 ; j<Grid_size ; j++) {
				if(board[i][j]==0) {
					for(int k=1;k<=9;k++) {
						if(isValidPlacement(board,k,i,j)) {
							board[i][j] = k;
							if(solveBoard(board))
								return true;
							board[i][j] = 0;
							
						}
					}
					return false;
				}
			}
				
		}
			
		return true;
	}
	private static void printBoard(int[][] board) {
		for(int i = 0 ; i<Grid_size; i++ ) {
			if(i%3==0 && i!=0)
				System.out.println("---------");
			for(int j=0;j<Grid_size; j++) {
				if(j%3==0 && j!=0)
					System.out.print(" | ");
				System.out.print(board[i][j] + " ");
			}
		System.out.println();
		}	
	}
	
}