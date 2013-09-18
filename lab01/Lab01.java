import java.util.Scanner;

/**
 *  Author: Jason Sipula CsC 20 M/W 2PM
 *  Lab 01
 */
public class Lab01 {

    public static void main(String[] args) {
    
        final int num1;
        final int num2;
    
        Scanner in = new Scanner(System.in);
        
        System.out.print("\nPlease enter a 3-digit integer: ");
        
        /* read in first number */
        num1 = in.nextInt();
        
        System.out.print("\n"); /* skip to next line */
        
        System.out.print("Please enter another 3-digit integer: ");
        
        /* read in second number */
        num2 = in.nextInt();
        
        System.out.println(""); /* print blank line */
        
        /* print first number */
        System.out.printf("%10d", num1);
        
        System.out.print("\n"); /* skip to next line */
        
        System.out.print("X");
        System.out.printf("%9d", num2);
        
        System.out.print("\n"); /* skip to next line */
        
        System.out.println("----------"); /* print "equals" line */
        
        System.out.printf("%10d", ((num2 % 10) * num1)); /* calculate first line */
        
        System.out.print("\n"); /* skip to next line */
        
        System.out.printf("%9d", ((num2 / 10 % 10) * num1)); /* calculate second line */
        
        System.out.print("\n"); /* skip to next line */
        
        System.out.printf("%8d", ((num2 /100) * num1)); /* calculate third line */
        
        System.out.print("\n"); /* skip to next line */
        
        System.out.println("----------"); /* print "equals" line */
        
        System.out.printf("   %d", num1 * num2); /* print final product */

        System.out.println(""); /* return to blank line */
    
    }
    
}
