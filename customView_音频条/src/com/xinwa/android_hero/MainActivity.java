package com.xinwa.android_hero;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.xinwa.android_hero.MyTopBar.OnTopBarClickListener;

public class MainActivity extends Activity {

	private MyTextView text;
	private MyTopBar topBar;
	private SweepView sweepView;
	private int sweepAngle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (MyTextView) findViewById(R.id.text);
		topBar = (MyTopBar) findViewById(R.id.topBar);
		topBar.setOnTopBarClickListener(new OnTopBarClickListener() {
			
			@Override
			public void rightClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "rightButton被点击", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "leftButton被点击", Toast.LENGTH_SHORT).show();
			}
		});
		
		sweepView = (SweepView) findViewById(R.id.sweepView);
		
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(sweepAngle > 360){
					sweepAngle = 0;
				}
				sweepAngle += 30;
				sweepView.setSweepAngle(sweepAngle);
			}
			
		}, 100, 100);
	}
	
	
	
}
