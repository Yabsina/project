
public class Mobile extends Gadget {
    // Additional attribute
    private int callingCredit;

    // Constructor
    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }

    // Accessor method for callingCredit
    public int getCallingCredit() {
        return callingCredit;
    }

    // Method to add calling credit
    public void addCallingCredit(int credit) {
        if (credit > 0) {
            callingCredit += credit;
        } else {
            System.out.println("Please enter a positive amount for calling credit.");
        }
    }

    // Method to make a phone call
    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            callingCredit -= duration;
        } else {
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    // Override display method to include callingCredit
    @Override
    public void display() {
        super.display();
        System.out.println("Calling Credit: " + callingCredit + " minutes");
    }
}
