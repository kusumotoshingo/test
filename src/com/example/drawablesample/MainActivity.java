package com.example.drawablesample;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private ToggleButton button;
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (ToggleButton)findViewById(R.id.toggleButton1);
		button.setChecked(true);

		image = (ImageView)findViewById(R.id.imageView1);
		image.setImageResource(R.drawable.charactor);

		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean ischecked) {
				if(ischecked){
					image.setVisibility(image.VISIBLE);
				}else{
					image.setVisibility(image.INVISIBLE);
				}
			}
		});

		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean ischecked) {
				if(ischecked)
					image.setVisibility(image.VISIBLE);
				else
		   	image.setVisibility(image.INVISIBLE);

			}
		});

		//解像度を調べる
		WindowManager manager = getWindowManager();
		Display display = manager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		float dpi = metrics.density;

		//ログに出力
		Log.i("densityDpi", ""+dpi); //自端末⇒1.5
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
