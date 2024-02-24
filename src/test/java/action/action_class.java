package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class action_class {

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

}
