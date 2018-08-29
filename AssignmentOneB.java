// Codie Bryan
// Program Assignment 1
// Part B, Taxes
// Due. January 26th

/* Purpose: User is able to input information that then can be calculatd
   using the input to produce Total Adjusted Tax. */


import java.util.*;     // import utils package to be able to utilize Scanner object.

public class AssignmentOneB {
    
    public static void main(String[] args) {
        
        Scanner console = new Scanner(System.in);    //create Scanner object to read user info.
        
        /* Ask user a series of questions to get information so we can caluclate final results.
           Each question asked stores the value into variable. */
        System.out.print("Number of Exemptions: ");
        int Exe = console.nextInt();
        System.out.print("Gross Salary: ");
        double Salary = console.nextDouble();
        System.out.print("Interest Income: ");
        double Income = console.nextDouble();
        System.out.print("Capital Gains: ");
        double Gains = console.nextDouble();
        System.out.print("Charitable Contributions: ");
        double Charity = console.nextDouble();
        
        // Calculates Total Income
        double total = getTotal(Salary, Income, Gains);
        // Calculates Adjusted Income
        double Adjusted = getAdjusted(total, Exe, Charity);
        // Calculates the Total Tax
        double Tax = getTax(Adjusted);
        // Prints all the information calculated above
        getResults(total, Adjusted, Tax);
    }
    
    /* getTotal take in the parameters of Gross Salary, Interest Income and return
    the Total income type double. */
    public static double getTotal(double Salary, double Income, double Gains) {
        double total;                       // declare the total variable
        total =  Salary + Income + Gains;   // total is calculate by the sum of the three parameters.
        return total;                       // return the total to main
    }
    
    /* getAdjusted takes in the parameters of Total Income, Exceptions and Charitable Contributions
    to return the Adjusted income type double. */
    public static double getAdjusted( double total, int Exe, double Charity) {
        double adjusted;                    // declare adjusted varible.
        adjusted = total - ( Exe * 1500.00) - Charity;     // Adjusted is calculate
        return adjusted;        // Returns the adjusted to main.
    }
    
    /* getTax takes in the parameter of Adjusted to calculate to total tax of type double. */
    public static double getTax( double Adjusted) {
        double newTax = 0;            // declare the newTax variable to be reuturned
        double num = 0;               // declare a floating variable to help with calculation.
        
        //if Adjusted income is less than 10001 than the newTax is 0%
        if (Adjusted >= 0 && Adjusted < 10000) {
            newTax = newTax + (0 * Adjusted);
            /* if the adjusted is between is between 10000 and 32000, than the first 10000 is multiplied
               by the 0% adjusted rate (which is 0) than added to the amount above 10000 which is multiplied
               by the rate of 15%. Which is stored in newTax   */
        } else if (Adjusted > 10000 && Adjusted <= 32000) {
            num = Adjusted - 10000;             // the amount between 10000 and 32000
            newTax = newTax + (0.15 * num);
            /* if the adjusted is between 32001 and 50000 than the same math is applied as above but the
               full 22000 ( amount between 10000 and 32000) is multiplied by the 15% and added to how
               much is above 32000 multiplied by 23%. Which is stored in the newTax variable. */
        } else if (Adjusted > 32000 && Adjusted <= 50000 ) {
            num = Adjusted - 32000;             // the amount between 32000 and 50000
            newTax = newTax + (0.23 * Adjusted);
            /* If the adjusted is above 50000 than the same process is applied above but the full
               18000 ( amount between 32000 and 50000) is muiltiplied by 23% and added to any amount
               above 50000 multiplied by 28%. Which is stored in the newTax variable. */
        } else {
            num = Adjusted - 50000;          // the amount above 50000
            newTax = newTax + (0.28 * num);
            newTax = newTax + (0.15 * 22000) + (0.23 * 18000);
        }
        //returns the newTax calculated to the main.
        return newTax;
    }
    
    /* getResults takes in the parameters of all the data calculated above and just
       displays the values to the screen. */
    public static void getResults(double total, double Adjusted, double Tax) {
        // %.2f formats the numbers calculated to be trunkcated to 2 decimal points.
        System.out.printf("Total Income: $%.2f" , total);
        System.out.println();
        System.out.printf("Adjusted Income: $%.2f" , Adjusted);
        System.out.println();
        System.out.printf("Total Tax: $%.2f" , Tax);
    }
}