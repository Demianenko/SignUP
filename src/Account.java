import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class Account {

    public String phoneNumber, mail, employees, difName, locationName;
    public int numberOfPlan,numberOfEmployees,pref;
    public boolean paid, billingCycle;
    public String url,firstName, secondName, companyName, address1, address2, city, state, zip, card, month, year, code, pin, captcha, phone, phoneCode;
    String signUpButton,buttonPaidEntry,buttonTrialEntry, buttonPaidStandard, buttonTrialStandard, buttonPaidPremium, buttonTrialPremium,  buttonPaidEnterprise,  buttonTrialEnterprise,
            ContactForm_firstName,  ContactForm_lastName,  ContactForm_email, ContactForm_contactPhone,  ContactForm_company,
            ContactForm_numberOfEmployees, BillingInfoForm_stateId, contactFormContinueButton, reviewSystemButton,BillingInfoForm_addressLine1,
            BillingInfoForm_addressLine2,  BillingInfoForm_city,  BillingInfoForm_zipCode, BillingInfoForm_type,
            BillingInfoForm_expirationMonth,  BillingInfoForm_expirationYear,  BillingInfoForm_number,  BillingInfoForm_cvv,
            pathToAnnual,  pathToMonth, BillingInfoForm_captchaCode,  chkBoxUs,  chkBoxUk, chkBoxConInf, Phone_phoneNumber,  verButton,
            Phone_verificationCode,  submitButton, phoneNumberPath,ContactForm_mainOfficeLocation;
    //uk
    String countyInp, countryListBilling,countryListBillingValue,vatLocation,vatValue, continueButton, buyNowButton, mobileProBlockPath, mobilePowerBlockPath,ringCentralPhoneNumber;
    String greatBritain, usOffice, usMobile, usFax, caOffice, caMobile, caFax, att, bt;
    String firstName2, lastName2, companyName2, address12, address22, city2, countyListShipping, zipCode2;
    String paymentInfoButton;

    boolean firefox = Main.firefox;
    public String mailBox;
    public WebDriver wd;
    public Select mainOfficeLocationList;

    public int implicitlyWait = 120;
    public String pathToChromeDriver = "C:\\chromedriver_win32";
    public String localURL ="http://10.0.2.15:4444/wd/hub";  //"http://192.168.112.78:4444/wd/hub"

    //public String mailTail = "@stressmail.dins.ru"; //"@od.anything3d.com"; // "@ab-soft.net";
    public String mailTail = "@ab-soft.net";
    public Account(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle, String mailBox){
        this(paid,numberOfEmployees,numberOfPlan,billingCycle);
        this.mailBox = mailBox + "+";

    }
    public abstract void initialPath();
    public abstract void initial();
    public abstract String signUp() throws InterruptedException;
    public Account(boolean paid, int numberOfEmployees, int numberOfPlan, boolean billingCycle) {
        environment(Main.prod);
        this.numberOfEmployees = numberOfEmployees;
        this.paid = paid;
        this.numberOfPlan = numberOfPlan;
        this.billingCycle = billingCycle;
        this.mailBox = "sergei.demyanenko+";

        firstName = "Something";
        secondName = "New";
        card = "Visa";
        month = "May";
        year = "2020";
        code = "4111111111111111";
        pin = "123";
        captcha = "GaiQWSuv13e4";
        phone = "+78129363711";
        phoneCode = "1111";
        initialPath();
        initial();

    }
    public void environment (int prod) {
    switch (prod) {
        case 0:
            greatBritain = "http://www.ringcentral.co.uk/office/plansandpricing.html";
            usOffice     = "http://www.ringcentral.com/office/plansandpricing.html";
            usMobile     = "http://www.ringcentral.com/pro/features/how-it-works.html";
            usFax        = "http://www.ringcentral.com/fax/features/how-it-works.html";
            caOffice     = "http://www.ringcentral.ca/office/plansandpricing.html";
            caMobile     = "http://www.ringcentral.ca/pro/features/how-it-works.html";
            caFax        = "http://www.ringcentral.ca/fax/features/how-it-works.html";

        break;
        case 1:
            greatBritain = "http://service-"+Main.environment+"-uk.lab.nordigy.ru/office/plansandpricing.html";
            usOffice     = "http://service-"+Main.environment+"-us.lab.nordigy.ru/office/plansandpricing.html";
            usMobile     = "http://service-"+Main.environment+"-us.lab.nordigy.ru/pro/features/how-it-works.html";
            usFax        = "http://service-"+Main.environment+"-us.lab.nordigy.ru/fax/features/how-it-works.html";
            caOffice     = "http://service-"+Main.environment+"-ca.lab.nordigy.ru/office/plansandpricing.html";
            caMobile     = "http://service-"+Main.environment+"-ca.lab.nordigy.ru/pro/features/how-it-works.html";
            caFax        = "http://service-"+Main.environment+"-ca.lab.nordigy.ru/fax/features/how-it-works.html";
            att          = "http://service-"+Main.environment+"-att.lab.nordigy.ru/web/signup"; //"http://service-"+Main.environment+"-att.lab.nordigy.ru/web/signup/index.html?mode=0";
            bt           = "http://test.bt.od.ab-soft.net/test.html"; //  http://service-"+Main.environment+"-bt.lab.nordigy.ru/sa/signup/test.html

        /*
        case 2:
            greatBritain = "http://www.ops.ringcentral.com/office/plansandpricing.html";
            usOffice     = "http://www.ops.ringcentral.com/office/plansandpricing.html";
            usMobile     = "http://www.ops.ringcentral.com/pro/features/how-it-works.html";
            usFax        = "http://www.ops.ringcentral.com/fax/features/how-it-works.html";
            caOffice     = "http://service-odsup-ca.lab.nordigy.ru/office/plansandpricing.html";
            caMobile     = "http://service-odsup-ca.lab.nordigy.ru/pro/features/how-it-works.html";
            caFax        = "http://service-odsup-ca.lab.nordigy.ru/fax/features/how-it-works.html";
            att          = "http://service-odsup-att.lab.nordigy.ru/web/signup/index.html?mode=0";
        break;
        /*
        case 2:
            greatBritain = "http://service-rlzstb-uk.lab.nordigy.ru/office/plansandpricing.html";
            usOffice     = "http://service-rlzstb-us.lab.nordigy.ru/office/plansandpricing.html";
            usMobile     = "http://service-rlzstb-us.lab.nordigy.ru/pro/features/how-it-works.html";
            usFax        = "http://service-rlzstb-us.lab.nordigy.ru/fax/features/how-it-works.html";
            caOffice     = "http://service-rlzstb-ca.lab.nordigy.ru/office/plansandpricing.html";
            caMobile     = "http://service-rlzstb-ca.lab.nordigy.ru/how-it-works.html";
            caFax        = "http://service-rlzstb-ca.lab.nordigy.ru/fax/features/how-it-works.html";
        break;
        case 3:
            greatBritain = "http://service-qaup-uk.lab.nordigy.ru/office/plansandpricing.html";
            usOffice     = "http://service-qaup-us.lab.nordigy.ru/office/plansandpricing.html";
            usMobile     = "http://service-qaup-us.lab.nordigy.ru/pro/features/how-it-works.html";
            usFax        = "http://service-qaup-us.lab.nordigy.ru/fax/features/how-it-works.html";
            caOffice     = "http://service-qaup-ca.lab.nordigy.ru/office/plansandpricing.html";
            caMobile     = "http://service-qaup-ca.lab.nordigy.ru/how-it-works.html";
            caFax        = "http://service-qaup-ca.lab.nordigy.ru/fax/features/how-it-works.html";
            att          = "http://service-qaup-att.lab.nordigy.ru/web/signup/index.html?mode=0";
            break;
        case 4:
            greatBritain = "http://www.ops.ringcentral.co.uk/office/plansandpricing.html";
            usOffice     = "http://www.ops.ringcentral.com/office/plansandpricing.html";
            usMobile     = "http://www.ops.ringcentral.com/pro/features/how-it-works.html";
            usFax        = "http://www.ops.ringcentral.com/fax/features/how-it-works.html";
            caOffice     = "http://www.ops.ringcentral.ca/office/plansandpricing.html";
            caMobile     = "http://www.ops.ringcentral.ca/pro/features/how-it-works.html";
            caFax        = "http://www.ops.ringcentral.ca/fax/features/how-it-works.html";
            att          = "http://www.ops.att.ringcentral.com/web/signup/index.html?mode=0";
        break;
        */
    }




    }

    public void create() throws MalformedURLException, InterruptedException {
        selectBillingCycle();
        selectPlanAndNumber();
        employees = ""+numberOfEmployees;
        phoneNumber = genPhone(pref);
        difName = phoneNumber+difName;
        mail = genMail(difName);
        System.out.println(phoneNumber + " " + mail);

      try {
            if(Main.remote) {
                if(firefox) {
                    wd = new RemoteWebDriver(new URL(localURL), DesiredCapabilities.firefox()); //"http://192.168.112.78:4444/wd/hub"
                } else {
                    System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
                    wd = new RemoteWebDriver(new URL(localURL), DesiredCapabilities.chrome());
                }
            } else {
                if (firefox) {
                    System.setProperty("webdriver.gecko.driver", "D:\\tools\\geckodriver.exe");
                    wd = new MarionetteDriver();
                } else {
                    //ChromeOptions options = new ChromeOptions();
                    //options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data");
                   // options.addArguments("--start-maximized");
                   // wd = new ChromeDriver(options);
                    wd = new ChromeDriver();
                }
            }
            openBrowser();
            wd.manage().window().maximize();
            signUp();
            Thread.sleep(1000);
            wd.manage().deleteAllCookies();
            wd.quit();
      }
        catch (WebDriverException e) {
            System.err.println(e);
            //wd.quit();
            throw e;
        }

    }
    public void openBrowser() throws InterruptedException {
        wd.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        wd.get(url);
        wd.manage().deleteAllCookies();
        Cookie ck1 = new Cookie("disable_Captcha", "success");
        wd.manage().addCookie(ck1);
        Set<Cookie> cookiesList =  wd.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
    }
    public void selectPricingPlan(String buttonPaidStandard, String buttonTrialStandard, String buttonPaidPremium,
                                  String buttonTrialPremium, String buttonPaidEnterprise, String buttonTrialEnterprise) {
        String plan;
        if (numberOfPlan < 2) {
            if (paid) {
                plan = buttonPaidStandard;
            } else {
                plan = buttonTrialStandard;
            }
        } else {
            if (numberOfPlan == 2) {
                if (paid) {
                    plan = buttonPaidPremium;
                } else {
                    plan = buttonTrialPremium;
                }
            } else {
                if (paid) {
                    plan = buttonPaidEnterprise;
                } else {
                    plan = buttonTrialEnterprise;
                }
            }
        }
        clickButtonBy(plan);
    }
    public void contactInformation( String ContactForm_firstName, String ContactForm_lastName, String ContactForm_email,
                                   String ContactForm_contactPhone, String ContactForm_company) {
        fillFormByXpath(ContactForm_firstName, firstName);
        fillFormByXpath(ContactForm_lastName, secondName);
        fillFormByXpath(ContactForm_email, mail);
        fillFormByXpath(ContactForm_contactPhone, phoneNumber);
        fillFormByXpath(ContactForm_company, companyName);
    }
    public void paymentInfo(String BillingInfoForm_addressLine1, String BillingInfoForm_addressLine2, String BillingInfoForm_city, String BillingInfoForm_stateId, String BillingInfoForm_zipCode,
                            String BillingInfoForm_type, String BillingInfoForm_expirationMonth, String BillingInfoForm_expirationYear, String BillingInfoForm_number, String BillingInfoForm_cvv,
                            String pathToAnnual, String pathToMonth,
                            String BillingInfoForm_captchaCode, String chkBoxUs, String chkBoxUk) throws InterruptedException {
        waiting(By.xpath(BillingInfoForm_addressLine1));
        fillFormByXpath(BillingInfoForm_addressLine1, address1);
        fillFormByXpath(BillingInfoForm_addressLine2, address2);
        fillFormByXpath(BillingInfoForm_city, city);
        fillFormByXpath(BillingInfoForm_zipCode, zip);
        // Spend time for update
       // wd.findElement(By.xpath(BillingInfoForm_number)).click();
        fillFormByXpath(BillingInfoForm_number, code);
        selectBillingLocation(BillingInfoForm_stateId,state);
        selectBillingCountry(countryListBilling,countryListBillingValue);
        addVAT(vatLocation,vatValue);
        try {
            selectBy(BillingInfoForm_type,card);
        }
        catch (WebDriverException e) {
            System.out.println("New card selector");
        }

        selectBy(BillingInfoForm_expirationMonth,month);
        selectBy(BillingInfoForm_expirationYear,year);
        waitForAjax(25000);
        selectPeriod(pathToMonth, pathToAnnual);
        waiting(By.xpath(BillingInfoForm_addressLine1));

        sendCaptcha(BillingInfoForm_captchaCode);
        waitForAjax(25000);
        fillFormByXpath(BillingInfoForm_cvv, pin);

        clickCheckBoxes(chkBoxUs,chkBoxUk);

        wd.findElement(By.xpath(BillingInfoForm_addressLine1)).click();
    }
    public void reviewSubmit(){}
    public void verification(String Phone_phoneNumber, String verButton,
                             String Phone_verificationCode, String submitButton){
        waiting(By.xpath(Phone_phoneNumber));
        fillFormByXpath(Phone_phoneNumber, phone);
        clickButtonBy(verButton);
        waiting(By.xpath(Phone_verificationCode));
        fillFormByXpath(Phone_verificationCode, phoneCode);
        clickButtonBy(submitButton);
    }
    public void selectPhoneLocation(String ContactForm_mainOfficeLocation,String state){
    }
    public void selectBillingLocation(String BillingInfoForm_stateId,String state){
        selectBy(BillingInfoForm_stateId,state);
    }
    public void selectBillingCountry(String countryListBilling,String value) {
        //selectValueBy(locatorToSelectBilling,countryListBilling,value);
    }
        public void addVAT(String vatLocation, String vatValue) throws InterruptedException {
        //
    }
        public void addressValidation(String... addressValidation){
            if(!wd.findElements(By.xpath(addressValidation[0])).isEmpty()) {
                clickButtonByXpath(addressValidation[1]);
                clickButtonByXpath(addressValidation[2]);
            }
        }
    public void selectPeriod(String pathToMonth, String pathToAnnual) throws InterruptedException {
        waitForAjax(2000);
        if(billingCycle) {
            waiting(By.xpath(pathToMonth));
            Actions actions = new Actions(wd);
            actions.moveToElement(wd.findElement(By.xpath(pathToMonth))).build().perform();
            actions.moveToElement(wd.findElement(By.xpath(pathToMonth))).click(wd.findElement(By.xpath(pathToMonth)));
            wd.findElement(By.xpath(pathToMonth)).click();
        }   else {
            waiting(By.xpath(pathToAnnual));
            Actions actions = new Actions(wd);
            actions.moveToElement(wd.findElement(By.xpath(pathToAnnual))).build().perform();
            actions.moveToElement(wd.findElement(By.xpath(pathToAnnual))).click(wd.findElement(By.xpath(pathToAnnual)));
            wd.findElement(By.xpath(pathToAnnual)).click();
        }
    }
    public void sendCaptcha(String BillingInfoForm_captchaCode) {
        fillFormByXpath(BillingInfoForm_captchaCode, captcha);
    }
    public void clickCheckBoxes(String chkBoxUs, String chkBoxUk) {
        wd.findElement(By.xpath(chkBoxUs)).click();
    }
    public String ringCentralNumberReturn(String phoneNumberPath){
        waitingVisible(By.xpath(phoneNumberPath));
        String phoneNumberByGW = wd.findElement(By.xpath(phoneNumberPath)).getText();
        System.out.println(difName+"   "+phoneNumberByGW);
        Main.phoneNumbers.add(phoneNumberByGW);
        return phoneNumberByGW;
    }
    public void selectBillingCycle(){
        if (billingCycle) {
            difName += "Mon";
        }
        else{
            difName+="Ann";
        }
        if(paid) {
            difName=difName+"Pd";
        } else {
            difName=difName+"Trl";
        }
    }
    public void selectPlanAndNumber(){
        switch(numberOfPlan) {
            case 1:
                difName=difName+"St";
                break;
            case 2:
                difName=difName+"Pr";
                break;
            case 3:
                difName=difName+"En";
                break;
            default:
                difName=difName+"xaxa";
                break;
        }
    }
    public String genPhone(int pref) {
        int phoneNumber = 100000 + (int)(Math.random() * (800000));
        switch(pref) {
            case 1650:
                return "16502" + phoneNumber;
            case 44113:
                return "441132" + phoneNumber;
            case 250:
                return "2502"+ phoneNumber;
            default:
                return "9012"+ phoneNumber;
        }
    }
    public String genMail(String tierName) {
        return mailBox+tierName+mailTail;
    }
    public void waiting(By we) {
        WebDriverWait wait = new WebDriverWait(wd,implicitlyWait);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(we));
    }
    public void waitingVisible(By we) {
        WebDriverWait wait = new WebDriverWait(wd, implicitlyWait);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(we));

    }
    public void waitForAjax(int timeoutInSeconds) {
        try {
            if (wd instanceof JavascriptExecutor) {
                JavascriptExecutor jsDriver = (JavascriptExecutor)wd;
                for (int i = 0; i< timeoutInSeconds; i++) {
                    Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
                    if (numberOfAjaxConnections instanceof Long) {
                        Long n = (Long)numberOfAjaxConnections;
                        //System.out.println("Number of active jquery ajax calls: " + n);
                        if (n.longValue() == 0L)
                            break;
                    }
                }
            }
            else {
                //System.out.println("Web driver: " + wd + " cannot execute javascript");
            }
        }
        catch ( WebDriverException e) {
            System.out.println(e);
        }
    }

    public void clickButtonBy(String selector) {
                WebElement element = null;
                waitForAjax(25000);
                waiting(By.xpath(selector));
                element = wd.findElement((By.xpath(selector)));
                new Actions(wd).moveToElement(element).perform();
                try {
                   Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    element.click();
            }
    public void clickButtonByXpath(String selector) {
        WebElement element = null;
        waiting(By.xpath(selector));
        element = wd.findElement((By.xpath(selector)));
        waitForAjax(250000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }
    public void fillFormByXpath( String selector, String info) {
        if ((Main.prod == 0)|(Main.prod == 4)) {
            waiting(By.xpath(selector) );
            wd.findElement(By.xpath(selector)).click();
            waitForAjax(10000);
            wd.findElement(By.xpath(selector)).clear();
            wd.findElement(By.xpath(selector)).sendKeys(info);
        } else {
            waitForAjax(5000);
            waitingVisible(By.xpath(selector) );
            wd.findElement(By.xpath(selector)).click();
            wd.findElement(By.xpath(selector)).clear();
            wd.findElement(By.xpath(selector)).sendKeys(info);
        }

    }
    public void selectBy (String selector,String choose) {
        waitForAjax(5000);
        try {
            if (!wd.findElements(By.xpath(selector)).isEmpty()) {
                mainOfficeLocationList = new Select(wd.findElement(By.xpath(selector)));
                mainOfficeLocationList.selectByVisibleText(choose);
            }


        }
        catch (WebDriverException e) {

        }

    }
    public void selectValueBy (String selector,String choose) {
        waitForAjax(5000);
        mainOfficeLocationList = new Select(wd.findElement(By.xpath(selector)));
        mainOfficeLocationList.selectByValue(choose);
    }

    public void changeCreditCard(String creditType, String creditCode, String creditPin) {
        if ((this.card.equals("VISA")& creditType.equals("Visa"))) {
            this.card = creditType.toUpperCase();
        } else {
            this.card = creditType;
        }
        this.code = creditCode;
        this.pin = creditPin;
    }
    public void changeName(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }
    public void changeCreditCardCountry(String countryListBillingValue, String vatValue){
        this.countryListBillingValue = countryListBillingValue;
        this.vatValue = vatValue;

    }



    public void getScreenShot (String path) {
        waitForAjax(3000);
        try {
            File source = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




