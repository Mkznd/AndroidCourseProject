package com.example.coursepriject;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;


public class ExpressionHandler {
    private static String expression;

    ExpressionHandler(String f) {
        expression = f;
    }

    public static String getExpression() {
        return expression;
    }

    public static void setExpression(String Expression) {
        ExpressionHandler.expression = Expression;
    }

    public static float Val(double x0) {
        Function f = new Function("f(x) = " + expression);
        return (float)f.calculate(x0);

    }
    @org.jetbrains.annotations.Nullable
    public static LineData createData(float from, float to, double step) {
        List<Entry> entries = new ArrayList<Entry>();
        for(float i = from;i<=to;i+=step) {
            float val = Val(i);
            if(Float.isNaN(val))return null;
            entries.add(new Entry(i, Val(i)));

        }
        LineDataSet dataSet = new LineDataSet(entries, "y = "+expression);
        dataSet.setDrawCircles(false);
        dataSet.setLineWidth(2);
        dataSet.setDrawValues(false);
        return new LineData(dataSet);
    }
}