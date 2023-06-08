package SeleniumHW_08;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Calender extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passWord.sendKeys("Hum@nhrm123");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        WebElement recruitment = driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']"));
        recruitment.click();

        WebElement search = driver.findElement(By.xpath("//input[@id='candidateSearch_fromDate']"));
        search.click();

        WebElement month = driver.findElement(By.xpath("//select[@class ='ui-datepicker-month']"));
        Select sel1 = new Select(month);
        sel1.selectByVisibleText("Dec");

        WebElement year= driver.findElement(By.xpath("//select[@class ='ui-datepicker-year']"));
        Select sel2 = new Select(year);
        sel2.selectByVisibleText("2024");


        boolean isfound=false;
        while (!isfound){
            List<WebElement> allDays = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement day : allDays) {
            String currentDay = day.getText();
            if (currentDay.equals("5")) {
               day.click();
            }
        }
        isfound=true;
        }

    }
}
