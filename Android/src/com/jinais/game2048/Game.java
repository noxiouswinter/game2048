package com.jinais.game2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.util.Log;

public class Game {
	
	static final int ROWS = 4;
	static final int COLUMNS = 4;
	
	private GameStateCallback gameStateCallback;
	
	private Integer cachedMatrix[][] = new Integer[ROWS][COLUMNS];
//	static Integer matrix[][] = {{2,4,5,6}, {2,4,5,6}, {2,4,5,6}, {2,4,5,6}};
	
	
	public static enum Action {
		UP, DOWN, LEFT, RIGHT, EXIT
	}
	
	public Game(GameStateCallback gameStateCallback) {
		
		this.gameStateCallback = gameStateCallback;
		resetGame();
	}

	private int getRandomPopUpInt() {
		Random random = new Random();
		int randomPopUpInt = 2 + 2 * random.nextInt(2); // 2 or 4
		return randomPopUpInt;
	}
	
	//TODO remove this
//	private void printMatix(Integer[][] matrix) {
//		
//		System.out.println("\n______________________\n");
//		
//		for(int i = 0; i < ROWS; i++) {
//			StringBuilder sb = new StringBuilder();
//			for(int j = 0; j < COLUMNS; j++){
//				sb.append( "  " + ((matrix[i][j] == 0) ? "." : matrix[i][j]));
//			}
//			System.out.println(sb.toString());
//		}
//		System.out.println("______________________");
//	}
	
	
	//Initialize all slots with zero
	private void initializeMatrix(Integer[][] matrix) {
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++){
				matrix[i][j] = 0;
			}
		}
	}
	
	private TilePosition addTile(Integer[][] matrix, int value) {
		
		//Find empty slots
		List<TilePosition> emptyCells = new ArrayList<TilePosition>();
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++){
				if(matrix[i][j].equals(0)){
					emptyCells.add(new TilePosition(i, j));
				}
			}
		}
		
		//Game over
		if(emptyCells.size() == 0) {
			return null;
		}
		
		//Assign value at random empty slot
		Random random = new Random();
		int randomNumber = random.nextInt(emptyCells.size());
		TilePosition randomPosition = emptyCells.get(randomNumber);
		matrix[randomPosition.i][randomPosition.j] = value;
		return randomPosition;
	}
	
	// [0, 0, 1, 2, 2, 0, 3, 3, 0] to [1, 2, 2, 6] 
	private ArrayList<Integer> processSingleArray(List<Integer> initialList) {
		
		//Remove zeros
		List<Integer> cleansedList = new ArrayList<Integer>();
		for(int i = 0; i < initialList.size(); i++) {
			if(initialList.get(i) != 0) {
				cleansedList.add(initialList.get(i));
			}
		}
		
		ArrayList<Integer> reverseProcessedList = new ArrayList<Integer>();
		for(int i= cleansedList.size()-1; i >= 0; i--) {
			Integer nthElement = cleansedList.get(i);
			Integer nMinusOnethElement = null;
			if((i != 0) && nthElement.equals(nMinusOnethElement = cleansedList.get(i-1))) {
				reverseProcessedList.add(nthElement + nMinusOnethElement);
				//Skip next(nMinusOneth) number
				i--;
			} else {
				reverseProcessedList.add(nthElement);
			}
		}
		//Reverse the list
		Collections.reverse(reverseProcessedList);
		ArrayList<Integer> processedList = reverseProcessedList; 
		
		return processedList;
	}
	
	public static class TilePosition {
		public TilePosition(int i, int j){
			this.i = i;
			this.j = j;
		}
		public int i;
		public int j;
	}
	
	public Boolean playMatrix(Action action) {
		return playMatrix(cachedMatrix, action);
	}
	
	private Boolean playMatrix(Integer[][] matrix, Action action) {
			
		if(action.equals(Action.RIGHT) || action.equals(Action.LEFT)) {
			
			for(int i = 0; i < ROWS; i++) {
			
				ArrayList<Integer> rowArray = new ArrayList<Integer>();
				for(int j = 0; j < COLUMNS; j++){
					rowArray.add(matrix[i][j]);
				}
				
				if(action.equals(Action.RIGHT)) {
					
					ArrayList<Integer> processedArray = processSingleArray(rowArray);
					
					//Apply from right to left
					for(int k = processedArray.size()-1, l = COLUMNS-1; l >= 0; k--, l--) {
						Integer swapwithValue = null;
						if(k >= 0) {
							swapwithValue = processedArray.get(k);
						} else {
							swapwithValue =0;
						}
						matrix[i][l] = swapwithValue;
					}
					
				} else if (action.equals(Action.LEFT)) {
					
					//Reverse rowArray
					ArrayList<Integer> reversedRowArray = new ArrayList<Integer>();
					Collections.reverse(rowArray);
					reversedRowArray = rowArray;
					
					//Process reversed
					ArrayList<Integer> processedArray = processSingleArray(reversedRowArray);
					
					//Apply from left to right
					for(int k = processedArray.size()-1, l = 0; l < COLUMNS; k--, l++) {
						Integer swapwithValue = null;
						if(k >= 0) {
							swapwithValue = processedArray.get(k);
						} else {
							swapwithValue =0;
						}
						matrix[i][l] = swapwithValue;
					}
				}
				
			} //for
			
		} else if(action.equals(Action.UP) || action.equals(Action.DOWN)) {
			
			for(int j = 0; j < COLUMNS; j++) {
				
				ArrayList<Integer> columnArray = new ArrayList<Integer>();
				for(int i = 0; i < ROWS; i++){
					columnArray.add(matrix[i][j]);
				}
				
				if(action.equals(Action.DOWN)) {
					
					ArrayList<Integer> processedArray = processSingleArray(columnArray);
					
					//Apply from bottom to up
					for(int k = processedArray.size()-1, l = ROWS-1; l >= 0; k--, l--) {
						Integer swapwithValue = null;
						if(k >= 0) {
							swapwithValue = processedArray.get(k);
						} else {
							swapwithValue = 0;
						}
						matrix[l][j] = swapwithValue;
					}
					
				} else if(action.equals(Action.UP)) {
					
					//Reverse columnArray
					ArrayList<Integer> reversedColumnArray = new ArrayList<Integer>();
					Collections.reverse(columnArray);
					reversedColumnArray = columnArray;
					
					//Process reversed
					ArrayList<Integer> processedArray = processSingleArray(reversedColumnArray);
					
					//Apply from top to bottom
					for(int k = processedArray.size()-1, l = 0; l < ROWS; k--, l++) {
						Integer swapwithValue = null;
						if(k >= 0) {
							swapwithValue = processedArray.get(k);
						} else {
							swapwithValue =0;
						}
						matrix[l][j] = swapwithValue;
					}
				}
				
			} //for
		}
		
		//Add tile and see if gameOver
		TilePosition tilePositionAdded;
		if((tilePositionAdded = addTile(matrix, getRandomPopUpInt())) == null) {
			
			if(checkIfGameOver()) {
				gameStateCallback.OnGameOver();
			}
			return false;
			
		} else {
			gameStateCallback.OnMatrixUpdated(matrix, tilePositionAdded);
			return true;
		}
	}
	
	public void resetGame() {
		
		//Fill with zeros
		initializeMatrix(cachedMatrix);
		
		//Put two random numbers in the matrix initially
		if(addTile(cachedMatrix, getRandomPopUpInt()) == null){
			Log.e("ERROR", "Couldn't add tile");
		}
		if(addTile(cachedMatrix, getRandomPopUpInt()) == null){
			Log.e("ERROR", "Couldn't add tile");
		}
		
		gameStateCallback.OnMatrixUpdated(cachedMatrix, null);
	}

	//Check if moves are possible by checking identical numbers in the neighborhood of each cell
	public boolean checkIfGameOver() {
		
		for(int i= 0; i < ROWS; i++) {
			for(int j=0; j < COLUMNS; j++) {
				
				Integer currentElement = cachedMatrix[i][j];
				
				//If there is an empty cell
				if(currentElement.equals(0)) {
					return false;
				}
				
				TilePosition topTilePosition = new TilePosition(i-1, j);
				TilePosition bottomTilePosition = new TilePosition(i+1, j);
				TilePosition leftTilePosition = new TilePosition(i, j-1);
				TilePosition rightTilePosition = new TilePosition(i, j+1);
				
				
				if(currentElement != null && (currentElement.equals(0) == false)) {
					//topTilePosition.i >= 0 && topTilePosition.i < ROWS && topTilePosition.j >=0 && topTilePosition.j < COLUMNS
					
					if(topTilePosition.i >= 0) {
						Integer topElement = cachedMatrix[topTilePosition.i][topTilePosition.j];
						if(topElement.equals(currentElement)) {
							return false;
						}
					}
					
					if(bottomTilePosition.i < ROWS) {
						Integer bottomElement = cachedMatrix[bottomTilePosition.i][bottomTilePosition.j];
						if(bottomElement.equals(currentElement)) {
							return false;
						}
					}
					
					if(leftTilePosition.j >= 0) {
						Integer leftElement = cachedMatrix[leftTilePosition.i][leftTilePosition.j];
						if(leftElement.equals(currentElement)) {
							return false;
						}
					}
					
					if(rightTilePosition.j < COLUMNS) {
						Integer rightElement = cachedMatrix[rightTilePosition.i][rightTilePosition.j];
						if(rightElement.equals(currentElement)) {
							return false;
						}
					}
				}
				
			}
		}
		return true; 
	}
	
	public String getStringFromCachedMatrix() {
		
		Integer[][] matrix = this.cachedMatrix;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < ROWS; i++){
			if(i != 0){
				sb.append(":");
			}
			for(int j = 0; j < COLUMNS; j++) {
				if(j != 0){
					sb.append(",");
				}
				sb.append(matrix[i][j]);
			}
		}
		return sb.toString();
	}
	
	public void setCachedMatrixFromString(String matrixString) {
		
		Integer[][] matrix = new Integer[ROWS][COLUMNS];
		String[] rowsArray = matrixString.split(":");
		for (int i = 0; i < rowsArray.length; i++) {
			String columnString = rowsArray[i];
			String[] columnsArray = columnString.split(",");
			for (int j = 0; j < columnsArray.length; j++) {
				matrix[i][j] = Integer.parseInt(columnsArray[j]);
			}
		}
		
		this.cachedMatrix = matrix;
	}

	public Integer[][] getMatrix() {
		return cachedMatrix;
	}

	public void setMatrix(Integer[][] matrix) {
		this.cachedMatrix = matrix;
	}
	
}
