public class Reveris{
	int board[][] = {{},
					 {},
					 {},
					 {},
					 {},
					 {},
					 {},
					 {}};
	int currentPlayer = 1;

	public  int whoseTurn(){
		return this.currentPlayer;
	}
	public  int occupiedBy( row, col){
		return this.board[row][col]
	}
	public  int numOpenSquares(){
		int openSquares = 0;
		for(int row = 0; row < this.board; row++){
			for(int col = 0; col < this.board; col++){
				if(this.board[row][col] == 0){
					openSquares+=1;
				}
			}
		}
		return openSquares;
	}

	public  int numChips(player){
		int playerCount = 0;
		for(int row = 0; row < this.board; row++){
			for(int col = 0; col < this.board; col++){
				if(this.board[row][col] == player){
					playerCount+=1;
				}
			}
		}
		return playerCount;
	}

	public int getWinner(){
		int player1Count = 0;
		int player2Count = 0;
		for(int row = 0; row < this.board; row++){
			for(int col = 0; col < this.board; col++){
				if(this.board[row][col] == 1){
					player1Count+=1;
				}else(this.board[row][col] == 2){
					player2Count+=1;
				}
			}
		}
		if(player1Count == player2Count){
			return 0;
		}else if(player1Count>player2Count){
			return 1;
		}else{
			return 2;
		}
	}
	
}