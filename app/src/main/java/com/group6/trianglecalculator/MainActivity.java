package com.group6.trianglecalculator;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Triangle triangle;
    private String theorem;
    private LinearLayout inputLayout;
    private LinearLayout outputLayout;

    //image view for reference triangle
    ImageView referenceImage;

    //inputs and labels
    private EditText sideAinput;
    private EditText sideBinput;
    private EditText sideCinput;
    private EditText angleAinput;
    private EditText angleBinput;
    private EditText angleCinput;

    private TextView sideALabel;
    private TextView sideBLabel;
    private TextView sideCLabel;
    private TextView angleALabel;
    private TextView angleBLabel;
    private TextView angleCLabel;



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
                resetLayout(inputLayout);

                switch(item){
                    case "AAS":
                        instantiateAAS();
                        break;
                    case "ASA":
                        instantiateASA();
                        break;
                    case "SAS":
                        instantiateSAS();
                        break;
                    case "AAA":
                        instantiateAAA();
                        break;
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

        //create labels and inputs
        CreateLabelsAndInputs();

        //bind referenceImage
        referenceImage = findViewById(R.id.imageView);

    }

    public void calculateTriangle(View view){
        System.out.println(theorem);
        EditText focus = (EditText) getCurrentFocus();
        if (focus != null){
            focus.onEditorAction(EditorInfo.IME_ACTION_DONE);
        }
        //switch statement to decide theorem method
        switch(theorem){
            case "AAA":
                triangle.CalculateAAA(
                        Double.parseDouble(angleAinput.getText().toString()),
                        Double.parseDouble(angleBinput.getText().toString())
                );
                break;
            case "AAS":
                triangle.CalculateAAS(
                        Double.parseDouble(angleAinput.getText().toString()),
                        Double.parseDouble(angleBinput.getText().toString()),
                        Double.parseDouble(sideAinput.getText().toString())
                );
                break;
            case "SAS":
                triangle.CalculateSAS(
                        Double.parseDouble(sideCinput.getText().toString()),
                        Double.parseDouble(angleBinput.getText().toString()),
                        Double.parseDouble(sideAinput.getText().toString())
                );
                break;

            case "ASA":
                triangle.CalculateASA(
                        Double.parseDouble(angleAinput.getText().toString()),
                        Double.parseDouble(sideCinput.getText().toString()),
                        Double.parseDouble(angleBinput.getText().toString())
                );
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
    public void instantiateSAS(){

        inputLayout.addView(sideCLabel);
        inputLayout.addView(sideCinput);
        inputLayout.addView(angleBLabel);
        inputLayout.addView(angleBinput);
        inputLayout.addView(sideALabel);
        inputLayout.addView(sideAinput);
        referenceImage.setImageResource(R.drawable.sas_white_background);
    }
    public void instantiateAAS(){

        inputLayout.addView(angleALabel);
        inputLayout.addView(angleAinput);
        inputLayout.addView(angleBLabel);
        inputLayout.addView(angleBinput);
        inputLayout.addView(sideALabel);
        inputLayout.addView(sideAinput);
        referenceImage.setImageResource(R.drawable.aas_white_background);
    }
    public void instantiateASA(){

        inputLayout.addView(angleALabel);
        inputLayout.addView(angleAinput);
        inputLayout.addView(sideCLabel);
        inputLayout.addView(sideCinput);
        inputLayout.addView(angleBLabel);
        inputLayout.addView(angleBinput);
        referenceImage.setImageResource(R.drawable.asa_white_background);
    }
    public void instantiateAAA(){


        inputLayout.addView(angleALabel);
        inputLayout.addView(angleAinput);
        inputLayout.addView(angleBLabel);
        inputLayout.addView(angleBinput);
        referenceImage.setImageResource(R.drawable.aaa_white_background);

    }
    public void instantiateSSS(){

        inputLayout.addView(sideALabel);
        inputLayout.addView(sideAinput);
        inputLayout.addView(sideBLabel);
        inputLayout.addView(sideBinput);
        inputLayout.addView(sideCLabel);
        inputLayout.addView(sideCinput);
        referenceImage.setImageResource(R.drawable.sss_white_background);

    }

    public void CreateLabelsAndInputs(){
        sideALabel = new TextView(this);
        sideALabel.setText("Enter length of Side a: ");
        sideALabel.setTextSize(18f);
        sideAinput = new EditText(this);
        sideAinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        sideAinput.setTag("SideAInput");

        sideBLabel = new TextView(this);
        sideBLabel.setPadding(0,20,0,0);
        sideBLabel.setText("Enter length of Side b: ");
        sideBLabel.setTextSize(18f);
        sideBinput = new EditText(this);
        sideBinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        sideBinput.setTag("SideBInput");


        sideCLabel = new TextView(this);
        sideCLabel.setPadding(0,20,0,0);
        sideCLabel.setText("Enter length of Side c: ");
        sideCLabel.setTextSize(18f);
        sideCinput = new EditText(this);
        sideCinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        sideCinput.setTag("SideCInput");

        angleALabel = new TextView(this);
        angleALabel.setPadding(0,20,0,0);
        angleALabel.setText("Enter Angle A in Degrees: ");
        angleALabel.setTextSize(18f);
        angleAinput = new EditText(this);
        angleAinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        angleAinput.setTag("angleAInput");

        angleBLabel = new TextView(this);
        angleBLabel.setPadding(0,20,0,0);
        angleBLabel.setText("Enter Angle B in Degrees: ");
        angleBLabel.setTextSize(18f);
        angleBinput = new EditText(this);
        angleBinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        angleBinput.setTag("angleBInput");

        angleCLabel = new TextView(this);
        angleCLabel.setPadding(0,20,0,0);
        angleCLabel.setText("Enter Angle C in Degrees: ");
        angleCLabel.setTextSize(18f);
        angleCinput = new EditText(this);
        angleCinput.setInputType(InputType.TYPE_CLASS_NUMBER);
        angleCinput.setTag("angleCInput");

    }

    public void resetLayout(LinearLayout layout){
        for(int i = 0; i < layout.getChildCount(); i++){
            View currentView = layout.getChildAt(i);
            if (currentView instanceof EditText){
                ((EditText) currentView).setText("");
            }

        }
        layout.removeAllViews();
    }

}