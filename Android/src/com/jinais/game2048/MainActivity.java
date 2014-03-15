package com.jinais.game2048;

import com.jinais.game2048.Game.Action;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private TextView tv00, tv01, tv02, tv03, tv10, tv11, tv12, tv13, tv20, tv21, tv22, tv23, tv30, tv31, tv32, tv33;
	private Button bUp, bDown, bLeft, bRight, bRestart;
	private Game game;
	private GameStateCallback gameStateCallback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeViews();
		gameStateCallback = new GameStateCallBackImpl(this);
		game = new Game(gameStateCallback);
	}
	
	
	private void initializeViews() {
		
		tv00 = (TextView)findViewById(R.id.tv00);
		tv01 = (TextView)findViewById(R.id.tv01);
		tv02 = (TextView)findViewById(R.id.tv02);
		tv03 = (TextView)findViewById(R.id.tv03);
		tv10 = (TextView)findViewById(R.id.tv10);
		tv11 = (TextView)findViewById(R.id.tv11);
		tv12 = (TextView)findViewById(R.id.tv12);
		tv13 = (TextView)findViewById(R.id.tv13);
		tv20 = (TextView)findViewById(R.id.tv20);
		tv21 = (TextView)findViewById(R.id.tv21);
		tv22 = (TextView)findViewById(R.id.tv22);
		tv23 = (TextView)findViewById(R.id.tv23);
		tv30 = (TextView)findViewById(R.id.tv30);
		tv31 = (TextView)findViewById(R.id.tv31);
		tv32 = (TextView)findViewById(R.id.tv32);
		tv33 = (TextView)findViewById(R.id.tv33);
		
		bUp = (Button)findViewById(R.id.bUp);
		bUp.setOnClickListener(this);
		bDown = (Button)findViewById(R.id.bDown);
		bDown.setOnClickListener(this);
		bLeft = (Button)findViewById(R.id.bLeft);
		bLeft.setOnClickListener(this);
		bRight = (Button)findViewById(R.id.bRight);
		bRight.setOnClickListener(this);
		bRestart = (Button)findViewById(R.id.bRestart);
		bRestart.setOnClickListener(this);
	}
	
	public void updateMatrixView(Integer[][] matrix) {
	    
		tv00.setText(matrix[0][0].equals(0) ? "" : matrix[0][0].toString());
		tv01.setText(matrix[0][1].equals(0) ? "" : matrix[0][1].toString());
		tv02.setText(matrix[0][2].equals(0) ? "" : matrix[0][2].toString());
		tv03.setText(matrix[0][3].equals(0) ? "" : matrix[0][3].toString());
		tv10.setText(matrix[1][0].equals(0) ? "" : matrix[1][0].toString());
		tv11.setText(matrix[1][1].equals(0) ? "" : matrix[1][1].toString());
		tv12.setText(matrix[1][2].equals(0) ? "" : matrix[1][2].toString());
		tv13.setText(matrix[1][3].equals(0) ? "" : matrix[1][3].toString());
		tv20.setText(matrix[2][0].equals(0) ? "" : matrix[2][0].toString());
		tv21.setText(matrix[2][1].equals(0) ? "" : matrix[2][1].toString());
		tv22.setText(matrix[2][2].equals(0) ? "" : matrix[2][2].toString());
		tv23.setText(matrix[2][3].equals(0) ? "" : matrix[2][3].toString());
		tv30.setText(matrix[3][0].equals(0) ? "" : matrix[3][0].toString());
		tv31.setText(matrix[3][1].equals(0) ? "" : matrix[3][1].toString());
		tv32.setText(matrix[3][2].equals(0) ? "" : matrix[3][2].toString());
		tv33.setText(matrix[3][3].equals(0) ? "" : matrix[3][3].toString());
	}
	
	private class GameStateCallBackImpl implements GameStateCallback {
		
		private MainActivity mainActivity;

		public GameStateCallBackImpl(MainActivity mainActivity) {
			super();
			this.mainActivity = mainActivity;
		}

		@Override
		public void OnGameOver() {
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mainActivity);
	 
			alertDialogBuilder.setTitle("Game Over!");
			alertDialogBuilder
				.setMessage("Reset?")
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						MainActivity.this.game.resetGame();
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					}
				});
			
			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();
		}

		@Override
		public void OnMatrixUpdated(Integer[][] matrix) {
			mainActivity.updateMatrixView(matrix);
		}
		
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
		
		case R.id.bUp:
			game.playMatrix(Action.UP);
			break;
			
		case R.id.bDown:
			game.playMatrix(Action.DOWN);
			break;
			
		case R.id.bLeft:
			game.playMatrix(Action.LEFT);
			break;
			
		case R.id.bRight:
			game.playMatrix(Action.RIGHT);
			break;
			
		case R.id.bRestart:
			showRestartDialog();
			break;
		}
	}
	
	
	
	private void showRestartDialog() {
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
		 
		alertDialogBuilder.setTitle("Restart");
		alertDialogBuilder
			.setMessage("Restart Game?")
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					MainActivity.this.game.resetGame();
				}
			  })
			.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					dialog.cancel();
				}
			});
		
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

}
