public class USFax extends Fax{

    public USFax(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
            super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
        }
    public USFax(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
            super(paid, numberOfEmployees, numberOfPlan, billingCycle);
        }

    public void initial(){
            url = usFax;
            pref = 1650;
            companyName = "usTest";
            address1 = "Elm 999 Baker Way";
            address2 = "Ste 500";
            city = "San Mateo";
            state = "California";
            zip = "94404";
            difName = "faxUS";
            locationName = state;

        }
}

