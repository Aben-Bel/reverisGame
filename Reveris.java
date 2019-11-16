import java.util.Scanner;

public class Reveris{
	int board[][] = new int[8][8];
	int currentPlayer = 1;
	Scanner in = new Scanner(System.in);
	public void ReversiGameLogic(){

		for (int outerInd = 0; outerInd < 8; outerInd++){
			for (int innerInd = 0; innerInd < 8; innerInd++){
				if ((outerInd == 3 && innerInd == 3) || (outerInd == 4 && innerInd == 4)){
					board[innerInd][outerInd] = 1;
				} else if ((outerInd == 3 && innerInd == 4) || (outerInd == 4 && innerInd == 3)){
					board[innerInd][outerInd] = 2;
				} else { board[innerInd][outerInd] = 0; }
			}
		}
	}
	public int[] edgeValues(int row, int col){
		int numbers[] = new int[10];
		int counter = 0;
		int ind1 = row-1;
		int ind2 = col-1;
		while (ind1>=0){
			if (board[ind1][col] == 0){
				numbers[counter] = board[ind1+1][col];
				counter = counter + 1;
				break;
			} else if (board[ind1][col] != 0) {
				ind1--;
			} else if (ind1 == 0){
				numbers[counter] = board[ind1][col];
				counter++;
				break;
			}
		}
		ind1 = row+1
		while (ind1<8){
			if (board[ind1][col] == 0){
				numbers[counter] = board[ind1-1][col];
				counter = counter + 1;
				break;
			} else if (board[ind1][col] != 0) {
				ind1++;
			} else if (ind1 == 7){
				numbers[counter] = board[ind1][col];
				counter++;
				break;
			}
		}
		while (ind2>=0){
			if (board[row][ind2] == 0){
				numbers[counter] = board[row][ind2+1];
				counter = counter + 1;
				break;
			} else if (board[row][ind2] != 0) {
				ind2--;
			} else if (ind2 == 0){
				numbers[counter] = board[row][ind2];
				counter++;
				break;
			}
		}
		ind2 = col+1
		while (ind2<8){
			if (board[row][ind2] == 0){
				numbers[counter] = board[row][ind2-1];
				counter = counter + 1;
				break;
			} else if (board[row][ind2] != 0) {
				ind1++;
			} else if (ind1 == 7){
				numbers[counter] = board[row][ind2];
				counter++;
				break;
			}
		}
	}


	public boolean isLegalMove(int row, int col){
		boolean empty, adjacent, opp, empty, itsLegal;
		if (occupiedBy(row,col) == 0) empty = True;
		if ((occupiedBy(row+1,col) == NOTwhoseTurn())||(occupiedBy(row-1,col) == NOTwhoseTurn())||(occupiedBy(row,col+1) == NOTwhoseTurn())||(occupiedBy(row,col-1) == NOTwhoseTurn())) adjacent = True; //Index error bug might occur. Must fix. Remind me.
		int[] edgeVals = edgeValues(row, col);
		for(int x = 0; x < edgeVals.length; x++){
			if (edgeVals[x] == whoseTurn()) opp = True;
		}
		if (empty && adjacent && opp) itsLegal = True;
		return (boolean);
	}

	public void makeMove(int row, int col){
		if isLegalMove(row,col){
			board[row][col] = whoseTurn()
		}
		currentPlayer = NOTwhoseTurn();
	}







	public  int whoseTurn(){
		return this.currentPlayer;
	}
	public int NOTwhoseTurn(){
		if (currentPlayer == 1){
			return(2);
		} else if (currentPlayer == 2){
			return(1);
		}
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