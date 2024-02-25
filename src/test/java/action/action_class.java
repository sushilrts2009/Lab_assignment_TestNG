package action;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class action_class {

    public static final String screenshotpath= System.getProperty("user.dir") + "/screenshots/";

    public WebDriver driver = null;

    // This method is used to create driver instance

    public WebDriver getDriver()
    {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--headless");

        //execute in headless
        driver = new ChromeDriver(opt);
        driver = new ChromeDriver();
        return driver;

    }

    public WebElement get_web_element(By by)
    {
        WebElement ele = null;
        ele = driver.findElement(by);
        return ele;
    }

    // This method is used to type in a text box

    public boolean typeInTExtBox(By by, String stringinput)
    {
        boolean flag = false;

        try
        {
            driver.findElement(by).sendKeys(stringinput);
            flag = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return flag;
    }

    // Mouse hover
    public boolean mousehover(By by)
    {
        boolean flag = false;

        try
        {
            Actions action = new Actions(driver);
            WebElement ele = driver.findElement(by);
            action.moveToElement(ele);
            action.perform();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return flag;
    }

    // Check for element present
    public boolean checkfor_element_present(By by)
    {
        boolean flag = false;
        try
        {

            flag = driver.findElement(by).isDisplayed();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return flag;
    }

    public void capture_screenshot()
    {

    }

    public int size_count_elements(By by)
    {
        int count=0;

        try
        {

            count = driver.findElements(by).size();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return count;
    }

    public boolean clickButtonsandExplicitWait(By by, int time)
    {
        boolean flag = false;
        try{
            driver.findElement(by).click();
            Thread.sleep(time);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean validateElementPresentwithScreenshot(By by, String screenshotName){
        boolean flag = false;
        try{
            driver.findElement(by).isDisplayed();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            flag = true;
        }
        catch (Exception e){
            captureScreenshot(screenshotName);
            e.printStackTrace();
        }
        return flag;
    }
    public void captureScreenshot(String screenshotName) {
        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileHandler.copy(screenshot, new File(screenshotpath +"/"+ screenshotName+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
