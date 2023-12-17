package org.example;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

public class ChartGenerator {

    public static void main(String[] args) {
        List<YourDataModel> data = fetchDataFromDatabase(); // Implement this method
        CategoryChart chart = createBarChart(data);
        new SwingWrapper<>(chart).displayChart();
    }

    public static CategoryChart createBarChart(List<YourDataModel> data) {
        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("Bar Chart")
                .xAxisTitle("X Axis")
                .yAxisTitle("Y Axis")
                .build();

        // Customize chart properties and add series

        return chart;
    }
}
