package org.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfGenerator {

    public static void main(String[] args) {
        List<YourDataModel> data = fetchDataFromDatabase(); // Implement this method
        CategoryChart chart = ChartGenerator.createBarChart(data);
        createPdfWithChart(chart, "path/to/your/output.pdf");
    }

    public static void createPdfWithChart(CategoryChart chart, String pdfFilePath) {
        try (Document document = new Document()) {
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
            document.open();

            // Convert the chart to an image
            byte[] chartImageBytes = BitmapEncoder.getBitmapBytes(chart, BitmapFormat.PNG);

            // Embed the image into the PDF
            Image chartImage = Image.getInstance(chartImageBytes);
            document.add(chartImage);

            // Add more content or sections as needed

            document.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}

