
//PremiumMember is a subclass so it inherit parentclass that is GymMember 

import javax.swing.JOptionPane;

public class PremiumMember extends GymMember 
{

    final double PREMIUM_CHARGE = 50000.0;
    //making premiumCharge final attribute and declaring the value of
     
    String personalTrainer;
    boolean isFullPayment;
    double paidAmount;
    double discountAmount;

    
    //making constructor for Premium Member class
     
    public PremiumMember(int id, String name, String location, String phone,
            String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        //calling superclass or parent class constructor
        this.personalTrainer = personalTrainer;
        
        //Updating the value of personalTrainer
         
        this.paidAmount = 0.0;
        
        //Setting the value to 0.0 for paidAmount
         
        this.isFullPayment = false;
        
        //Setting the value to false for isFullPayment
         
        this.discountAmount = 0.0;
        
        //Setting the value to 0.0 for discountAmount
         
    }

    
    //this is accessor method
     //Getter method for premiumCharge
     
    public double getPremiumCharge() {
        return this.PREMIUM_CHARGE;
        
        //Setting return value as the value of premiumCharge
         
    }

    
    //Getter method for personalTrainer
     
    public String getPersonalTrainer() {
        return this.personalTrainer;
        
        //Setting return value as the value of personalTrainer
         
    }

    
    //Getter method for isFullPayment
     
    public boolean getIsFullPayment() {
        return this.isFullPayment;
        
        //Setting return value as the value of isFullPayment
         
    }

    
    //Getter method for paidAmount
     
    public double getPaidAmount() {
        return this.paidAmount;
        
        //Setting return value as the value of paidAmount
         
    }

    
    //Getter method for discountAmount
     
    public double getDiscountAmount() {
        return this.discountAmount;
        
        //Setting return value as the value of discountAmount
         
    }

    
    //implemanting abstract method for markAttendance
     
    
    //Overriding markattendance method
     
    @Override
    public void markAttendance() {
        if (activeStatus) {
            
            this.attendance++;
            
            //Increment attendance value
             
            this.loyaltyPoints += 10;
            
            //Increasing value of loyaltypoint by 10 points
        }
         
    }

    
    //Method to check about amount or payments
     
    public String payDueAmount(double paidAmount) {
        if (this.isFullPayment)
         // this.isFullPayment == true
         
        {
            return "Payment is already full.";
        }

        if (this.paidAmount + paidAmount > PREMIUM_CHARGE) {
            return "Total paid amount exceeds the premium charge.";
        }

        this.paidAmount += paidAmount;

        if (this.paidAmount == PREMIUM_CHARGE) {
            isFullPayment = true;
        } else {
            isFullPayment = false;
        }

        double remainingAmount = PREMIUM_CHARGE - this.paidAmount;
        return "Payment successful. Remaining amount to be paid: " + remainingAmount;
    }

    
    //Method for calculating Discount
     
    public String calculateDiscount() {
        if (isFullPayment) {
           // isFullPayemnet == true
            discountAmount = PREMIUM_CHARGE * 0.10;
            
            //Calculating discountAmount by giving 10% discount
             
            return "Discount applied successfully. Discount amount: " + discountAmount;
        } else {
            return "No discount available. Full payment not yet done.";
        }
    }
    
    //Method for revertPremiumMember
     
    public void revertPremiumMember() {
        resetMember();//calling superclass method
        this.personalTrainer = "";
        
        //Setting the value empty for this.personalTrainer
         
        this.isFullPayment = false;
        
        //Setting the value false for this.isFullPayment
         
        this.paidAmount = 0.0;
        
        //Setting the value 0.0 for this.paidAmount
         
        this.discountAmount = 0.0;
        
        //Setting the value 0.0 for this.discountAmount
         
    }

    
    //implementing abstract method
     
    
    //Overriding display method
     
    @Override
    public String display() {
        String result = super.display(); //Call GymMember's display() method

        result += "Personal Trainer: " + this.personalTrainer + "\n";
        result += "Paid Amount: " + this.paidAmount + "\n";
        result += "Is Full Payment: " + isFullPayment + "\n";

        double remainingAmount = PREMIUM_CHARGE - this.paidAmount;
        result += "Amount Remain to Pay: " + remainingAmount + "\n";

        if (isFullPayment) {
            result += "Discounted Amount: " + this.discountAmount + "\n";
        }

        return result;
    }

}
