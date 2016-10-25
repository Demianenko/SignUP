import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quiz  {
    public static void main(String[] args) {
        ATT acc = new ATT(true, 2, 1, true);
        acc.wd = new ChromeDriver();
        acc.wd.get("https://docs.google.com/forms/d/1mdJ0QwHVylE1aCJHSHV1WoczX2Dc1hHRPizd1CngpjM/viewform");
        acc.wd.findElement(By.className("quantumWizTogglePaperradioRadioContainer")).click();
        acc.wd.findElement(By.className("quantumWizButtonPaperbuttonLabel")).click();

    }


    public static class Cat {
        public String name;

        Cat(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
    }
}