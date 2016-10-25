import org.openqa.selenium.*;
public class GBOffice extends Office {
    String locationIdInList = "691"; ///603

    String vatVerificationButton;
    public GBOffice(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }
    public GBOffice(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }
    public void initial(){
        pref                      = 44113;
        url                       = greatBritain;
        companyName               = "uktest";
        address1                  = "49 Featherstone Street";
        address2                  = "Ste 500";
        city                      = "LONDON";
        countryListBillingValue   = "224";//74
        vatValue                  = "00000";
        ContactForm_mainOfficeLocation = "//*[@id=\"ContactForm_mainOfficeLocation\"]";  //"ContactForm_mainOfficeLocation";
        state                     = "London-020"; //"Haverhill-01440"; //"Clitheroe-01200" "London-020"; //
       //state                     = "Tyneside-0191"; //"Leeds-0113"; //"Birmingham-0121"; //;
        zip                       = "EC1Y 8SY";
        locationName              = state;
        difName                   = "offGB";
    }
    
    public void initialPath() {
        if(paid) {
            vatVerificationButton                = "//*[@id=\"yw4\"]/div[1]/div[1]/div[3]/div"; //*[@id="yw4"]/div[1]/div[1]/div[3]/div/span

            this.chkBoxUs                        = "//*[@id=\"yw4\"]/div[3]/div[2]/div[2]"; // "//*[@id=\"yw4\"]/div[7]/div[2]"; //*[@id="yw5"]/div[3]/div[2]/div[2]
            this.chkBoxUk                        = "//*[@id=\"yw4\"]/div[3]/div[3]/div[2]"; // "//*[@id=\"yw4\"]/div[8]/div[2]"; //*[@id="yw5"]/div[3]/div[2]/div[2]

            this.contactFormContinueButton       = "//*[@name=\"yt1\"]"; //"yt0";
            this.reviewSystemButton              = "//*[@name=\"yt5\"]"; //"yt4";
            this.continueButton                  = "//*[@name=\"yt0\"]"; //"yt2";
            this.buyNowButton                    = "//*[@name=\"yt4\"]"; //"yt4";
            this.paymentInfoButton               = "//*[@name=\"yt0\"]"; //"yt0";
        } else {

            vatVerificationButton                = "//*[@id=\"yw5\"]/div[1]/div[1]/div[3]/div";

            this.chkBoxUs                        = "//*[@id=\"yw5\"]/div[3]/div[2]/div[2]"; // "//*[@id=\"yw4\"]/div[7]/div[2]"; //*[@id="yw5"]/div[3]/div[2]/div[2]
            this.chkBoxUk                        = "//*[@id=\"yw5\"]/div[3]/div[3]/div[2]"; // "//*[@id=\"yw4\"]/div[8]/div[2]"; //*[@id="yw5"]/div[3]/div[2]/div[2]

            this.contactFormContinueButton       = "//*[@name=\"yt1\"]"; //"yt0";
            this.reviewSystemButton              = "//*[@name=\"yt5\"]"; //"yt4";
            this.continueButton                  = "//*[@name=\"yt0\"]"; //"yt2";
            this.buyNowButton                    = "//*[@name=\"yt4\"]"; //"yt4";
            this.paymentInfoButton               = "//*[@name=\"yt0\"]"; //"yt0";

        }

        this.signUpButton                    = "/html/body/div[2]/div[1]/div[2]/div[6]/div/div[1]/div/a";
        this.signUpButton                    = "/html/body/div/div[2]/div[2]/div[6]/div/div[5]/div[1]/a/sub";
        this.buttonPaidEntry                 = "//*[@id=\"plan0_paidbtn\"]";
        this.buttonTrialEntry                = "//*[@id=\"plan0_contactsales\"]";
        this.buttonPaidStandard              = "//*[@id=\"plan1_paidbtn\"]";
        this.buttonTrialStandard             = "//*[@id=\"plan1_contactsales\"]";
        this.buttonPaidPremium               = "//*[@id=\"plan2_paidbtn\"]";
        this.buttonTrialPremium              = "//*[@id=\"plan2_contactsales\"]";
        this.buttonPaidEnterprise            = "//*[@id=\"plan3_paidbtn\"]";
        this.buttonTrialEnterprise           = "//*[@id=\"plan3_contactsales\"]";

        this.ContactForm_firstName           = "//*[@id=\"ContactForm_firstName\"]";
        this.ContactForm_lastName            = "//*[@id=\"ContactForm_lastName\"]";
        this.ContactForm_email               = "//*[@id=\"ContactForm_email\"]";
        this.ContactForm_contactPhone        = "//*[@id=\"ContactForm_contactPhone\"]";
        this.ContactForm_company             = "//*[@id=\"ContactForm_company\"]";

        this.ContactForm_numberOfEmployees   = "//*[@id=\"ContactForm_numberOfEmployees\"]"; //"ContactForm_numberOfEmployees";
        this.BillingInfoForm_stateId         = "//*[@id=\"BillingInfoForm_stateId\"]"; //"BillingInfoForm_stateId";



        this.BillingInfoForm_addressLine1    = "//*[@id=\"BillingInfoForm_addressLine1\"]"; //"BillingInfoForm_addressLine1";
        this.BillingInfoForm_addressLine2    = "//*[@id=\"BillingInfoForm_addressLine2\"]"; //"BillingInfoForm_addressLine2";
        this.BillingInfoForm_city            = "//*[@id=\"BillingInfoForm_city\"]"; //"BillingInfoForm_city";
        this.BillingInfoForm_zipCode         = "//*[@id=\"BillingInfoForm_zipCode\"]"; //"BillingInfoForm_zipCode";
        this.BillingInfoForm_type            = "//*[@id=\"BillingInfoForm_type\"]"; //"BillingInfoForm_type";
        this.BillingInfoForm_expirationMonth = "//*[@id=\"BillingInfoForm_expirationMonth\"]"; //"BillingInfoForm_expirationMonth";
        this.BillingInfoForm_number          = "//*[@id=\"BillingInfoForm_number\"]"; //"BillingInfoForm_number";
        this.BillingInfoForm_expirationYear  = "//*[@id=\"BillingInfoForm_expirationYear\"]"; //"BillingInfoForm_expirationYear";
        this.BillingInfoForm_cvv             = "//*[@id=\"BillingInfoForm_cvv\"]"; //"BillingInfoForm_cvv";

        this.vatLocation                     = "//*[@id=\"BillingInfoForm_vatNumber\"]";//"BillingInfoForm_vatNumber";

        this.pathToAnnual                    = "//*[@id=\"yw2\"]/div[6]/div[1]"; //*[@id="yw2"]/div[6]/div[1]/div
        this.pathToMonth                     = "//*[@id=\"yw2\"]/div[6]/div[2]/div"; //*[@id="yw2"]/div[6]/div[2]/div
        this.BillingInfoForm_captchaCode     = "//*[@id=\"BillingInfoForm_captchaCode\"]";



        this.Phone_phoneNumber               = "//*[@id=\"PhoneVerificationForm_phoneNumber\"]"; //"PhoneVerificationForm_phoneNumber";
        this.verButton                       = "//*[@name=\"yt3\"]"; //"yw3-submit-button";
        this.Phone_verificationCode          = "//*[@id=\"PhoneVerificationForm_verificationCode\"]"; //"PhoneVerificationForm_verificationCode";
        this.submitButton                    = "//*[@name=\"yt3\"]"; //"yw3-submit-button";
        this.phoneNumberPath                 = "//*[@id=\"main-content\"]/div/h2/strong"; //*[@id="main-content"]/div/h2/strong

        this.firstName2                      = "//*[@id=\"ShippingInfoForm_firstName\"]";
        this.lastName2                       = "//*[@id=\"ShippingInfoForm_lastName\"]" ;
        this.companyName2                    = "//*[@id=\"ShippingInfoForm_company\"]" ;
        this.address12                       = "//*[@id=\"ShippingInfoForm_addressLine1\"]";
        this.address22                       = "//*[@id=\"ShippingInfoForm_addressLine2\"]" ;
        this.city2                           = "//*[@id=\"ShippingInfoForm_city\"]" ;
        this.countyListShipping              = "//*[@name=\"ShippingInfoForm[stateId]\"]"; //"//*[@id=\"ShippingInfoForm_stateId\"]"; //"ShippingInfoForm_stateId";
        this.zipCode2                        = "//*[@id=\"ShippingInfoForm_zipCode\"]" ;

        this.countryListBilling              = "//*[@id=\"BillingInfoForm_countryId\"]"; //"BillingInfoForm_countryId";

    }

