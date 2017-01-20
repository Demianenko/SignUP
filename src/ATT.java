/**
 * Created by user on 02.09.2014.
 */
public class ATT extends Account {
    String newEmp;
    public ATT(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }

    public ATT(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }
    @Override
    public void initialPath() {
           // this.signUpButton                    = "strong";
            this.buttonPaidStandard              = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[2]/a[2]"; //"/html/body/div[14]/div/div/div[3]/div[1]/div[3]/div[2]/div[1]/div/a[1]"; //*[@id="main-content"]/table/tbody/tr[3]/td[2]/a[2]
            this.buttonTrialStandard             = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[2]/a[3]"; // "/html/body/div[14]/div/div/div[3]/div[1]/div[3]/div[2]/div[1]/div/a[2]";

            this.buttonPaidPremium               = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[3]/a[2]"; // //*[@id="main-content"]/table/tbody/tr[3]/td[3]/a[2]
            this.buttonTrialPremium              = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[3]/a[2]";
            this.buttonPaidEnterprise            = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[4]/a[2]";
            this.buttonTrialEnterprise           = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[4]/a[2]";
            this.ContactForm_firstName           = "//*[@id=\"ContactForm_firstName\"]"; //"";
            this.ContactForm_lastName            = "//*[@id=\"ContactForm_lastName\"]"; //"";
            this.ContactForm_email               = "//*[@id=\"ContactForm_email\"]"; //"";
            this.ContactForm_contactPhone        = "//*[@id=\"ContactForm_contactPhone\"]"; //"";
            this.ContactForm_company             = "//*[@id=\"ContactForm_company\"]"; //"";

            this.ContactForm_numberOfEmployees   = "//*[@id=\"yw5\"]/div[2]/div[1]/select"; //"//*[@id=\"digitalUsersSelect\"]";
            this.BillingInfoForm_stateId         = "//*[@id=\"ShippingInfoForm_stateId\"]"; //"";
            this.contactFormContinueButton       = "//*[@name=\"yt0\"]"; //"";
        if(paid) {
            this.reviewSystemButton              =  "//*[@id=\"yw7\"]/button"; ///"//*[@name=\"yt40\"]";
        } else {
            this.reviewSystemButton              = "//*[@id=\"yw7\"]/button";   //*[@name=\"yt38\"]"; //"";
        }

            this.continueButton                  = "//*[@name=\"yt2\"]"; //"";
            this.buyNowButton                    = "//*[@name=\"yt4\"]"; //"";
            this.BillingInfoForm_addressLine1    = "//*[@id=\"ShippingInfoForm_addressLine1\"]"; //"";
            this.BillingInfoForm_addressLine2    = "//*[@id=\"ShippingInfoForm_addressLine2\"]"; //"";
            this.BillingInfoForm_city            = "//*[@id=\"ShippingInfoForm_city\"]"; //"";
            this.BillingInfoForm_zipCode         = "//*[@id=\"ShippingInfoForm_zipCode\"]"; //"";
            this.BillingInfoForm_type            = "//*[@id=\"BillingInfoForm_type\"]"; //"";
            this.BillingInfoForm_expirationMonth = "//*[@id=\"BillingInfoForm_expirationMonth\"]"; //"";
            this.BillingInfoForm_number          = "//*[@id=\"BillingInfoForm_number\"]"; //"";
            this.BillingInfoForm_expirationYear  = "//*[@id=\"BillingInfoForm_expirationYear\"]"; //"";
            this.BillingInfoForm_cvv             = "//*[@id=\"BillingInfoForm_cvv\"]"; //"";

            this.pathToAnnual                    = "//*[@id=\"yw2\"]/div[6]/div[1]";
            this.pathToMonth                     = "//*[@id=\"yw2\"]/div[6]/div[2]";
            this.BillingInfoForm_captchaCode     = "//*[@id=\"BillingInfoForm_captchaCode\"]"; //"";
            this.chkBoxUs                        = "//*[@id=\"yw4\"]/div[6]/div[2]";
            this.chkBoxUk                        = "//*[@id=\"ContactForm_isAgreement\"]"; //"";
            this.Phone_phoneNumber               = "//*[@id=\"PhoneVerificationForm_phoneNumber\"]"; //"";
            this.verButton                       = "//*[@id=\"yw3-submit-button\"]"; //"";
            this.Phone_verificationCode          = "//*[@id=\"PhoneVerificationForm_verificationCode\"]"; //"";
            this.submitButton                    = "//*[@name=\"yt13\"]"; //"";
            this.phoneNumberPath                 = "//*[@id=\"main-content\"]/div/p[1]/strong";


    }

    @Override
    public void initial() {
            url = att;
            pref = 1650;
            companyName = "ATTATTA";
            address1 = "1400 Fashion Island Blvd";
            address2 = "Ste 700";
            city = "San Mateo";
            state = "California";
            zip = "94404";
            phoneCode = "11111";
            locationName = state;
            difName = "att";

    }
    public String signUp() throws InterruptedException {
        selectPricingPlan(buttonPaidStandard, buttonTrialStandard, buttonPaidPremium, buttonTrialPremium, buttonPaidEnterprise, buttonTrialEnterprise);
        contactInformation(ContactForm_firstName, ContactForm_lastName, ContactForm_email, ContactForm_contactPhone, ContactForm_company);
        clickButtonBy(chkBoxUk);
        clickButtonBy(contactFormContinueButton);
        //Thread.sleep(6000);
       waitForAjax(3000);
        fillFormByXpath(Phone_verificationCode, phoneCode);
        Thread.sleep(3000);
       // getScreenShot("d:\\FridayTask\\" + phoneNumber + "\\" + "1" + ".png");
        clickButtonBy(continueButton);
        Thread.sleep(3000);
        //getScreenShot("d:\\FridayTask\\" + phoneNumber + "\\" + "2" + ".png");
        newEmp = "Up to "+employees+" users";
        clickButtonBy(ContactForm_numberOfEmployees);
        selectBy(ContactForm_numberOfEmployees, newEmp);

        Thread.sleep(1000);
       // getScreenShot("d:\\FridayTask\\" + phoneNumber + "\\" + "3" + ".png");
        clickButtonBy(reviewSystemButton);
        Thread.sleep(1000);
       // getScreenShot("d:\\FridayTask\\" + phoneNumber + "\\" + "4" + ".png");
        ContactForm_company = "//*[@id=\"ShippingInfoForm_company\"]";
        fillFormByXpath(ContactForm_company,companyName);
        fillFormByXpath(BillingInfoForm_addressLine1,address1);
        fillFormByXpath(BillingInfoForm_addressLine2,address2);
        fillFormByXpath(BillingInfoForm_city,city);
        fillFormByXpath(BillingInfoForm_zipCode,zip);
        selectBy(BillingInfoForm_stateId,state);

        clickButtonBy(buyNowButton);
        Thread.sleep(3000);
        getScreenShot("d:\\FridayTask\\" + phoneNumber + "\\" + "5" + ".png");
        clickButtonBy(submitButton);
        ringCentralPhoneNumber = ringCentralNumberReturn(phoneNumberPath) ;
        return ringCentralPhoneNumber;
    }
}
