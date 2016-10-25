import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class LoginToMail {
/*
    public static String login(String name, String pass, String number) {

        FirefoxDriver wd;
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.get("http://mail.ab-soft.net/");
        wd.findElement(By.name("user_name")).sendKeys(name);
        wd.findElement(By.name("password")).sendKeys(pass);
        wd.findElement(By.xpath("/html/body/div/div/div/form/table/tbody/tr[2]/td[2]/input[2]")).click();
        USOffice.waiting(wd, By.id("wm_core_content"));
        int numbOfMail = wd.findElements(By.className("checkbox")).size();
        System.out.println(numbOfMail);
        String link = null;
        for (int i = 1; i < numbOfMail; i++) {
            String anyText = wd.findElement(By.xpath("//*[@id=\"wm_core_content\"]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[3]/div/div[3]/div[1]/div")).getText();

            System.out.println(anyText);
            if (anyText.equals("Please Activate Your RingCentral Account "+number)) {
                wd.findElement(By.xpath("//*[@id=\"wm_core_content\"]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[3]/div/div[3]/div[1]/div")).click();
                USOffice.waiting(wd, By.tagName("Strong"));
                List<WebElement> links =  wd.findElementsByTagName("Strong");
                link = links.get(1).getText();
                System.out.println(link);
                //wd.findElement(By.tagName("Strong")).click();
                i = numbOfMail;
            }


        }

    return  link;
    }*/
}
