public class Judge extends ConnectFiveLogic  {


	private static char winner;
	
	//devuelve verdadero si el juego ha acabado
	public static boolean gameOver(char c,char [][] board) {
		
//		System.out.println("T-Lleno " + fullBoard(board) );
//		System.out.println("hor " + h5(c, board));
//		System.out.println("ver " + v5(c, board) );
//		System.out.println("diag "+ d5(c, board) );
		
		if(fullBoard(board) || h5(c,board) || v5(c,board) || d5(c,board))			
			return true;
		
		return false;
	}
	
	//devuelve verdadero si el tablero esta lleno
	private static boolean fullBoard(char [][] board) {
		
		for (int i = 0; i < board.length; i++) 
			for (int j = 0; j < board.length; j++) 
				if  (board[i][j]== ConnectFiveLogic.getEmpty()) 
					return false;
				
		
		return true;
		
	}
	
	//devuelve verdadero si hay 5 en linea horizontales de algun jugador 
	private static boolean h5 (char c,char [][] board) {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < 2; j++) {
				if(board[i][j] == c && board[i][j + 1] == c && board[i][j + 2] == c && board[i][j + 3] == c && board[i][j + 4] == c) 
					return true;
			}
		}
		return false;
	
	}
	
	
	//devuelve verdadero si hay 5 en linea verticales de algun jugador
	private static boolean v5 (char c,char [][] board) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == c && board[i + 1][j] == c && board[i + 2][j] == c && board[i + 3][j] == c && board[i + 4][j] == c) 
					return true;
			}
		}
		return false;
	}
	
	//devuelve verdadero si hay 5 en linea diagonales de algun jugador
	private static boolean d5 (char c,char [][] board) {
		
		if(board[0][0] == c && board[1][1] == c && board[2][2] == c && board[3][3] == c && board[4][4] == c)return true;
		else if(board[1][1] == c && board[2][2] == c && board[3][3] == c && board[4][4] == c && board[5][5] == c)return true;
		else if(board[1][0] == c && board[2][1] == c && board[3][2] == c && board[4][3] == c && board[5][4] == c)return true;
		else if(board[0][1] == c && board[1][2] == c && board[2][3] == c && board[3][4] == c && board[4][5] == c)return true;
		else if(board[0][5] == c && board[1][4] == c && board[2][3] == c && board[3][2] == c && board[4][1] == c)return true;
		else if(board[1][4] == c && board[2][3] == c && board[3][2] == c && board[4][1] == c && board[5][0] == c)return true;
		else if(board[0][4] == c && board[1][3] == c && board[2][2] == c && board[3][1] == c && board[4][0] == c)return true;
		else if(board[1][5] == c && board[2][4] == c && board[3][3] == c && board[4][2] == c && board[5][1] == c)return true;
		else return false;	
	}
	
	public static char getWinner() {
		
		return 'x';
		
	}
}
