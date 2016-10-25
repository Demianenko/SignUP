public class CanadaOffice extends Office {
    public CanadaOffice(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }
    public CanadaOffice(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }
    public void initial(){
        pref = 250;
        url = caOffice;
        companyName = "caOffice";
        address1 = "Elm 999 Baker Way";
        address2 = "Ste 500";
        city = "San Mateo";
        state = "Quebec" ;
        zip = "G1K 8W1" ;
        locationName = state;
        difName = "offCA";
        this.paymentInfoButton               = "//*[@name=\"yt0\"]";
        this.contactFormContinueButton       = "//*[@name=\"yt0\"]";

    }
    @Override
    public void selectPhoneLocation(String selector, String choose) {}
}
