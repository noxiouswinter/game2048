package com.jinais.game2048;

public interface GameStateCallback {
	
	public void OnGameOver();
	public void OnMatrixUpdated(Integer[][] matrix);

}
