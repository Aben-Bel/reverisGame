import java.util.Scanner;
class ReverisDemo{
	public static void main(String[] args){
		Reveris game = new Reveris();
		game.ReversiGameLogic();
		Scanner in = new Scanner(System.in);
		int x, y;


		System.out.println("Welcome to your Reversi Game. Take a look at your board.");
		game.showGame();
		for(;;){
		System.out.println("Player " + game.whoseTurn() + ", please make your move. Enter the x and y coordinates of the move you want to make.\n");
		System.out.print("X: ");
		x = in.nextInt();
		System.out.print("Y: ");
		y = in.nextInt();		
		game.makeMove(x,y);
		game.showGame();}
	}
}