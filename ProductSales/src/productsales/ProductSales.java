package productsales;

import java.util.Arrays;

public class ProductSales {


    public static void main(String[] args) {
      //double array for row and column
    int [][] sales = {
        {300,150,700},
         {250,200,600}    
    };   
    //display header
    System.out.println("Product Sales Report - 2025");
    System.out.println("*******************************");

        int grandTotal = 0;
        int totalEntries = 0;
        int overallMin = sales[0][0];
        int overallMax = sales[0][0];

        // Process each year
        for (int[] sale : sales) {
            for (int quarter = 0; quarter < sale.length; quarter++) {
                int value = sale[quarter];
                grandTotal += value;
                totalEntries++;
                if (value < overallMin) overallMin = value;
                if (value > overallMax) overallMax = value;
            }
        }
        // Compute overall average
        double overallAverage = (double) grandTotal / totalEntries; 

        // Display summary
        System.out.println("Total Sales: " + grandTotal);
        System.out.println("Average Sales: " + String.format("%.2f", overallAverage));
        System.out.println("Minimum Sale: " + overallMin);
        System.out.println("Maximum Sale: " + overallMax);
   
        System.out.println("*******************************");
    }
}

    

