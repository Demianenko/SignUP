public class USMobile extends Mobile{

    public USMobile(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }
    public USMobile(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }

    public void initial(){
        url = usMobile;
        pref = 1650;
        companyName = "usTest";
        address1 = "Elm 999 Baker Way";
        address2 = "Ste 500";
        city = "San Mateo";
        state = "California";
        zip = "94404";
        difName = "mobUS";
        locationName = state;


    }

    public String signUp() throws InterruptedException {
        clickButtonByXpath(signUpButton);
        selectPricingPlan(buttonPaidStandard, buttonTrialStandard, buttonPaidPremium, buttonTrialPremium, buttonPaidEnterprise, buttonTrialEnterprise);
        clickButtonByXpath(mobileSelectNumberButton);
        clickButtonByXpath(upgradeButton);
        contactInformation(ContactForm_firstName, ContactForm_lastName, ContactForm_email, ContactForm_contactPhone, ContactForm_company);
        selectBy(ContactForm_numberOfEmployees, employeesToString);
        fillFormByXpath(BillingInfoForm_captchaCode, captcha);
        clickButtonByXpath(chkBoxConInf);
        clickButtonByXpath(contactFormContinueButton);
        paymentInfo(BillingInfoForm_addressLine1, BillingInfoForm_addressLine2, BillingInfoForm_city, BillingInfoForm_stateId, BillingInfoForm_zipCode,
                BillingInfoForm_type, BillingInfoForm_expirationMonth, BillingInfoForm_expirationYear, BillingInfoForm_number, BillingInfoForm_cvv,
                pathToAnnual, pathToMonth,
                BillingInfoForm_captchaCode, chkBoxUs, chkBoxUk);
        clickButtonByXpath(continueButton);
        verification(Phone_phoneNumber, verButton, Phone_verificationCode, submitButton);
        return ringCentralNumberReturn(phoneNumberPath) ;
    }
}
