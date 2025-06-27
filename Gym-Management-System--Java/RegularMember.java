import javax.swing.JOptionPane;
// RegularMember is a subclass and it inherit parentclass that is GymMember 
public class RegularMember extends GymMember {

    //making all attributes private
     
    private final int ATTENDANCE_LIMIT = 30;
    //making attendence limit final attribute and making attendence limit to 30
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    //making Constructor for Regular member class
    
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate); //calling superclass constructor//
        this.referralSource = referralSource;

        this.isEligibleForUpgrade = false;
        //Setting the value false for isEligibleForUpgrade
        
        this.plan = "basic";
        // Setting the value basic for this.plan

        this.price = 6500.0;
        //Setting the value 6500.0 for this.price

        this.removalReason = "";
        // Setting the value as empty for this.removalReason
    }

    // this is accessor methods
    
    //Getter method for attendanceLimit
    public int getAttendanceLimit() {
        return ATTENDANCE_LIMIT;
        //Setting return value as the value of attendanceLimit
    }

    //Getter method for isEligibleForUpgrade
    public boolean getIsEligibleForUpgrade() {
        return isEligibleForUpgrade;
        //Setting return value as the value of isEligibleForUpgrade
    }

    //Getter method for removalReason
    public String getRemovalReason() {
        return removalReason;
        //Setting return value as the value of removalReason
    }

    //Getter method for referralSource
    public String getReferralSource() {
        return referralSource;
        //setting return value as the value of referralSource
    }

    //Getter method for plan
    public String getPlan() {
        return plan;
        //Setting return value as the value of plan
    }

    //Getter method for price
    public double getPrice() {
        return price;
        // Setting return value as the value of price
    }

    //Method to get plan subscription and price
    public double getPlanPrice(String plan) {
        switch (plan) //using switch method for plan subscription and price
        {
            case "basic":
                return 6500.0;
            case "standard":
                return 12500.0;
            case "deluxe":
                return 18500.0;
            default:
                return -1;
            //Invalid plan
             
        }
    }

    //implementing abstract method in markAttendance
     
    //Overriding markattendence method
     

    @Override
    public void markAttendance() {
        if(activeStatus){
        this.attendance++;
        //Increment attendence value
         
        this.loyaltyPoints += 5;
        if (this.attendance >= ATTENDANCE_LIMIT) {
            this.isEligibleForUpgrade = true;
        }
        }
    }

    //Method to upgrade or downgrade the plan subscription
     
    public String upgradePlan(String newPlan) {
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) //Checking if the plan is invalid
         
        {
            return "Invalid plan selected.";
        }
        if (!isEligibleForUpgrade) {
            return "Member is not eligible for an upgrade.";
        }
        //For Upgrading or downgrading plan subscription according to the current plan
         
        if (this.plan.equalsIgnoreCase("basic")) {
            if (newPlan.equalsIgnoreCase("standard")) {
                this.plan = newPlan;
                this.price = newPrice;
                return "Plan has been successfuly upgraded to" + newPlan;
            }

            if (newPlan.equalsIgnoreCase("deluxe")) {
                this.plan = newPlan;
                this.price = newPrice;
                return "Plan has been successfully upgraded to" + newPlan;
            }
        } else if (this.plan.equalsIgnoreCase("standard")) {
            if (newPlan.equalsIgnoreCase("deluxe")) {
                this.plan = newPlan;
                this.price = newPrice;
                return "Plan has been successfully upgraded to" + newPlan;
            }

        }

        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "Member is already subscribed to" + newPlan;
        }
        return "Invalid upgrade request.";
    }

    //Method to revert RegularMember details
     
    public void revertRegularMember(String removalReason) {
        super.resetMember();
        //calling superclass resetMember method
         
        this.isEligibleForUpgrade = false;
        //Setting value as false for this.isEligibleForUpgrade
         
        this.plan = "basic";
        //Setting value as basic for this.plan
         
        this.price = 6500.0;
        //Setting value as 6500.0 for this.price
         
        this.removalReason = removalReason;
        //Updating the value of removalReason
         
    }

    //this is a Display method
     
    //Overriding the display method
     
    @Override
public String display() {
    String result = super.display(); // Calls the parent class method

    result += "Plan: " + plan + "\n";
    result += "Price: " + price + "\n";

    if (removalReason != null && !removalReason.isEmpty()) {
        result += "Removal Reason: " + removalReason + "\n";
    }

    return result;
}

}
