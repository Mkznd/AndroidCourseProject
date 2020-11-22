package com.example.coursepriject;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

public class ChartBuilder {
    public static void Build(LineChart chart, LineData dataSet){
        chart.setData(dataSet);
        chart.getDescription().setText("");
        chart.invalidate();
    }
}
