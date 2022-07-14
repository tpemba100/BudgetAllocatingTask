import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("What is your spending budget?");
        Scanner scan = new Scanner(System.in);          //scanner for total budget

        double total = scan.nextDouble();               //variable to store input, nextDouble() because value can be decimal
        double sum = 0;                                 // variable to check if the sum of value input becomes over 100%
        int i = 0;                                      // this is the expense item index to track how many expenses

        boolean cut = false;
        ArrayList<Double> proportion = new ArrayList<Double>();     // new Array List variable to store Double object
                                                        // we use Array List because we do not know how much item
        System.out.println("Enter your proportion of various expenses. It cannot exceed 100%");
        System.out.println("Enter the expenses in order of importance because the last proportion may be reduced");


        // Getting the user value
        do {                                           // loops until sum is greater than 100
            System.out.println("In percentage, what is your proportion of expense " +
                    (i + 1) + ":" );                    // itterate number value after each expense item is submitted
            double value = scan.nextDouble();           // a Var to store the user input which can be decimal num
            proportion.add(value);                      // adds the user value input to proportion arraylist
            sum += proportion.get(i);                   // we get(i) the current value passed to arrlit and add to sum var
            i++;                                        // We itterate add +1 to i

        } while (sum <= 100);                           // if sum of input value goes over 100% then stop
        scan.close();                                   // we close the scanner object, because its over 100%



        // adds and checks if the total is over 100% of budget
        if (sum > 100) {                                 // if the sum goes over 100
            double cumulativeSum = 0.0;                  // Var with double decimal value
            for (int j =0; j < proportion.size() - 1; j++) {    // for Loop till the .size()-1 -> last list of Array
                cumulativeSum += proportion.get(j);             //add all the user expenses to var
            }
                                                            // subtracts the over budget
            proportion.set(proportion.size() - 1,           //ArrayList.set(last array, subtract 100 - total sum of expense)
                     100.00 - cumulativeSum);               // Subtracts the total expense with 100 and sets that to last array value
                                                            // extra expenses are being subtracted and ignored
            cut = true;
        }
        else cut = false;

        //calulates the math                       // value is temp var for the data being referenced
        for (double value: proportion) {                 //just pointing to proportion is a reference variable to the main Array List Obj.
            double expense = value * total / 100.0;      // to get the percentage based on the total 100
            System.out.println("Your " + value + "% equals $" + expense);

            double lastVal = proportion.get(proportion.size()-1);
            if (cut = true & value == lastVal) {
                System.out.println("Your last expense value was decreased ");
            }
        }
    }
}
