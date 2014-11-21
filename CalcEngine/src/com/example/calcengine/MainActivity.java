package com.example.calcengine;

import FutureValue.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private EditText InvestmentAmmount;
	private Spinner YearSpinner;
	private EditText InterestRate;
	private EditText FutureValue;
	private Button calculate;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		YearSpinner = (Spinner) findViewById(R.id.spinner1);
		InvestmentAmmount = (EditText) findViewById(R.id.editText1);
		InvestmentAmmount.addTextChangedListener(new TextWatcher(){
		
			public void afterTextChanged(Editable s) {
				checkReady();}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

		
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
		InterestRate = (EditText) findViewById(R.id.editText2);
		InterestRate.addTextChangedListener(new TextWatcher(){
			
			public void afterTextChanged(Editable s) {
				checkReady();}

			
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

			
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});

		FutureValue = (EditText)findViewById(R.id.editText3);
		calculate = (Button) findViewById(R.id.button1);

		calculate.setOnClickListener(new OnClickListener(){

			
			public void onClick(View v){
				Ready();
			}

		});
	}

	private void checkReady() {
		if( (!(InvestmentAmmount.getText().toString().equals("")))  &
				(!(InterestRate.getText().toString().equals(""))) ){
			calculate.setEnabled(true);

		}else
			calculate.setEnabled(false);	

	}

	private void Ready() {
		double ammount = Double.parseDouble(InvestmentAmmount.getText().toString());
		double rate = Double.parseDouble(InterestRate.getText().toString());
		double year = Double.parseDouble((String) YearSpinner.getSelectedItem());
		double futvalue = ammount*Math.pow(1+(rate/1200), year*12);
		String futVal = String.format("%1$,.2f", futvalue);
		FutureValue.setText(futVal);
		
	}

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
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