package br.com.k19_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intents_second);
		
		final EditText heightEditText = (EditText) findViewById(R.id.height_edit_text);
		final EditText weightEditText = (EditText) findViewById(R.id.weight_edit_text);
		
		Button button = (Button) findViewById(R.id.next_button);
		
		button.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				String hgt = heightEditText.getEditableText().toString();
				String wgt = weightEditText.getEditableText().toString();

				Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
				intent.putExtra("weight", wgt);
				intent.putExtra("height", hgt);
				startActivity(intent);				
			}
		} );
		
	}
}
