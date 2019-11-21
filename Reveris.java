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

	public void showGame(){
		for (int outerInd = 0; outerInd < 8; outerInd++){
			for (int innerInd = 0; innerInd < 8; innerInd++){
				System.out.print(board[innerInd][outerInd]+", ");
			}
			System.out.println();
		}
		System.out.println("................................\n");
	}

	public int[] edgeValues(int row, int col){
		col = 7 - col;
		int numbers[] = new int[12];
		int counter = 0;
		int ind1 = row-1;

		
		while (ind1>=0){
			if (board[ind1][col] == 0){
				if ((row - ind1 != 1)){
					numbers[counter] = board[ind1+1][col];
					counter = counter + 1;
					//B1 = true;
					break;
				} else {break;}
			} else if (board[ind1][col] != 0) {
				ind1--;
			} else if (ind1 == 0){
				numbers[counter] = board[ind1][col];
				counter++;
				break;
			}
		}
		
		ind1 = row+1;
		while (ind1<8){
			if (board[ind1][col] == 0){
				if ((row - ind1 != -1)){
					numbers[counter] = board[ind1-1][col];
					counter = counter + 1;
					//B2 = true;
					break;
					
				} else {break;}
			} else if (board[ind1][col] != 0) {
				ind1++;
			} else if (ind1 == 7){
				numbers[counter] = board[ind1][col];
				counter++;
				break;
			}
		}
		


		int ind2 = col-1;
		while (ind2>=0){
			if (board[row][ind2] == 0){
				if ((col - ind2 != 1)){
					numbers[counter] = board[row][ind2+1];
					counter = counter + 1;
					//B3 = true;
					break;
				} else {break;}
			} else if (board[row][ind2] != 0) {
				ind2--;
			} else if (ind2 == 0){
				numbers[counter] = board[row][ind2];
				counter++;
				break;
			}
		}
		
		ind2 = col+1;
		while (ind2<8){
			if (board[row][ind2] == 0){
				if ((col - ind2 != -1)||true){
					numbers[counter] = board[row][ind2-1];
					counter = counter + 1;
					//B4 = true;
					break;
				} else {break;}
			} else if (board[row][ind2] != 0) {
				ind2++;
			} else if (ind1 == 7){
				numbers[counter] = board[row][ind2];
				counter++;
				break;
			}
		}
		System.out.println(numbers[3]);
		

		ind1 = row + 1;
		ind2 = col + 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((row - ind1 !=-1) && (col - ind2 != -1)){
					numbers[counter] = board[ind1-1][ind2-1];
					counter++;
					//B5 = true;
					break;
					
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1++;
				ind2++;
			} else if ((ind1==7) || (ind2==7)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}
		


		ind1 = row + 1;
		ind2 = col - 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((ind1 - row != 1) && (ind2 - col != -1)){
					numbers[counter] = board[ind1-1][ind2+1];
					counter++;
					//B6 = true;
					break;
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1++;
				ind2--;
			} else if ((ind1==7) || (ind2==0)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}

		

		ind1 = row - 1;
		ind2 = col + 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((row - ind1 != 1) && (col - ind2 != -1)){
					numbers[counter] = board[ind1+1][ind2-1];
					counter++;
					//B7 = true;
					break;
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1--;
				ind2++;
			} else if ((ind1==0) || (ind2==7)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}

		

		ind1 = row - 1;
		ind2 = col - 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((ind1 - row != 1) && (ind2 - col != -1)){
					numbers[counter] = board[ind1+1][ind2+1];
					counter++;
					//B8 = true;
					break;
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1--;
				ind2--;
			} else if ((ind1==0) || (ind2==0)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}

		

		
		return numbers;//isLegalMove helper function
	}


	/*public void checkEdgeValues(int row, int col){
		int numbers[] = new int[12];
		int counter = 0;
		int ind1 = row-1;
		boolean B1 = false;
		boolean B2 = false;
		boolean B3 = false;
		boolean B4 = false;
		boolean B5 = false;
		boolean B6 = false;
		boolean B7 = false;
		boolean B8 = false;
		
		while (ind1>=0){
			if (board[ind1][col] == 0){
				if ((row - ind1 != 1)){
					numbers[counter] = board[ind1+1][col];
					counter = counter + 1;
					B1 = true;
					break;
				} else {break;}
			} else if (board[ind1][col] != 0) {
				ind1--;
			} else if (ind1 == 0){
				numbers[counter] = board[ind1][col];
				counter++;
				break;
			}
		}
		ind1 = row+1;
		while (ind1<8){
			if (board[ind1][col] == 0){
				if ((row - ind1 != -1)){
					numbers[counter] = board[ind1-1][col];
					counter = counter + 1;
					break;
					B2 = true;
				} else {break;}
			} else if (board[ind1][col] != 0) {
				ind1++;
			} else if (ind1 == 7){
				numbers[counter] = board[ind1][col];
				counter++;
				break;
			}
		}

		if((numbers[1] == numbers[0]) && B1 && B2){
			for (; (numbers[ind1-1][col]! = 0); ind1--){
				numbers[ind1-1][col] = numbers[1];
				return;
			}
		}

		int ind2 = col-1;
		while (ind2>=0){
			if (board[row][ind2] == 0){
				if ((col - ind2 != 1)){
					numbers[counter] = board[row][ind2+1];
					counter = counter + 1;
					B3 = true;
					break;
				} else {break;}
			} else if (board[row][ind2] != 0) {
				ind2--;
			} else if (ind2 == 0){
				numbers[counter] = board[row][ind2];
				counter++;
				break;
			}
		}
		ind2 = col+1;
		while (ind2<8){
			if (board[row][ind2] == 0){
				if ((col - ind2 != -1)){
					numbers[counter] = board[row][ind2-1];
					counter = counter + 1;
					B4 = true;
					break;
				} else {break;}
			} else if (board[row][ind2] != 0) {
				ind2++;
			} else if (ind1 == 7){
				numbers[counter] = board[row][ind2];
				counter++;
				break;
			}
		}

		ind1 = row + 1;
		ind2 = col + 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((row - ind1 !=-1) && (col - ind2 != -1)){
					numbers[counter] = board[ind1-1][ind2-1];
					counter++;
					break;
					B5 = true;
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1++;
				ind2++;
			} else if ((ind1==7) || (ind2==7)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}


		ind1 = row + 1;
		ind2 = col - 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((ind1 - row != 1) && (ind2 - col != -1)){
					numbers[counter] = board[ind1-1][ind2+1];
					counter++;
					B6 = true;
					break;
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1++;
				ind2--;
			} else if ((ind1==7) || (ind2==0)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}


		ind1 = row - 1;
		ind2 = col + 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((row - ind1 != 1) && (col - ind2 != -1)){
					numbers[counter] = board[ind1+1][ind2-1];
					counter++;
					B7 = true;
					break;
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1--;
				ind2++;
			} else if ((ind1==0) || (ind2==7)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}

		ind1 = row - 1;
		ind2 = col - 1;
		while ((ind1>=0) && (ind1<=7) && (ind2>=0) && (ind2<=7)){
			if (board[ind1][ind2] == 0){
				if ((ind1 - row != 1) && (ind2 - col != -1)){
					numbers[counter] = board[ind1+1][ind2+1];
					counter++;
					B8 = true;
					break;
				} else {break;}
			} else if (board[ind1][ind2] != 0){
				ind1--;
				ind2--;
			} else if ((ind1==0) || (ind2==0)){
				numbers[counter] = board[ind1][ind2];
				counter++;
				break;
			}
		}


		
		return numbers;//isLegalMove helper function
	}*/

	public boolean isLegalMove(int row, int col){
		col = 7 - col;
		boolean empty = false;
		boolean adjacent = false;
		boolean opp = false;
		boolean itsLegal = false;
		int[] edgeVals = edgeValues(row, col);
		if (occupiedBy(row,col) == 0) empty = true;
		if (!empty) return(false); 
		adjacent = isAdjacent(row, col);
		for(int x = 0; x < edgeVals.length; x++){
			if (edgeVals[x] == whoseTurn()) opp = true;
		}
		if (empty && adjacent && opp) itsLegal = true;
		return (itsLegal);
	}

	private boolean isAdjacent(int row, int col){ //isLegalMove helper function
		col = 7 - col;
		boolean adjacent = false;
		if ((row == 0) && (col == 0)){
			if ((occupiedBy(row+1,col) == NOTwhoseTurn())||(occupiedBy(row,col+1) == NOTwhoseTurn())) adjacent = true;
		} else if ((row == 0) && (col == 7)){
			if ((occupiedBy(row+1,col) == NOTwhoseTurn())||(occupiedBy(row,col-1) == NOTwhoseTurn())) adjacent = true;
		} else if ((row == 7) && (col == 0)){
			if ((occupiedBy(row-1,col) == NOTwhoseTurn())||(occupiedBy(row,col+1) == NOTwhoseTurn())) adjacent = true;
		} else if ((row == 7) && (col == 7)){
			if ((occupiedBy(row-1,col) == NOTwhoseTurn())||(occupiedBy(row,col-1) == NOTwhoseTurn())) adjacent = true;
		} else if (row == 0){
			if ((occupiedBy(row+1,col) == NOTwhoseTurn())||(occupiedBy(row,col+1) == NOTwhoseTurn())||(occupiedBy(row,col-1) == NOTwhoseTurn())) adjacent = true;
		} else if (row == 7){
			if ((occupiedBy(row-1,col) == NOTwhoseTurn())||(occupiedBy(row,col+1) == NOTwhoseTurn())||(occupiedBy(row,col-1) == NOTwhoseTurn())) adjacent = true;
		} else if (col == 0){
			if ((occupiedBy(row+1,col) == NOTwhoseTurn())||(occupiedBy(row-1,col) == NOTwhoseTurn())||(occupiedBy(row,col+1) == NOTwhoseTurn())) adjacent = true;
		} else if (col == 7){
			if ((occupiedBy(row-1,col) == NOTwhoseTurn())||(occupiedBy(row+1,col) == NOTwhoseTurn())||(occupiedBy(row,col-1) == NOTwhoseTurn())) adjacent = true; //} else {if ((board[row+1][col] == NOTwhoseTurn())||(board[row-1][col] == NOTwhoseTurn())||(board[row][col+1] == NOTwhoseTurn())||(board[row][col-1] == NOTwhoseTurn())) adjacent = true;
		} else {if ((occupiedBy(row+1,col) == NOTwhoseTurn())||(occupiedBy(row-1,col) == NOTwhoseTurn())||(occupiedBy(row,col+1) == NOTwhoseTurn())||(occupiedBy(row,col-1) == NOTwhoseTurn())) adjacent = true;
		}
		return (adjacent);
	}

	public void makeMove(int row, int col){
		col = 7 - col;
		if (isLegalMove(row,col)){
			board[row][col] = whoseTurn();
			currentPlayer = NOTwhoseTurn();
		} else {System.out.println("Invalid move, please try again.");}	
	}

	public int whoseTurn(){
		return currentPlayer;
	}

	public int NOTwhoseTurn(){
		if (currentPlayer == 1){
			return(2);
		} else if (currentPlayer == 2){
			return(1);
		}

		return(currentPlayer);
	}

	public  int occupiedBy(int row, int col){
		//col = 7 - col;
		return board[row][col];
	}

	public  int numOpenSquares(){ //I have completely replaced this function with my own. Please inform me if you do not like what I've done.
		int openSquares = 64 - (numChips(1) + numChips(2));
		return openSquares;
	}

	public  int numChips(int player){
		int playerCount = 0;
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				if(board[row][col] == player){
					playerCount+=1;
				}
			}
		}
		return playerCount;
	}

	public int getWinner(){//I have completely replaced this function with my own. Please inform me if you do not like what I've done.
		if(numChips(1) == numChips(2)){
			return 0;
		}else if(numChips(1) > numChips(2)){
			return 1;
		}else{
			return 2;
		}
	}
}