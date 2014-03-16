package game;

public interface GameStateCallback {
	
	public void OnGameOver();
	public void OnMatrixUpdated(Integer[][] matrix);

}
