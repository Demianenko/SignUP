import org.openqa.selenium.Cookie;

public abstract class Office extends Account {
    String parAddressValid[] = {"//*[@id=\"yw6\"]","//*[@class=\"icon\"]","//*[@name=\"yt1\"]"};
    public Office(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }
    public Office(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }

    public void initialPath() {
        this.buttonPaidStandard              = "//*[@id=\"plan1_paidbtn\"]"; //"plan1_paidbtn";
        this.buttonTrialStandard             = "//*[@id=\"plan1_contactsales\"]"; //"plan1_contactsales";
        this.buttonPaidPremium               = "//*[@id=\"plan2_paidbtn\"]"; //"plan2_paidbtn";
        this.buttonTrialPremium              = "//*[@id=\"plan2_contactsales\"]"; //"plan2_contactsales";
        this.buttonPaidEnterprise            = "//*[@id=\"plan3_paidbtn\"]"; //"plan3_paidbtn";
        this.buttonTrialEnterprise           = "//*[@id=\"plan3_contactsales\"]"; //"plan3_contactsales";

        this.ContactForm_firstName           = "//*[@id=\"ContactForm_firstName\"]";
        this.ContactForm_lastName            = "//*[@id=\"ContactForm_lastName\"]";
        this.ContactForm_email               = "//*[@id=\"ContactForm_email\"]";
        this.ContactForm_contactPhone        = "//*[@id=\"ContactForm_contactPhone\"]";
        this.ContactForm_company             = "//*[@id=\"ContactForm_company\"]";

        this.ContactForm_numberOfEmployees   = "//*[@id=\"ContactForm_numberOfEmployees\"]"; //"ContactForm_numberOfEmployees";
        this.BillingInfoForm_stateId         = "//*[@id=\"BillingInfoForm_stateId\"]"; //"BillingInfoForm_stateId";

        this.contactFormContinueButton       = "//*[@name=\"yt1\"]"; //"yt0";
        this.reviewSystemButton              = "//*[@name=\"yt4\"]"; //"yt4";
        this.continueButton                  = "//*[@name=\"yt2\"]"; //"yt2";
        this.buyNowButton                    = "//*[@name=\"yt4\"]"; //"yt4";
        this.paymentInfoButton               = "//*[@name=\"yt0\"]"; //"yt2";

        this.BillingInfoForm_addressLine1    = "//*[@id=\"BillingInfoForm_addressLine1\"]"; //"BillingInfoForm_addressLine1";
        this.BillingInfoForm_addressLine2    = "//*[@id=\"BillingInfoForm_addressLine2\"]"; //"BillingInfoForm_addressLine2";
        this.BillingInfoForm_city            = "//*[@id=\"BillingInfoForm_city\"]"; //"BillingInfoForm_city";
        this.BillingInfoForm_zipCode         = "//*[@id=\"BillingInfoForm_zipCode\"]"; //"BillingInfoForm_zipCode";
        this.BillingInfoForm_type            = "//*[@id=\"BillingInfoForm_type\"]"; //"BillingInfoForm_type";
        this.BillingInfoForm_expirationMonth = "//*[@id=\"BillingInfoForm_expirationMonth\"]"; //"BillingInfoForm_expirationMonth";
        this.BillingInfoForm_number          = "//*[@id=\"BillingInfoForm_number\"]"; //"BillingInfoForm_number";
        this.BillingInfoForm_expirationYear  = "//*[@id=\"BillingInfoForm_expirationYear\"]"; //"BillingInfoForm_expirationYear";
        this.BillingInfoForm_cvv             = "//*[@id=\"BillingInfoForm_cvv\"]"; //"BillingInfoForm_cvv";

        this.pathToAnnual                    = "//*[@id=\"yw2\"]/div[6]/div[1]";
        this.pathToMonth                     = "//*[@id=\"yw2\"]/div[6]/div[2]";

        this.BillingInfoForm_captchaCode     = "//*[@id=\"BillingInfoForm_captchaCode\"]"; //"BillingInfoForm_captchaCode";
        this.chkBoxUs                        = "//*[@id=\"yw4\"]/div[4]/div[2]/div[2]";  //*[@id="yw4"]/div[7]/div[2]
        this.chkBoxUk                        = "//*[@id=\"yw4\"]/div[8]/div[2]";
        this.Phone_phoneNumber               = "//*[@id=\"PhoneVerificationForm_phoneNumber\"]"; //"PhoneVerificationForm_phoneNumber";
        this.verButton                       = "//*[@name=\"yt3\"]"; //"yw3-submit-button";
        this.Phone_verificationCode          = "//*[@id=\"PhoneVerificationForm_verificationCode\"]"; //"PhoneVerificationForm_verificationCode";
        this.submitButton                    = "//*[@name=\"yt3\"]"; //"yw3-submit-button";
        this.phoneNumberPath                 = "//*[@id=\"main-content\"]/div/h2/strong";  //*[@id="main-content"]/div[1]/h2/strong


    }
    public String signUp() throws InterruptedException {
        selectPricingPlan(buttonPaidStandard, buttonTrialStandard, buttonPaidPremium, buttonTrialPremium, buttonPaidEnterprise, buttonTrialEnterprise);
        fillFormByXpath(ContactForm_numberOfEmployees, employees);
        contactInformation(ContactForm_firstName, ContactForm_lastName, ContactForm_email, ContactForm_contactPhone, ContactForm_company);
        selectPhoneLocation(ContactForm_mainOfficeLocation, state);
        clickButtonByXpath(contactFormContinueButton);
        Thread.sleep(1000);
        Cookie ck = new Cookie("disable_Captcha", "success");
        wd.manage().addCookie(ck);
        clickButtonByXpath(reviewSystemButton);
        paymentInfo(BillingInfoForm_addressLine1, BillingInfoForm_addressLine2, BillingInfoForm_city, BillingInfoForm_stateId, BillingInfoForm_zipCode,
                BillingInfoForm_type, BillingInfoForm_expirationMonth, BillingInfoForm_expirationYear, BillingInfoForm_number, BillingInfoForm_cvv,
                pathToAnnual, pathToMonth,
                BillingInfoForm_captchaCode, chkBoxUs, chkBoxUk);
//        getScreenShot("d:\\FridayTask\\"+phoneNumber+"\\"+"2"+".png");
        clickButtonByXpath(paymentInfoButton);
  //      getScreenShot("d:\\FridayTask\\"+phoneNumber+"\\"+"3"+".png");
        if (companyName.equals("usTest")) {
            addressValidation(parAddressValid);
        }

        clickButtonByXpath(buyNowButton);
        waitForAjax(2500);

        verification(Phone_phoneNumber, verButton, Phone_verificationCode, submitButton);
     //   getScreenShot("d:\\FridayTask\\"+phoneNumber+"\\"+"4"+".png");
        ringCentralPhoneNumber = ringCentralNumberReturn(phoneNumberPath) ;

        return ringCentralPhoneNumber;
    }

}
