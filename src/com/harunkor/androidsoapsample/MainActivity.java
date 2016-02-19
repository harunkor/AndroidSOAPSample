package com.harunkor.androidsoapsample;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	public static TextView rtxt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		final EditText usedt=(EditText) findViewById(R.id.editText1);
//		final EditText pasedt=(EditText) findViewById(R.id.editText2);
		Button   btn=(Button) findViewById(R.id.button1);
		
		rtxt   =(TextView) findViewById(R.id.textView1);
		
		
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
			soapAsyncTaskParameters params= new soapAsyncTaskParameters("Celsius", usedt.getText().toString());
			soapAsyncTaskParameters.soapAsyncTask sTask= new soapAsyncTaskParameters.soapAsyncTask();
			sTask.execute(params);
					

				
				
				
				
				
				
			}
		});
		
		
		
		
	}

	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
