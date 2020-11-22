package com.example.coursepriject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

public class MainActivity extends AppCompatActivity {
    String expression;
    float from, to;
    double step;
    TextView textView;
    LineChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(chart == null)return;
        else{
            Expression(findViewById(R.id.content).getRootView());
        }
    }
    public void getInfo(){
        expression = ((EditText) findViewById(R.id.expression)).getText().toString();
        from = Float.parseFloat(((EditText) findViewById(R.id.from)).getText().toString());
        to = Float.parseFloat(((EditText) findViewById(R.id.to)).getText().toString());
        step = Double.parseDouble(((EditText) findViewById(R.id.step)).getText().toString());
        textView = (TextView) findViewById(R.id.text);
        chart = (LineChart) findViewById(R.id.chart);
    }


    public void Expression(View view) {
        getInfo();
        ExpressionHandler.setExpression(expression);
        LineData dataSet = ExpressionHandler.createData(from,to,step);
        if(dataSet == null){
            Toast.makeText(getApplicationContext(), "Invalid parameters!", Toast.LENGTH_LONG).show();
            return;
        }
        ChartBuilder.Build(chart, dataSet);
    }
}