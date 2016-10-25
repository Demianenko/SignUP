import org.openqa.selenium.By;

public abstract class Mobile extends Account {
    String mobileSelectNumberButton;
    String upgradeButton;
    String employeesToString = "2-4";
    public void initialPath() {

        this.signUpButton                    = "//*[@id=\"sticky_cta\"]/a[1]";
        this.buttonPaidStandard              = "//*[@id=\"pblock_1_paidbtn\"]";
        this.buttonTrialStandard             = "//*[@id=\"pblock_1_trialbtn\"]";
        this.buttonPaidPremium               = "//*[@id=\"pblock_2_paidbtn\"]";
        this.buttonTrialPremium              = "//*[@id=\"pblock_2_trialbtn\"]";
        this.buttonPaidEnterprise            = "//*[@id=\"pblock_3_paidbtn\"]";
        this.buttonTrialEnterprise           = "//*[@id=\"plan3_contactsales\"]"; //

        this.ContactForm_firstName           = "//*[@id=\"ContactForm_firstName\"]";
        this.ContactForm_lastName            = "//*[@id=\"ContactForm_lastName\"]";
        this.ContactForm_email               = "//*[@id=\"ContactForm_email\"]";
        this.ContactForm_contactPhone        = "//*[@id=\"ContactForm_contactPhone\"]";
        this.ContactForm_company             = "//*[@id=\"ContactForm_company\"]";

        this.ContactForm_numberOfEmployees   = "//*[@id=\"ContactForm_numberOfEmployees\"]"; //ContactForm_numberOfEmployees
        this.BillingInfoForm_stateId         = "//*[@id=\"BillingInfoForm_stateId\"]";

        this.contactFormContinueButton       = "//*[@name=\"yt5\"]"; //"continue_btn";
        this.reviewSystemButton              = "//*[@id=\"yt4\"]"; //"";
        this.continueButton                  = "//*[@name=\"yt0\"]";
        this.buyNowButton                    = "//*[@id=\"yt4\"]"; //"";

        this.BillingInfoForm_addressLine1    = "//*[@id=\"BillingInfoForm_addressLine1\"]"; //"BillingInfoForm_addressLine1";
        this.BillingInfoForm_addressLine2    = "//*[@id=\"BillingInfoForm_addressLine2\"]"; //"BillingInfoForm_addressLine2";
        this.BillingInfoForm_city            = "//*[@id=\"BillingInfoForm_city\"]"; //"BillingInfoForm_city";
        this.BillingInfoForm_zipCode         = "//*[@id=\"BillingInfoForm_zipCode\"]"; //"BillingInfoForm_zipCode";
        this.BillingInfoForm_type            = "//*[@id=\"BillingInfoForm_type\"]"; //"BillingInfoForm_type";
        this.BillingInfoForm_expirationMonth = "//*[@id=\"BillingInfoForm_expirationMonth\"]"; //"BillingInfoForm_expirationMonth";
        this.BillingInfoForm_number          = "//*[@id=\"BillingInfoForm_number\"]"; //"BillingInfoForm_number";
        this.BillingInfoForm_expirationYear  = "//*[@id=\"BillingInfoForm_expirationYear\"]"; //"BillingInfoForm_expirationYear";
        this.BillingInfoForm_cvv             = "//*[@id=\"BillingInfoForm_cvv\"]"; //"BillingInfoForm_cvv";

        this.pathToAnnual                    = "//*[@id=\"yw4\"]/div[2]/div[3]/div[1]/div[1]/div/div";
        this.pathToMonth                     = "//*[@id=\"yw4\"]/div[2]/div[2]/div[1]/div[1]/div/div";

        this.BillingInfoForm_captchaCode     = "//*[@id=\"ContactForm_captchaCode\"]";
        this.chkBoxConInf                    = "//*[@id=\"yw5\"]/div/div[2]";
        this.chkBoxUs                        = "//*[@id=\"billing-information-form\"]/div/div[4]/div/label";
        this.chkBoxUk                        = "//*[@id=\"yw5\"]/div/div[2]";

        this.Phone_phoneNumber               = "//*[@id=\"PhoneVerificationForm_phoneNumber\"]"; //"";
        this.verButton                       = "//*[@name=\"yt0\"]";
        this.Phone_verificationCode          = "//*[@id=\"PhoneVerificationForm_verificationCode\"]"; //"";
        this.submitButton                    = "//*[@name=\"yt0\"]";

        this.mobileProBlockPath              = "//*[@id=\"pblock_1\"]/div[1]/span"; //*[@id="pblock_1"]/div[2]/span
        this.mobilePowerBlockPath            = "//*[@id=\"pblock_3\"]/div[1]/span"; //*[@id="pblock_3"]/div[2]/span
        this.mobileSelectNumberButton        = "//*[@name=\"yt0\"]";

        this.upgradeButton                   = "//*[@id=\"main-content\"]/div/div[3]/a[1]/span";
        this.month                           = "05-May";
        this.phoneNumberPath                 = "//*[@id=\"main-content\"]/div/h2/span";


    }


    public Mobile(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }
    public Mobile(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }
    public void selectPhoneLocation(String selector, String choose) {
        //**************************/
    }
    public void selectPricingPlan(String buttonPaidStandard, String buttonTrialStandard,
                                  String buttonPaidPremium, String buttonTrialPremium, String buttonPaidEnterprise, String buttonTrialEnterprise){
        String plan="";
        switch (numberOfPlan) {
            case 1:
                if (paid) {
                    plan = buttonPaidStandard; // "pblock_1_paidbtn"
                } else {
                    plan = buttonTrialStandard;// "pblock_1_trialbtn";
                }
                waiting(By.xpath(mobileProBlockPath)); //
                wd.findElement(By.xpath(mobileProBlockPath)).click(); // "/html/body/div/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/span"
                break;
            case 2:
                if (paid) {
                    plan = buttonPaidPremium; //"pblock_2_paidbtn";
                } else {
                    plan = buttonTrialPremium; //"pblock_2_trialbtn";
                }
                break;
            case 3:
                if (paid) {
                    plan = buttonPaidEnterprise; //"pblock_3_paidbtn";
                } else {
                    plan = buttonTrialEnterprise;
                    System.out.println("Нет триального плана для ProPower");
                    wd.close();
                }
                waiting(By.xpath(mobilePowerBlockPath));  // //*[@id="pblock_3"]/div[1]/span
                wd.findElement(By.xpath(mobilePowerBlockPath)).click(); //   "//*[@id=\"pblock_3\"]/div[2]/span"

                break;
            default:
                System.out.println("Wrong numberOfPlan");
        }
        waitingVisible(By.xpath(plan));
        wd.findElement(By.xpath(plan)).click();
    }

    public void selectPeriod( String pathToMonth, String pathToAnnual) {
        if (billingCycle) {
            // waiting(wd,By.id(pathToMonth));
            wd.findElement(By.xpath(pathToMonth)).click(); //*[@id="yw4"]/div[2]/div[2]/div[1]/div[1]/div/div
        }   else {
            //  waiting(wd,By.id(pathToAnnual));
            wd.findElement(By.xpath(pathToAnnual)).click();
        }
    }
    public void sendCaptcha(String BillingInfoForm_captchaCode) {}

}
