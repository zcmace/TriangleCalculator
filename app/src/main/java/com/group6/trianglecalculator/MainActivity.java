package com.group6.trianglecalculator;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Triangle triangle;
    private String theorem;
    private LinearLayout inputLayout;
    private LinearLayout outputLayout;
    private EditText sideAinput;
    private EditText sideBinput;
    private EditText sideCinput;
    private EditText angleAInput;
    private EditText anlgeBInput;
    private EditText angleCInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set triangle object
        triangle = new Triangle();
        //grab layouts
        inputLayout = (LinearLayout) findViewById(R.id.inputLayout);
        outputLayout = (LinearLayout) findViewById(R.id.outputLayout);


        /* The next few lines populates the spinner with the string-array located in res/strings
        * It also adds the appropriate listeners to handle selections
        */

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.theorems_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //on selected handler for spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                System.out.println(item);
                theorem = item;

                switch(item){
                    case "SSS":
                        instantiateSSS();
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    public void calculateTriangle(View view){
        System.out.println(theorem);

        //switch statement to decide theorem method
        switch(theorem){
            case "AAA":
                break;
            case "AAS":
                break;
            case "SAS":
                break;

            case "ASA":
                break;
            case "SSS":
                triangle.CalculateSSS(
                        Double.parseDouble(sideAinput.getText().toString()),
                        Double.parseDouble(sideBinput.getText().toString()),
                        Double.parseDouble(sideCinput.getText().toString())
                        );
                break;
            default:
                break;

        }

        triangle.debugLog();
    }
    public void instantiateAAA(){

    }
    public void instantiateSSS(){

        inputLayout.removeAllViews();

        TextView sideALabel = new TextView(this);
        sideALabel.setText("Enter length of Side A: ");
        sideALabel.setTextSize(18f);
        sideAinput = new EditText(this);
        sideAinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        sideAinput.setTag("SideAInput");

        TextView sideBLabel = new TextView(this);
        sideBLabel.setPadding(0,20,0,0);
        sideBLabel.setText("Enter length of Side B: ");
        sideBLabel.setTextSize(18f);
        sideBinput = new EditText(this);
        sideBinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        sideBinput.setTag("SideBInput");


        TextView sideCLabel = new TextView(this);
        sideCLabel.setPadding(0,20,0,0);
        sideCLabel.setText("Enter length of Side C: ");
        sideCLabel.setTextSize(18f);
        sideCinput = new EditText(this);
        sideCinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        sideCinput.setTag("SideCInput");



        inputLayout.addView(sideALabel);
        inputLayout.addView(sideAinput);
        inputLayout.addView(sideBLabel);
        inputLayout.addView(sideBinput);
        inputLayout.addView(sideCLabel);
        inputLayout.addView(sideCinput);



    }





}