package com.example.ejemplo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	ImageView foto;
	TextView tv;
	int[] fotoId = {R.drawable.foto1, R.drawable.foto2, R.drawable.foto3, R.drawable.foto4}; 
	String[] textos = {"Texto foto 1", "Texto foto 2", "Texto foto 3", "Texto foto 4"};
	int i = 0;
	int total;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button anterior = (Button) findViewById(R.id.button1);
		Button siguiente = (Button) findViewById(R.id.button2);
		anterior.setOnClickListener(this);
		siguiente.setOnClickListener(this);
		
		tv = (TextView) findViewById(R.id.textView1);
		foto = (ImageView) findViewById(R.id.imageView1);
		total = fotoId.length;
	}
	
	@Override
	public void onClick(View view) {
		
		int id = view.getId();
		if(id == R.id.button2) {
			i++;
			if(i == total){
				i = 0;
			}
		}
		
		if(id == R.id.button1) {
			i--;
			if(i == -1){
				i = total -1;
			}
		}
		foto.setImageResource(fotoId[i]);
		tv.setText(textos[i]);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
