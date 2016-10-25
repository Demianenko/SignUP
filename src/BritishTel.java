import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BritishTel extends GBOffice {
    String defaultValue, editionType, bandwidthResult, accountActivationDate, referenceNoteCreditChange, shippingAddress;
    String initialPurchaseCreditLimit, recurringMonthlyCreditLimit;
    String oppID, cUG, salesAgentID, lB_ID, lB_Region, editionTypePath, bandwidthResultPath, accountActivationDatePath,
            initialPurchaseCreditLimitPath, recurringMonthlyCreditLimitPath, shippingAddressPath, rCDeal_ID,
            referenceNoteCreditChangePath, pathToSelectMain, pathToSelectFax, pathToLocalAreaCode,
            pathToLocalAreaCodePopup, pathToTargetServer , valueTargetServer, shippingAndOrderFormCounty, valueShippingAndOrderFormCounty;

    Map<Integer,String> selectTierBT = new HashMap<>();
    public BritishTel(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle, mailBox);
    }

    public BritishTel(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        super(paid, numberOfEmployees, numberOfPlan, billingCycle);
    }

    @Override
    public void initialPath() {
        this.ContactForm_firstName           = "//*[@name=\"CustomerFirstName\"]"; // "CustomerFirstName";
        this.ContactForm_lastName            = "//*[@name=\"CustomerLastName\"]"; //"CustomerLastName";
        this.ContactForm_email               = "//*[@name=\"CustomerEmail\"]"; //"CustomerEmail";
        this.ContactForm_contactPhone        = "//*[@name=\"CustomerContactNumber\"]"; //"CustomerContactNumber";
        this.ContactForm_company             = "//*[@name=\"CustomerCompanyName\"]"; //"CustomerCompanyName";
        this.oppID                           = "//*[@name=\"OppID\"]"; //"OppID";
        this.cUG                             = "//*[@name=\"CUG\"]"; //"CUG";
        this.salesAgentID                    = "//*[@name=\"SalesAgentID\"]"; //"SalesAgentID";
        this.lB_ID                           = "//*[@name=\"LB_ID\"]"; //"LB_ID";
        this.lB_Region                       = "//*[@name=\"LB_Region\"]"; //"LB_Region";

        this.ContactForm_numberOfEmployees        = "//*[@name=\"NumberUsers\"]"; //"NumberUsers";
        this.editionTypePath                      = "//*[@name=\"EditionType\"]"; //"EditionType";
        this.bandwidthResultPath                  = "//*[@name=\"BandwidthResult\"]"; //"BandwidthResult";
        this.accountActivationDatePath            = "//*[@name=\"AccountActivationDate\"]"; //"AccountActivationDate";
        this.initialPurchaseCreditLimitPath       = "//*[@name=\"InitialPurchaseCreditLimit\"]"; //"InitialPurchaseCreditLimit";
        this.recurringMonthlyCreditLimitPath      = "//*[@name=\"RecurringMonthlyCreditLimit\"]"; //"RecurringMonthlyCreditLimit";
        this.recurringMonthlyCreditLimitPath      = "//*[@name=\"RecurringMonthlyCreditLimit\"]"; //"RecurringMonthlyCreditLimit";
        this.shippingAddressPath                  = "//*[@name=\"ShippingAddress\"]"; //"ShippingAddress";
        this.rCDeal_ID                            = "//*[@name=\"RCDeal_ID\"]"; //"RCDeal_ID";
        this.referenceNoteCreditChangePath        = "//*[@name=\"ReferenceNoteCreditChange\"]"; //"ReferenceNoteCreditChange";
        this.pathToSelectMain                     = "//*[@id=\"yw4\"]/div[1]/div[2]";
        this.pathToSelectFax                      = "//*[@id=\"yw4\"]/div[2]/div[2]";
        this.pathToLocalAreaCode                  = "//*[@name=\"local-area-code\"]";
        //this.pathToLocalAreaCode                  = "//*[@id=\"yw3\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]/select";
        this.pathToLocalAreaCodePopup             = "//*[@id=\"yw3\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]"; //*[@id="yw3"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]/select
        this.continueButton                       = "//*[@name=\"yt0\"]"; //"yt0";
        this.reviewSystemButton                   = "//*[@name=\"yt2\"]"; //"yw5";
        this.contactFormContinueButton            = "//*[@name=\"yt0\"]"; //"yw1";
        this.verButton                            = "//*[@name=\"yt5\"]"; //"yw9";
        this.buyNowButton                         = "//*[@name=\"yt4\"]"; //"yw6";
        this.phoneNumberPath                      = "//*[@id=\"order-confirmation\"]/div/div[1]/div[2]/h2[1]/span";
        this.pathToTargetServer                   = "//*[@id=\"target-server\"]";

        this.valueTargetServer                    = "service-amsup-bt.lab.nordigy.ru";

        this.signUpButton                         = "//*[@name=\"Submit\"]"; //"arrBtn";
       // this.shippingAndOrderFormCounty           = "//*[@name=\"ShippingAndOrderForm[county]\"]"; //"ShippingAndOrderForm_county"; ShippingAndOrderForm[county] ShippingAndOrderForm_county
        this.shippingAndOrderFormCounty           = "//*[@id=\"ShippingAndOrderForm_county\"]";
        this.valueShippingAndOrderFormCounty      = "London";
    }

    @Override
    public void initial() {
        url = bt;
        difName = "bt";
        zip = "EC1Y 8SY";
        pref = 44113;
        defaultValue = "123";
        companyName = "btTest";
        state = "020 - London";
        //editionType = "CPBAP12";
        bandwidthResult = "{\"testID\": \"123\", \"mosScore\": \"1024\", \"simultaneousUsers\": \"5\"}";
        accountActivationDate = getSignupDate();
        //accountActivationDate = "{\"year\": \"2014\", \"month\": \"11\", \"day\": \"18\"}";
        referenceNoteCreditChange = "Note";
        initialPurchaseCreditLimit = "1200";
        recurringMonthlyCreditLimit = "750";
        shippingAddress = "{\"city\": \"Odessa\", \"county\": \"Ukraine\", \"addressLine1\": \"Zhukova 1/23\", \"addressLine2\": \"\", \"postCode\": \"a9a 9a9\"}";
    }

    private void fillMap(){
        selectTierBT.put(7721,"CPBAP12");
        selectTierBT.put(7723,"CPBAM12");
        selectTierBT.put(7741,"CPCNP12");
        selectTierBT.put(7743,"CPCNPM12");
        selectTierBT.put(7745,"CPCNM12");
        selectTierBT.put(7747,"CPCNMM12");
        selectTierBT.put(7749,"CPCNU12");
    }
    private void tierBT(){
        for (Map.Entry<Integer,String> entry : selectTierBT.entrySet()) {
            if(entry.getKey().equals(numberOfPlan)) {
                editionType = entry.getValue();
            }
        }

    }

    @Override
    public String signUp() throws InterruptedException {
        fillMap();
        tierBT();

        fillFormByXpath(ContactForm_firstName, firstName);
        fillFormByXpath(ContactForm_lastName, secondName);
        fillFormByXpath(ContactForm_email, mail);
        fillFormByXpath(ContactForm_contactPhone, phoneNumber);
        fillFormByXpath(ContactForm_company, companyName);
        fillFormByXpath(oppID, defaultValue);
        fillFormByXpath(cUG, defaultValue);
        fillFormByXpath(salesAgentID, defaultValue);
        fillFormByXpath(lB_ID, defaultValue);
        fillFormByXpath(lB_Region, defaultValue);
        fillFormByXpath(ContactForm_numberOfEmployees, numberOfEmployees + "");
        fillFormByXpath(editionTypePath, editionType);
        fillFormByXpath(bandwidthResultPath, bandwidthResult);
        fillFormByXpath(accountActivationDatePath, accountActivationDate);
        fillFormByXpath(initialPurchaseCreditLimitPath, initialPurchaseCreditLimit);
        fillFormByXpath(recurringMonthlyCreditLimitPath, recurringMonthlyCreditLimit);
        fillFormByXpath(referenceNoteCreditChangePath, referenceNoteCreditChange);
        fillFormByXpath(shippingAddressPath, shippingAddress);
        fillFormByXpath(rCDeal_ID,defaultValue);
        selectBy(pathToTargetServer,valueTargetServer);

        clickButtonBy(signUpButton);
        waitingVisible(By.xpath(pathToSelectMain));
        clickButtonBy(pathToSelectMain);
        waitForAjax(3000);
        clickButtonBy(pathToLocalAreaCodePopup);
        clickButtonByXpath("//*[@id=\"yw3\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]/select/option[2]");
       // selectBy(pathToLocalAreaCode,state);
        waitForAjax(3000);
        clickButtonBy(continueButton);
        waiting(By.xpath(pathToSelectFax));
        clickButtonBy(pathToSelectFax);
        clickButtonBy(pathToLocalAreaCodePopup);
        clickButtonByXpath("//*[@id=\"yw3\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]/select/option[2]");
        //selectBy(pathToLocalAreaCode,state);

        clickButtonBy(continueButton);
        clickButtonBy(reviewSystemButton);
        waiting(By.xpath(contactFormContinueButton));
        waitForAjax(1000);
        Thread.sleep(1000);
        clickButtonBy(contactFormContinueButton);
        waiting(By.xpath(verButton));
        Thread.sleep(1000);
        clickButtonBy(verButton);
        waiting(By.xpath(buyNowButton));
        Thread.sleep(1000);

        clickButtonByXpath(shippingAndOrderFormCounty);
        clickButtonByXpath("//*[@id=\"ShippingAndOrderForm_county\"]/option[99]");
        //selectBy(shippingAndOrderFormCounty,valueShippingAndOrderFormCounty);
        clickButtonBy(buyNowButton);



        return ringCentralNumberReturn(phoneNumberPath);
    }
    private String getSignupDate() {
        Date d;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE,-1);
        System.out.println("DAY_OF_MONTH: " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.DAY_OF_MONTH);
        StringBuilder signDate = new StringBuilder();
        String temp;
        if((""+c.get(c.MONTH)).length()==1) {
            temp = "0"+(1+c.get(c.MONTH));
        } else {
            temp = ""+(1+c.get(c.MONTH));
        }
        signDate.append("{\"year\": \"").append(c.get(c.YEAR)).append("\", \"month\": \"").append(temp).append("\", ").append("\"day\": \"").append(c.get(c.DAY_OF_MONTH)).append("\"}");
        return signDate.toString();
    }
}
