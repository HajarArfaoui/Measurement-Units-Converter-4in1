package com.example.converter_4_in_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculations extends AppCompatActivity {
    TextView tvTitle,tvConvert,tv1,tv2,tv3,tv4,tv5,tv6;
    EditText etValue;
    Spinner spinner;
    ImageView ivConvert, img;

    List<String> spinnerArrayFrom =  new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArrayFrom);
        double[] cm = {0.01,0.00001,0.393701,0.0328084,0.0109361,0.0000062137};
        /*double[] m = {100,0.0001,39.4,3.28084,1.09361,0.00062137};
        double[] km = {100000,1000,3970.1,3280.84,1093.61,0.62137};*/
        double[] in= {2.54,0.0254,0.0000254,0.084,0.0278,0.000015783};
        double[] ft ={30.48,0.3048,0.0003048,12,0.34,0.00019};
        double[] yd = {91.44,0.9144,0.0009144,36,3,0.000568};
        double[] mi = {160934,1609.34,1.60934,63360,5280,1760};

        double[] g = {0.001,0.000001,0.035274,0.00220462,0.0000011023};
        double[] oz= {28.3495,0.0283495,0.0000283495,0.0625,0.00003125};
        double[] lb= {453.592,0.453592,0.000453592,16,0.0005};
        double[] ton = {907185,907.185,0.907185,32000,2000};

        double[] ml = {0.001,0.033814,0.00211338,0.000264172};
        double[] fl_oz={28.4131,0.0284131,0.0600475,0.00750594};
        double[] pt = {473.176,0.473176,16.6535,0.125};
        double[] gallon ={3785.41,3.78541,133.228,8};


        img = findViewById(R.id.img);
        tvTitle = findViewById(R.id.tvTitle);
        spinner = findViewById(R.id.spinner);
        etValue = findViewById(R.id.etValue);
        tvConvert = findViewById(R.id.tvConvert);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        ivConvert = findViewById(R.id.ivConvert);

        String image = getIntent().getStringExtra("image");
        if(image.equals("length")){
            img.setImageResource(R.drawable.length);
            tvTitle.setText("LENGTH CONVERSIONS");
            spinnerArrayFrom.add("cm");
            spinnerArrayFrom.add("m");
            spinnerArrayFrom.add("km");
            spinnerArrayFrom.add("in");
            spinnerArrayFrom.add("ft");
            spinnerArrayFrom.add("yd");
            spinnerArrayFrom.add("mi");
        }

        else if(image.equals("volume")){
            img.setImageResource(R.drawable.volume);
            tvTitle.setText("VOLUME CONVERSIONS");
            spinnerArrayFrom.add("ml");
            spinnerArrayFrom.add("l");
            spinnerArrayFrom.add("fl_oz");
            spinnerArrayFrom.add("pt");
            spinnerArrayFrom.add("gallon");
        }
        else if(image.equals("temperature")){
            img.setImageResource(R.drawable.temperature);
            tvTitle.setText("TEMPERATURE CONVERSIONS");
            spinnerArrayFrom.add("°C");
            spinnerArrayFrom.add("°F");
            spinnerArrayFrom.add("K");
        }
       else{
            img.setImageResource(R.drawable.weight);
            tvTitle.setText("WEIGHT CONVERSIONS");
            spinnerArrayFrom.add("g");
            spinnerArrayFrom.add("kg");
            spinnerArrayFrom.add("tonne");
            spinnerArrayFrom.add("oz");
            spinnerArrayFrom.add("lb");
            spinnerArrayFrom.add("ton");
        }



        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        ivConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String selected = sItems.getSelectedItem().toString();
                if (etValue.getText().toString().isEmpty()) {
                   // Toast.makeText(Calculations.this, "No data is entered!!", Toast.LENGTH_SHORT).show();
                    showToast("No data is entered!!");
                } else {
                    tvConvert.setVisibility(View.VISIBLE);
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    tv4.setVisibility(View.VISIBLE);
                    tv5.setVisibility(View.VISIBLE);
                    tv6.setVisibility(View.VISIBLE);

                    double value= Double.parseDouble(etValue.getText().toString());
                    tvConvert.setText(value + " "+ selected);
                    switch(selected){
                        case "cm":
                            tv1.setText(new DecimalFormat("##.#####").format(value*cm[0])+" meters.");
                            tv2.setText(new DecimalFormat("##.#####").format(value*cm[1])+" kilometers.");
                            tv3.setText(new DecimalFormat("##.#####").format(value*cm[2])+" inches.");
                            tv4.setText(new DecimalFormat("##.#####").format(value*cm[3])+" foot.");
                            tv5.setText(new DecimalFormat("##.#####").format(value*cm[4])+" yards.");
                            tv6.setText(new DecimalFormat("##.#####").format(value*cm[5])+" miles.");
                            break;
                        case "m":
                            tv1.setText(new DecimalFormat("##.#####").format(value*cm[0]*100)+" centimeters.");
                            tv2.setText(new DecimalFormat("##.#####").format(value*cm[1]*100)+" kilometers.");
                            tv3.setText(new DecimalFormat("##.#####").format(value*cm[2]*100)+" inches.");
                            tv4.setText(new DecimalFormat("##.#####").format(value*cm[3]*100)+" foot.");
                            tv5.setText(new DecimalFormat("##.#####").format(value*cm[4]*100)+" yards.");
                            tv6.setText(new DecimalFormat("##.#####").format(value*cm[5]*100)+" miles.");
                            break;

                        case "km":
                            tv1.setText(new DecimalFormat("##.#####").format(value*cm[0]*100000)+" centimeters.");
                            tv2.setText(new DecimalFormat("##.#####").format(value*cm[1]*100000)+" meters.");
                            tv3.setText(new DecimalFormat("##.#####").format(value*cm[2]*100000)+" inches.");
                            tv4.setText(new DecimalFormat("##.#####").format(value*cm[3]*100000)+" foot.");
                            tv5.setText(new DecimalFormat("##.#####").format(value*cm[4]*100000)+" yards.");
                            tv6.setText(new DecimalFormat("##.#####").format(value*cm[5]*100000)+" miles.");
                            break;
                        case "in":
                            tv1.setText(new DecimalFormat("##.#####").format(value*in[0])+" centimeters.");
                            tv2.setText(new DecimalFormat("##.#####").format(value*in[1])+" meters.");
                            tv3.setText(new DecimalFormat("##.#####").format(value*in[2])+" kilometers.");
                            tv4.setText(new DecimalFormat("##.#####").format(value*in[3])+" foot.");
                            tv5.setText(new DecimalFormat("##.#####").format(value*in[4])+" yards.");
                            tv6.setText(new DecimalFormat("##.#####").format(value*in[5])+" miles.");
                            break;
                        case "ft":
                            tv1.setText(new DecimalFormat("##.#####").format(value*ft[0])+" centimeters.");
                            tv2.setText(new DecimalFormat("##.#####").format(value*ft[1])+" meters.");
                            tv3.setText(new DecimalFormat("##.#####").format(value*ft[2])+" kilometers.");
                            tv4.setText(new DecimalFormat("##.#####").format(value*ft[3])+" inches.");
                            tv5.setText(new DecimalFormat("##.#####").format(value*ft[4])+" yards.");
                            tv6.setText(new DecimalFormat("##.#####").format(value*ft[5])+" miles.");
                            break;
                        case "yd":
                            tv1.setText(new DecimalFormat("##.#####").format(value*yd[0])+" centimeters.");
                            tv2.setText(new DecimalFormat("##.#####").format(value*yd[1])+" meters.");
                            tv3.setText(new DecimalFormat("##.#####").format(value*yd[2])+" kilometers.");
                            tv4.setText(new DecimalFormat("##.#####").format(value*yd[3])+" inches.");
                            tv5.setText(new DecimalFormat("##.#####").format(value*yd[4])+" foots.");
                            tv6.setText(new DecimalFormat("##.#####").format(value*yd[5])+" miles.");
                            break;
                        case "mi":
                            tv1.setText(new DecimalFormat("##.#####").format(value*mi[0])+" centimeters.");
                            tv2.setText(new DecimalFormat("##.#####").format(value*mi[1])+" meters.");
                            tv3.setText(new DecimalFormat("##.#####").format(value*mi[2])+" kilometers.");
                            tv4.setText(new DecimalFormat("##.#####").format(value*mi[3])+" inches.");
                            tv5.setText(new DecimalFormat("##.#####").format(value*mi[4])+" foot.");
                            tv6.setText(new DecimalFormat("##.#####").format(value*mi[5])+" yards.");
                            break;

                        case "g":
                            tv1.setText(new DecimalFormat("##.#######").format(value*g[0])+" kilograms.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*g[1])+" tonnes.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*g[2])+" ounces.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*g[3])+" pounds.");
                            tv5.setText(new DecimalFormat("##.#######").format(value*g[4])+" tons.");
                            break;
                        case "kg":
                            tv1.setText(new DecimalFormat("##.#######").format(value*g[0]*1000)+" grams.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*g[1]*1000)+" tonnes.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*g[2]*1000)+" ounces.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*g[3]*1000)+" pounds.");
                            tv5.setText(new DecimalFormat("##.#######").format(value*g[4]*1000)+" tons.");
                            break;
                        case "tonne":
                            tv1.setText(new DecimalFormat("##.#######").format(value*g[0]*1000000)+" grams.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*g[1]*1000000)+" kilograms.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*g[2]*1000000)+" ounces.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*g[3]*1000000)+" pounds.");
                            tv5.setText(new DecimalFormat("##.#######").format(value*g[4]*1000000)+" tons.");
                            break;
                        case "oz":
                            tv1.setText(new DecimalFormat("##.#######").format(value*oz[0])+" grams.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*oz[1])+" kilograms.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*oz[2])+" tonnes.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*oz[3])+" pounds.");
                            tv5.setText(new DecimalFormat("##.#######").format(value*oz[4])+" tons.");
                            break;
                        case "lb":
                            tv1.setText(new DecimalFormat("##.#######").format(value*lb[0])+" grams.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*lb[1])+" kilograms.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*lb[2])+" tonnes.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*lb[3])+" ounces.");
                            tv5.setText(new DecimalFormat("##.#######").format(value*lb[4])+" tons.");
                            break;
                        case "ton":
                            tv1.setText(new DecimalFormat("##.#######").format(value*ton[0])+" grams.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*ton[1])+" kilograms.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*ton[2])+" tonnes.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*ton[3])+" ounces.");
                            tv5.setText(new DecimalFormat("##.#######").format(value*ton[4])+" pounds.");
                            break;

                        case("ml"):
                            tv1.setText(new DecimalFormat("##.#######").format(value*ml[0])+" liters.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*ml[1])+" fluid ounces.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*ml[2])+" US pints.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*ml[3])+" US liquid gallons.");
                            break;
                        case("l"):
                            tv1.setText(new DecimalFormat("##.#######").format(value*ml[0]*1000)+" mililiters.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*ml[1]*1000)+" fluid ounces.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*ml[2]*1000)+" US pints.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*ml[3]*1000)+" US liquid gallons.");
                            break;
                        case("fl_oz"):
                            tv1.setText(new DecimalFormat("##.#######").format(value*fl_oz[0])+" mililiters.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*fl_oz[1])+" liters.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*fl_oz[2])+" US pints.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*fl_oz[3])+" US liquid gallons.");
                            break;
                        case("pt"):
                            tv1.setText(new DecimalFormat("##.#######").format(value*pt[0])+" mililiters.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*pt[1])+" liters.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*pt[2])+" fluid ounces.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*pt[3])+" US liquid gallons.");
                            break;
                        case("gallon"):
                            tv1.setText(new DecimalFormat("##.#######").format(value*gallon[0])+" mililiters.");
                            tv2.setText(new DecimalFormat("##.#######").format(value*gallon[1])+" liters.");
                            tv3.setText(new DecimalFormat("##.#######").format(value*gallon[2])+" fluid ounces.");
                            tv4.setText(new DecimalFormat("##.#######").format(value*gallon[3])+" US pints.");
                            break;

                        case("°C"):
                            tv1.setText(new DecimalFormat("##.#######").format((value*9/5) + 32)+" Fahrenheit.");
                            tv2.setText(new DecimalFormat("##.#######").format(value + 273.15)+" Kelvin.");
                            break;
                        case("°F"):
                            tv1.setText(new DecimalFormat("##.#######").format(((value - 32)*5/9))+" Celsius.");
                            tv2.setText(new DecimalFormat("##.#######").format((value - 32)* 5/9 + 273.15)+" Kelvin.");
                            break;
                        case("K"):
                            tv1.setText(new DecimalFormat("##.#######").format(value - 273.15)+" Celsius.");
                            tv2.setText(new DecimalFormat("##.#######").format((value - 273.15)*9/5+ 32)+" Fahrenheit.");
                            break;


                    }
                   /* if (selected.equals("cm")) {
                        tvConvert.setText(value + " "+ selected);
                        tv1.setText(new DecimalFormat("##.#####").format(value*cm[0])+" meters.");
                        tv2.setText(new DecimalFormat("##.#####").format(value*cm[1])+" kilometers.");
                        tv3.setText(new DecimalFormat("##.#####").format(value*cm[2])+" inches.");
                        tv4.setText(new DecimalFormat("##.#####").format(value*cm[3])+" foot.");
                        tv5.setText(new DecimalFormat("##.#####").format(value*cm[4])+" yards.");
                        tv6.setText(new DecimalFormat("##.#####").format(value*cm[5])+" miles");
                    }
                    if (selected.equals("m")) {
                        tvConvert.setText(value + " "+ selected);
                        tv1.setText(new DecimalFormat("##.#####").format(value*cm[0]*100)+" centimeters.");
                        tv2.setText(new DecimalFormat("##.#####").format(value*cm[1]*100)+" kilometers.");
                        tv3.setText(new DecimalFormat("##.#####").format(value*cm[2]*100)+" inches.");
                        tv4.setText(new DecimalFormat("##.#####").format(value*cm[3]*100)+" foot.");
                        tv5.setText(new DecimalFormat("##.#####").format(value*cm[4]*100)+" yards.");
                        tv6.setText(new DecimalFormat("##.#####").format(value*cm[5]*100)+" miles");
                    }
                    if (selected.equals("km")) {
                        tvConvert.setText(value + " "+ selected);
                        tv1.setText(new DecimalFormat("##.#####").format(value*cm[0]*100000)+" centimeters.");
                        tv2.setText(new DecimalFormat("##.#####").format(value*cm[1]*100000)+" meters.");
                        tv3.setText(new DecimalFormat("##.#####").format(value*cm[2]*100000)+" inches.");
                        tv4.setText(new DecimalFormat("##.#####").format(value*cm[3]*100000)+" foot.");
                        tv5.setText(new DecimalFormat("##.#####").format(value*cm[4]*100000)+" yards.");
                        tv6.setText(new DecimalFormat("##.#####").format(value*cm[5]*100000)+" miles");
                    }
                    if (selected.equals("in")) {
                        tvConvert.setText(value + " "+ selected);
                        tv1.setText(new DecimalFormat("##.#####").format(value*in[0])+" centimeters.");
                        tv2.setText(new DecimalFormat("##.#####").format(value*in[1])+" meters.");
                        tv3.setText(new DecimalFormat("##.#####").format(value*in[2])+" kilometers.");
                        tv4.setText(new DecimalFormat("##.#####").format(value*in[3])+" foot.");
                        tv5.setText(new DecimalFormat("##.#####").format(value*in[4])+" yards.");
                        tv6.setText(new DecimalFormat("##.#####").format(value*in[5])+" miles");
                    }
                    if (selected.equals("ft")) {
                        tvConvert.setText(value + " "+ selected);
                        tv1.setText(new DecimalFormat("##.#####").format(value*ft[0])+" centimeters.");
                        tv2.setText(new DecimalFormat("##.#####").format(value*ft[1])+" meters.");
                        tv3.setText(new DecimalFormat("##.#####").format(value*ft[2])+" kilometers.");
                        tv4.setText(new DecimalFormat("##.#####").format(value*ft[3])+" inches.");
                        tv5.setText(new DecimalFormat("##.#####").format(value*ft[4])+" yards.");
                        tv6.setText(new DecimalFormat("##.#####").format(value*ft[5])+" miles");
                    }
                    if (selected.equals("yd")) {
                        tvConvert.setText(value + " "+ selected);
                        tv1.setText(new DecimalFormat("##.#####").format(value*yd[0])+" centimeters.");
                        tv2.setText(new DecimalFormat("##.#####").format(value*yd[1])+" meters.");
                        tv3.setText(new DecimalFormat("##.#####").format(value*yd[2])+" kilometers.");
                        tv4.setText(new DecimalFormat("##.#####").format(value*yd[3])+" inches.");
                        tv5.setText(new DecimalFormat("##.#####").format(value*yd[4])+" foots.");
                        tv6.setText(new DecimalFormat("##.#####").format(value*yd[5])+" miles");
                    }
                    if (selected.equals("mi")) {
                        tvConvert.setText(value + " "+ selected);
                        tv1.setText(new DecimalFormat("##.#####").format(value*mi[0])+" centimeters.");
                        tv2.setText(new DecimalFormat("##.#####").format(value*mi[1])+" meters.");
                        tv3.setText(new DecimalFormat("##.#####").format(value*mi[2])+" kilometers.");
                        tv4.setText(new DecimalFormat("##.#####").format(value*mi[3])+" inches.");
                        tv5.setText(new DecimalFormat("##.#####").format(value*mi[4])+" foot.");
                        tv6.setText(new DecimalFormat("##.#####").format(value*mi[5])+" yards");
                    }*/

                    etValue.setText("");

                }

            }
        });
    }
    public void showToast(String msg)
    {
        View toastView = getLayoutInflater().inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.linlay));
        TextView tvToast = (TextView) toastView.findViewById(R.id.tvToast);
        tvToast.setText(msg);
        Toast toast = new Toast(Calculations.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL,0,0);
        toast.show();
    }
}