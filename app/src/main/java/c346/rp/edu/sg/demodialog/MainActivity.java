package c346.rp.edu.sg.demodialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button demoBtn, demoBtn2, demoBtn3, exe3, demoBtn4, demoBtn5;
    TextView demoTv2, demoTv3, exeTv4, demoTv4, demoTv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoBtn = findViewById(R.id.buttonDemo1);
        demoBtn2 = findViewById(R.id.buttonDemo2);
        demoBtn3 = findViewById(R.id.buttonDemo3);
        demoBtn4 = findViewById(R.id.buttonDemo4);
        demoBtn5 = findViewById(R.id.buttonDemo5);
        exe3 = findViewById(R.id.exe3);

        demoTv2 = findViewById(R.id.demoTv2);
        demoTv3 = findViewById(R.id.demoTv3);
        demoTv4 = findViewById(R.id.demoTv4);
        demoTv5 = findViewById(R.id.demoTv5);
        exeTv4 = findViewById(R.id.exeTv4);

        demoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder =  new AlertDialog.Builder(MainActivity.this);

//                myBuilder.setTitle("Demo 1 - Simple Dialog");
//                myBuilder.setMessage("I can develop Android App");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Close", null);

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        demoBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder =  new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 - Buttons Dialog");
                myBuilder.setMessage("I can develop Android App");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        demoTv2.setText("You have selected Positive.");
                    }
                });
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        demoTv2.setText("You have selected Negative.");
                    }
                });
                myBuilder.setNeutralButton("Cancel", null);

//                myBuilder.setTitle("Congratulations");
//                myBuilder.setMessage("You have completed a simple Dialog Box");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        demoBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder =  new AlertDialog.Builder(MainActivity.this);
                View viewDialog = getLayoutInflater().inflate(R.layout.input, null);

                final EditText inputEt = viewDialog.findViewById(R.id.inputEt);

                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setView(viewDialog);
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        demoTv3.setText(inputEt.getText().toString());
                    }
                });
                myBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        demoTv3.setText("You have selected Negative.");
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        exe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder =  new AlertDialog.Builder(MainActivity.this);
                View sumDialog = getLayoutInflater().inflate(R.layout.sum, null);

                final EditText sumEt = sumDialog.findViewById(R.id.sumEt1);
                final EditText sumEt2 = sumDialog.findViewById(R.id.sumEt2);

                myBuilder.setTitle("Exercise 3");
                myBuilder.setView(sumDialog);
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {
                            int sum = Integer.parseInt(sumEt.getText().toString()) + Integer.parseInt(sumEt2.getText().toString());
                            exeTv4.setText(String.valueOf(sum));
                        }
                        catch (NumberFormatException nfe) {

                        }

                    }
                });
                myBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exeTv4.setText("You have selected Negative.");
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        demoBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener myDateListner = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        demoTv4.setText("Date: " + dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                };

                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListner, year, month, day);
                myDateDialog.show();
            }
        });

        demoBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        demoTv5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR);
                int min = cal.get(Calendar.MINUTE);

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hour, min, false);
                myTimeDialog.show();
            }
        });
    }
}
