public class CanadaMobile extends Mobile {

    public CanadaMobile(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }
    public CanadaMobile(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }

    public void initial(){
        pref = 250;
        url = caMobile;
        companyName = "caMobile";
        address1 = "Elm 999 Baker Way";
        address2 = "Ste 500";
        city = "San Mateo";
        state = "Prince Edward Island"; // ""Quebec";
        zip = "C1A 4P3";
        locationName = state;
        difName = "mobCA";

    }

    public void selectBillingLocation (String BillingInfoForm_stateId,String state) {
        selectBy(BillingInfoForm_stateId, state);
    }
    public String signUp() throws InterruptedException {
        clickButtonBy(signUpButton);
        selectPricingPlan(buttonPaidStandard, buttonTrialStandard, buttonPaidPremium, buttonTrialPremium, buttonPaidEnterprise, buttonTrialEnterprise);
        clickButtonBy(mobileSelectNumberButton);
        clickButtonBy(upgradeButton);
        contactInformation( ContactForm_firstName, ContactForm_lastName, ContactForm_email, ContactForm_contactPhone, ContactForm_company);
        selectBy(ContactForm_numberOfEmployees, employeesToString);
        fillFormByXpath(BillingInfoForm_captchaCode,captcha);
        clickButtonByXpath(chkBoxConInf);
        clickButtonBy(contactFormContinueButton);
        paymentInfo(BillingInfoForm_addressLine1, BillingInfoForm_addressLine2, BillingInfoForm_city, BillingInfoForm_stateId, BillingInfoForm_zipCode,
                BillingInfoForm_type, BillingInfoForm_expirationMonth, BillingInfoForm_expirationYear, BillingInfoForm_number, BillingInfoForm_cvv,
                pathToAnnual, pathToMonth,
                BillingInfoForm_captchaCode, chkBoxUs, chkBoxUk);
        clickButtonByXpath(continueButton);
        verification(Phone_phoneNumber, verButton, Phone_verificationCode, submitButton);
        return ringCentralNumberReturn(phoneNumberPath) ;
    }
}


 /*public void initialPath() {

        this.signUpButton                    = "//*[@id=\"sticky_cta\"]/a[1]";

        this.buttonPaidStandard              = "//*[@id=\"pblock_1_paidbtn\"]";
        this.buttonTrialStandard             = "//*[@id=\"pblock_1_trialbtn\"]";
        this.buttonPaidPremium               = "//*[@id=\"pblock_2_paidbtn\"]";
        this.buttonTrialPremium              = "//*[@id=\"pblock_2_trialbtn\"]";
        this.buttonPaidEnterprise            = "//*[@id=\"pblock_3_paidbtn\"]";
        this.buttonTrialEnterprise           = "//*[@id=\"plan3_contactsales\"]"; //

        this.ContactForm_firstName           = "//*[@id=\"firstname\"]";
        this.ContactForm_lastName            = "//*[@id=\"lastname\"]";
        this.ContactForm_email               = "//*[@id=\"email\"]";
        this.ContactForm_contactPhone        = "//*[@id=\"contactphone\"]";
        this.ContactForm_company             = "//*[@id=\"companyname\"]";

        this.ContactForm_numberOfEmployees   = "//*[@id=\"employees\"]"; //ContactForm_numberOfEmployees
        this.BillingInfoForm_stateId         = "//*[@name=\"state\"]";

        this.contactFormContinueButton       = "//*[@id=\"continue_btn\"]"; //"continue_btn";
        this.reviewSystemButton              = "//*[@id=\"yt4\"]"; //"";
        this.continueButton                  = "//*[@name=\"ContinueButton\"]";
        this.buyNowButton                    = "//*[@id=\"yt4\"]"; //"";

        this.BillingInfoForm_addressLine1    = "//*[@id=\"adress1\"]"; //"BillingInfoForm_addressLine1";
        this.BillingInfoForm_addressLine2    = "//*[@id=\"adress2\"]"; //"BillingInfoForm_addressLine2";
        this.BillingInfoForm_city            = "//*[@id=\"city\"]"; //"BillingInfoForm_city";
        this.BillingInfoForm_zipCode         = "//*[@id=\"zipcode\"]"; //"BillingInfoForm_zipCode";
        this.BillingInfoForm_type            = "//*[@id=\"cardType\"]"; //"BillingInfoForm_type";
        this.BillingInfoForm_expirationMonth = "//*[@id=\"ccExpireMonth\"]"; //"BillingInfoForm_expirationMonth";
        this.BillingInfoForm_number          = "//*[@id=\"cardNumber\"]"; //"BillingInfoForm_number";
        this.BillingInfoForm_expirationYear  = "//*[@id=\"ccExpireYear\"]"; //"BillingInfoForm_expirationYear";
        this.BillingInfoForm_cvv             = "//*[@id=\"ccCVV\"]"; //"BillingInfoForm_cvv";

        this.pathToAnnual                    = "//*[@id=\"durationAnnual\"]";
        this.pathToMonth                     = "//*[@id=\"durationMonth\"]";

        this.BillingInfoForm_captchaCode     = "//*[@id=\"ccode\"]";
        this.chkBoxConInf                    = "//*[@id=\"billConfirm\"]";
        this.chkBoxUs                        = "//*[@id=\"policyagree\"]";
        this.chkBoxUk                        = "//*[@id=\"yw5\"]/div/div[2]";

        this.Phone_phoneNumber               = "//*[@id=\"PhoneNumberInput\"]"; //"";
        this.verButton                       = "//*[@name=\"call_me\"]";
        this.Phone_verificationCode          = "//*[@id=\"VerificationCodeInput\"]"; //"";
        this.submitButton                    = "//*[@name=\"continue\"]";

        this.mobileProBlockPath              = "//*[@id=\"pblock_1\"]/div[1]/span"; //*[@id="pblock_1"]/div[2]/span
        this.mobilePowerBlockPath            = "//*[@id=\"pblock_3\"]/div[1]/span"; //*[@id="pblock_3"]/div[2]/span
        this.mobileSelectNumberButton        = "//*[@name=\"yt0\"]"; //"yt0";

        this.upgradeButton                   = "//*[@id=\"main-content\"]/div/div[3]/a[1]/span";
        this.month                           = "05-May";


    }
    */