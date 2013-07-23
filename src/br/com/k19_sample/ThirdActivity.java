package br.com.k19_sample;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intents_third);
		
		Bundle extras = getIntent().getExtras();
		String hgt = extras.getString("height");
		String wgt = extras.getString("weight");

		double height = Double.parseDouble(hgt);
		double weight = Double.parseDouble(wgt);
		double res = imc(height,weight);
		
		DecimalFormat df = new DecimalFormat("#.00");
		TextView imc_result = (TextView) findViewById(R.id.label_result);
		imc_result.setText(getString(R.string.imc_result, df.format(res)));

		String message = imcDesc(res);
		TextView imc_desc = (TextView) findViewById(R.id.label_desc);
		imc_desc.setText(message);
		
		ArrayList<Double> ideal = ideal(height);
		TextView idealWeight = (TextView) findViewById(R.id.label_ideal);
		idealWeight.setText(getString(R.string.ideal_weight, df.format(ideal.get(0)), df.format(ideal.get(1))));
		
	}

	/**
	 * 
	 * @param h
	 * @param w
	 * @return
	 */
	private double imc(double h, double w){
		double result = 1.0;
		
		if (h > 0 && w > 0) 
			result = Math.round((w/(h*h)));
		
		return result;
	}

	/**
	 * 
	 * @param h
	 * @return
	 */
	private ArrayList<Double> ideal(double h){
		ArrayList<Double> result = new ArrayList<Double>();
		
		if (h > 0){ 
			result.add((18.5*h*h));
			result.add((24.99*h*h));
		} 
		
		return result;
	}
	
	
	/**
	 * 
	 * @param res
	 * @return
	 */
	private String imcDesc(double res) {		
		String message = "";
		
		if (res < 17)
			message = "Muito abaixo do peso";
		else if (res >=17 && res < 18.5)
			message = "Abaixo do peso";
		else if (res >= 18.5 && res < 25)
			message = "Peso normal";
		else if (res >= 25 && res < 30)
			message = "Acima do peso";
		else if (res >= 30 && res < 35)
			message = "Obesidade I";
		else if (res >= 35 && res < 40)
			message = "Obesidade II (severa)";
		else if (res >= 40)
			message = "Obesidade III (mórbida)";
		
		return message;
	}

}
