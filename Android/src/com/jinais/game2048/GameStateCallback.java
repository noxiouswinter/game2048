package com.jinais.game2048;

import com.jinais.game2048.Game.TilePosition;


public interface GameStateCallback {
	
	public void OnGameOver();
	public void OnMatrixUpdated(Integer[][] matrix, TilePosition tilePositionAdded);

}
