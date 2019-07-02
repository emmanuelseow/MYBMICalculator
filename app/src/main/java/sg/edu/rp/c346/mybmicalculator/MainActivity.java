package sg.edu.rp.c346.mybmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etweight;
    EditText etheight;
    Button btncal;
    Button btnreset;
    TextView tvdate;
    TextView tvbmi;
    TextView tvresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etweight = findViewById(R.id.editTextWeight);
        etheight = findViewById(R.id.editTextHeight);
        btncal = findViewById(R.id.btncalculate);
        btnreset = findViewById(R.id.btnreset);
        tvdate = findViewById(R.id.textViewdate);
        tvbmi = findViewById(R.id.textViewbmi);
        tvresult = findViewById(R.id.textViewresult);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Calculate Date
                Calendar now = Calendar.getInstance(); //create a calender object with current date and time

                String datetime = now.get(Calendar.DAY_OF_MONTH) + "/" + (now.get(Calendar.MONTH)+1) + "/" +
                        now.get(Calendar.YEAR) + " " + now.get(Calendar.HOUR_OF_DAY)+ ":" + now.get(Calendar.MINUTE);

                // Calculate BMI
                double bmi = 0;
                Double weight = Double.parseDouble(etweight.getText().toString());
                Double height = Double.parseDouble(etheight.getText().toString());

                bmi = weight/(height*height);

                if(bmi < 18.5){
                    tvresult.setText("You are underweight");
                } else if (bmi >= 18.5 && bmi <= 24.9 ){
                    tvresult.setText("You are normal");
                } else if (bmi >= 25 && bmi <= 29.9){
                    tvresult.setText("You are overweight");
                } else {
                    tvresult.setText("You are obese");
                }

                double bmi2 = Double.parseDouble(String.format("%.3f", bmi));
                tvdate.setText("Last Calculated Date: " + datetime);
                tvbmi.setText("Last Calculated BMI: " + bmi2);
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvdate.setText("Last Calculated Date: ");
                tvbmi.setText("Last Calculated BMI: " + 0.0);
                tvresult.setText(" ");
                etweight.setText(" ");
                etheight.setText(" ");
            }
        });
    }
}