    @Override
    public void selectPhoneLocation(String ContactForm_mainOfficeLocation,String state){
        selectBy(ContactForm_mainOfficeLocation,state);
    }
    @Override
    public void selectBillingLocation(String BillingInfoForm_stateId, String state) {
        selectValueBy(BillingInfoForm_stateId, locationIdInList);
    }
    @Override
    public void selectBillingCountry(String countryListBilling,String value) {
        if (!wd.findElements(By.xpath(countryListBilling)).isEmpty()) {
            if (wd.findElements(By.xpath(countryListBilling)).get(0).isDisplayed()) {
                selectValueBy(countryListBilling,value);

            }
        }
    }
    @Override
    public void addVAT(String vatLocation, String vatValue) throws InterruptedException {
        if (!wd.findElements(By.xpath(countryListBilling)).isEmpty()) {
            if (wd.findElements(By.xpath(vatLocation)).get(0).isDisplayed()) {
                Thread.sleep(1000);
                fillFormByXpath(vatLocation, vatValue);
                fillFormByXpath(firstName2, firstName);
                fillFormByXpath(lastName2, secondName);
                fillFormByXpath(address12, address1);
                fillFormByXpath(address22, address2);
                fillFormByXpath(companyName2, companyName);
                fillFormByXpath(city2,city);
                fillFormByXpath(zipCode2,zip);
                selectValueBy(countyListShipping,locationIdInList);
                clickButtonBy(vatVerificationButton);
            }
        }

    }
    @Override
    public void clickCheckBoxes(String chkBoxUs, String chkBoxUk) {
        wd.findElement(By.xpath(chkBoxUs)).click();
        wd.findElement(By.xpath(chkBoxUk)).click();
    }


}
