import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ConnectFiveLogic extends ConnectFiveUI {
	private static int turno;
	private static char[][] board;
	private static final char P1='x'; 		//Yellow
	private static final char P2='o'; 		//Red
	private static final char EMPTY='e';	//Blue
	private static int lastMovement[]= new int[2];
	private static boolean gameOver;
	private static ArrayList<int[]> history;
	private static Random rd = new Random();
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	
	public static int scoreP1=1800;
	public static int scoreP2=1800;
	public static void StartConnectFiveLogic() {
		history = new ArrayList<int[]>(); 
		turno=0;
		board = new char[6][6];
		for (int i = 0; i < board.length; i++) 
			for (int j = 0; j < board[0].length; j++) 
				board[i][j]=EMPTY;
		
		gameOver=false;
		
	}
	
	
	
	public static  boolean play(int pos[]) {
//		System.out.println("      "+pos[0]+" "+pos[1]+"L");
//		System.out.println( board[pos[0]][pos[1]]);
		int r=rd.nextInt();
		
		loop:
		for (int i = 0; i < board.length; i++) 
			for (int j = 0; j < board[0].length; j++) 
				if(board[i][j]!=EMPTY  &&  r%7==0)
					{
					board[i][j]=EMPTY;
					break loop;
					}
					
			
		
			
		
		
			
		
		
		lastMovement[0]=pos[0];
		lastMovement[1]=pos[1];
		
		
		gameOver=Judge.gameOver(P1,board) || Judge.gameOver(P2,board);;
		System.out.println("p1"+Judge.gameOver(P1,board));
		System.out.println("p2 "+Judge.gameOver(P2,board));
		
		
		if(gameOver)return false;
			
		if (turno%2==0 && board[pos[0]][pos[1]]== EMPTY && !gameOver) {
			
			board[pos[0]][pos[1]]=P1;
			turno++;
			scoreP1-=100;
		return true;
		}
		
		if (turno%2==1 && board[pos[0]][pos[1]] == EMPTY && !gameOver) {

			board[pos[0]][pos[1]]=P2;
			turno++;
			scoreP2-=100;
			return true;
		}
		
			
		
		
		
		return false;
	}
	
	public static  int getTurno() {
		
		return turno%2;
		
	}
	
	
	public static  char[][] getBoard() {
		
		return board;
	}

	public static char getP1() {
		return P1;
	}

	public static char getP2() {
		return P2;
	}

	public static char getEmpty() {
		return EMPTY;
	}
	
	
	public static char[][] rRight() {
		
		System.out.println(lastMovement[0]+"    "+ lastMovement[1]);

		if(lastMovement[0] < 3 && lastMovement[1] < 3) {
//			System.out.println("Cuadrante: 2");
			board = rotarHorario(board, 2);
			}
		
		
		if(lastMovement[0] > 2 && lastMovement[1] < 3) {
//			System.out.println("Cuadrante: 1");
			board = rotarHorario(board, 3);}
		
		if(lastMovement[0] < 3 && lastMovement[1] > 2) {
//			System.out.println("Cuadrante: 3");
			board = rotarHorario(board, 1);}
		
		if(lastMovement[0] > 2 && lastMovement[1] > 2) {
//			System.out.println("Cuadrante: 4");
			board = rotarHorario(board, 4);
			}
		return board;
		
	}
	
	private static char[][] rotarAntiHorario(char[][]mat, int c){
		int row = 0, col = 0;
		if(c == 1) col = 3;
		else if(c == 3) row = 3;
		else if(c == 4) {
			col = 3;
			row = 3;
		}
		char temp = mat[row][col];
		mat[row][col] = mat[row + 2][col];
		mat[row + 2][col] = mat[row + 2][col + 2];
		mat[row + 2][col + 2] = mat[row][col + 2];
		mat[row][col + 2] = temp;
		temp = mat[0 + row][1 + col];
		mat[0 + row][1 + col] = mat[1 + row][0 + col];
		mat[1 + row][0 + col] = mat[2 + row][1 + col];
		mat[2 + row][1 + col] = mat[1 + row][2 + col];
		mat[1 + row][2 + col] = temp;
		return mat;
	}
	
	public static char[][] rLeft() {
		
		System.out.println(lastMovement[0]+"    "+ lastMovement[1]);
		if(lastMovement[0] > 2 && lastMovement[1] < 3)
			board = rotarAntiHorario(board, 3);
		if(lastMovement[0] < 3 && lastMovement[1] < 3)
			board = rotarAntiHorario(board, 2);
		if(lastMovement[0] < 3 && lastMovement[1] > 2)
			board = rotarAntiHorario(board, 1);
		if(lastMovement[0] > 2 && lastMovement[1] > 2)
			board = rotarAntiHorario(board, 4);
		

		return board;
		
	}
	
	static char[][] rotarHorario(char[][]mat, int c) {
		int row = 0, col = 0;
		if(c == 1) col = 3;
		else if(c == 3) row = 3;
		else if(c == 4) {
			col = 3;
			row = 3;
		}
		char temp = mat[row][col];
		mat[row][col] = mat[row][col + 2];
		mat[row][col + 2] = mat[row + 2][col + 2];
		mat[row + 2][col + 2] = mat[row + 2][col];
		mat[row + 2][col] = temp;
		
		temp = mat[0 + row][1 + col];
		mat[0 + row][1 + col] = mat[1 + row][2 + col];
		mat[1 + row][2 + col] = mat[2 + row][1 + col];
		mat[2 + row][1 + col] = mat[1 + row][0 + col];
		mat[1 + row][0 + col] = temp;
		return mat;
	}
	
	
	public static int getWinnerScore() {
	
		if(Judge.gameOver(P1,board))
				return 1;
		if(Judge.gameOver(P2,board))
				return 2;

		return 3;
			
	}
	
	public static boolean gameOver()
	{
		return Judge.gameOver(P1,board)||Judge.gameOver(P2,board);
	}
	
}
