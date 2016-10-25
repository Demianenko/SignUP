import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.util.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginByAw {
    public static void login() throws Exception {
        FirefoxDriver wd;
        wd = new FirefoxDriver();
        //ChromeDriver wd;
        //wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://ai-odsup.lab.nordigy.ru:8088/usermgr/default.asp?state=init");
        wd.findElement(By.name("fExtension")).click();
        wd.findElement(By.name("fExtension")).clear();
        wd.findElement(By.name("fExtension")).sendKeys(" (650) 446-0038");
        wd.findElement(By.xpath("//form/table[2]/tbody/tr[3]/td[2]/table/tbody/tr/td/font/table[2]/tbody/tr[6]/td")).click();
        wd.findElement(By.xpath("//form/table[2]/tbody/tr[3]/td[2]/table/tbody/tr/td/font/table[2]/tbody/tr[6]/td/font/a[1]")).click();
        wd.findElement(By.linkText("Something New")).click();
        wd.findElement(By.xpath("//table[@id='normal_data_table']/tbody/tr[5]/td[1]")).click();
        wd.findElement(By.linkText("Confirm")).click();
        wd.findElement(By.linkText("Login to Account")).click();
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
        wd.switchTo().alert();
        return true;
        } catch (NoAlertPresentException e) {
        return false;
        }
    }
}
