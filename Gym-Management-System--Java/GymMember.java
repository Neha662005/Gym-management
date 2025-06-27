//GymMember is a parentclass and the class is declared as abstract 
public abstract class GymMember
{
    //making all attributes protected 
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    //making constructor for gymmember class 
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate)
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0; //Setting value as 0 for this.attendence 
        this.loyaltyPoints = 0.0; // Setting value as 0.0 for this.loyaltyPoints 
        this.activeStatus = false; //Setting value as false for this.activeStatus 
    }

    
    // this is accessor method 
    // Getter method for id 
    public int getId()
    {
        return this.id; //Setting return value as the value of id 
    }
    
    // Getter method for Name 
    public String getName()
    {
        return this.name; // Setting return value as the value of name
    }
   
    // Getter method for location 
    public String getLocation()
    {
        return this.location; // Setting return value as the value of location 
    }
    
    //Getter method for phone 
    public String getPhone()
    {
        return this.phone; //Setting return value as the value of phone 
    }
    
    //Getter method for email 
    public String getEmail()
    {
        return this.email; //Setting return value as the value of email 
    }
   
    // Getter method for gender
    public String getGender()
    {
        return this.gender; // Setting return value as the value of gender
    }
    
    //Getter method for DOB 
    public String getDOB()
    {
        return this.DOB; //Setting return value as the value of DOB 
    }
    
    // Getter method for membershipStartDate 
    public String getMembershipStartDate()
    {
        return this.membershipStartDate; //Setting return value as the value of membershipStartDate 
    }
    
    // Getter method for attendance 
    public int getAttendance()
    {
        return this.attendance; // Setting return value as the value of attendance 
    }
    
    //Getter method for loyaltyPoints 
    public double getLoyaltyPoints()
    {
        return this.loyaltyPoints; //Setting return value as the value of loyaltyPoints 
    }
    
    // Getter method for activeStatus 
    public boolean getActiveStatus()
    {
        return this.activeStatus; //Setting return value as the value of activestatus 
    }
    

    // Declaring markAttendance as abstract method 
    public abstract void markAttendance();

    // This is a method to activate membership 
    public void activateMembership()
    {
        this.activeStatus = true;
    }

    // This is a method to deactivate membership 
    public void deactivateMembership() 
    {
        if (this.activeStatus)// activestatus == true  
        {
            this.activeStatus = false;
        }
        else{
            System.out.println("Membership has already been deactivated.");
        }
    }

    // This is a method to reset member details 
    public void resetMember() 
    {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }
    // This is a method to display members information 
    public String display() {
    String result = "";
    result += "ID: " + id + "\n";
    result += "Name: " + name + "\n";
    result += "Location: " + location + "\n";
    result += "Phone: " + phone + "\n";
    result += "Email: " + email + "\n";
    result += "Gender: " + gender + "\n";
    result += "DOB: " + DOB + "\n";
    result += "Membership Start Date: " + membershipStartDate + "\n";
    result += "Attendance: " + attendance + "\n";
    result += "Loyalty Points: " + loyaltyPoints + "\n";
    result += "Active Status: " + activeStatus + "\n";
    return result;
}
}    
