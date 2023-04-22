import java.util.*;

public class GrossPayCalculator {

    public static void main(String[] args) {
        
        
/* =============================================================================================== */


        // Variables
        String Employee_Name;
        char Contract;
        
        double MonthlySalary;
        double Rate;
        
        int HrsWorked;
        int HrsOvertime;
        
        
/* =============================================================================================== */


        // Intro
        System.out.println          ( " Gross Pay Calculator " );
        System.out.println          ( " --------------------------------------------- " );
        
        
/* =============================================================================================== */
        
        
        // Scanner a.k.a Main Menu
        Scanner prompt              = new Scanner(System.in);
            
            System.out.println      ( "\n" );
            System.out.print        ( " Enter your name: " );
            Employee_Name           = prompt.nextLine();
            
            System.out.println      ( " ( Full Time[F] / Part Time[P] ) " );
            System.out.print        ( " Enter your employee contract type [ F/P ]: " );
            Contract                = prompt.nextLine().charAt(0);
            
            
/* =============================================================================================== */


        // Full Time Sub Menu
        if ( Contract == 'F' | Contract == 'f' ) {
            
            try {
                
                System.out.println  ( "\n" );
                System.out.println  ( " You picked Full Time... " );
                Thread.sleep        (1000);
                
                System.out.println  ( " Processing... Please wait... " );
                Thread.sleep        (2000);
                
            }
            
            catch ( InterruptedException e ) {
                
                System.out.println  ( "\n" );
                System.out.println  ( " Something happend... What did you do? " );
                
            }
            
            System.out.println      ( "\n" );
            System.out.print        ( " Enter your Monthly Salary: " );
            MonthlySalary           = prompt.nextDouble();
            
            // Variables
            double GrossPay = MonthlySalary ;
            
            // Display Output
            System.out.println      ( "\n" );
            System.out.println      ( "--------- Full Time ---------" );
            System.out.println      ( " Employee Name: " + Employee_Name );
            System.out.println      ( " MonthlySalary: " + "$ " + String.format ( "%.2f", MonthlySalary ) );
            System.out.println      ( "-----------------------------" );
            System.out.println      ( "Gross Pay: " + "$ " + String.format ("%.2f", GrossPay ) );
            System.out.println      ( "\n" );
			prompt.close();
			System.exit(0);
            
        }
        
        
/* =============================================================================================== */
        
        
        // Part Time Sub Menu
        else if ( Contract == 'P' | Contract == 'p' ) {
            
            try {
                
                System.out.println  ( "\n" );
                System.out.println  ( " You picked Part Time... " );
                Thread.sleep        (1000);
                
                System.out.println  ( " Processing... Please wait... " );
                Thread.sleep        (2000);
                
            }
            
            catch ( InterruptedException e ) {
                
                System.out.println  ( "\n" );
                System.out.println  ( " Something happend... What did you do? " );
                
            }
            
            System.out.println      ( "\n" );
            System.out.print        ( " Enter your Rate (Pay) per hour: " );
            Rate                    = prompt.nextFloat();
            
            System.out.print        ( " Enter your number of hours worked: " );
            HrsWorked               = prompt.nextInt();
            
            System.out.print        ( " Enter your number of hours overtime: " );
            HrsOvertime             = prompt.nextInt();
            
            // Variable
            double BasicPay         = Rate * HrsWorked ;
            double OvrTimePay       = HrsOvertime * ( Rate * 1.25 );
            double GrossPay         = BasicPay + OvrTimePay;
            
            // Display Output
            System.out.println      ( "\n" );
            System.out.println      ( "--------- Part Time ---------" );
            System.out.println      ( " Employee Name: " + Employee_Name );
            System.out.println      ( " Basic Pay: " + "$ " + String.format ( "%.2f", BasicPay ) );
            System.out.println      ( " Overtime Pay: " + "$ " + String.format ( "%.2f", OvrTimePay ) );
            System.out.println      ( "-----------------------------" );
            System.out.println      ( " Gross Pay: " + "$ " + String.format ( "%.2f", GrossPay ) );
            System.out.println      ( "\n" );
			prompt.close();
			System.exit(0);
            
        }
        
        
/* =============================================================================================== */
        
        
        else {
            
            System.out.println      ( "\n" );
            System.out.println      ( " Error... Do you even know how to read? " );
			prompt.close();
			System.exit(1);
            
        }
        
    }
    
}
