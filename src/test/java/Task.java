import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task {
        public static void main(String[] args) {
            // navigation start using chrome driver
            WebDriver driver = new ChromeDriver();
            String url = "https://rahulshettyacademy.com/loginpagePractise/";
            driver.navigate().to(url);
            // store the original window handel in a var
            String originalWindow = driver.getWindowHandle();
            // find the required link and click it
            driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
            // wait 2 sec to the new tab load
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            // loop until we find a new window handel
            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // get the mail form the new tab
            String mailto = driver.findElement(By.xpath("//a[contains(text(),'mentor@')]")).getText();
            // return to the original tab
            driver.switchTo().window(originalWindow);
            String password ="123Ab#";
            // Fill the form using the required mail
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys(mailto);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
            driver.findElement(By.xpath("//input[@id='terms']")).click();
            driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

            driver.quit();


        }
    }


