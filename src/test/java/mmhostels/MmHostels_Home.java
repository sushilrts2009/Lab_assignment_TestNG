package mmhostels;

import action.action_class;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Page_Object_Model.*;

public class MmHostels_Home extends action_class
{

    WebDriver driver= null;
    HomePage obj_HomePage;
    manmandir_boys_pg obj_mbpg;

    Schedule_a_visit obj_sav;

    @BeforeClass
    @Parameters("url")
    public void launch_browser(String url) throws Exception
    {
        // Extent Reports



        //Objects of Page Object model Class

        obj_HomePage = new HomePage();
        obj_mbpg = new manmandir_boys_pg();
        obj_sav = new Schedule_a_visit();

        driver = getDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(10000);
    }

    @AfterClass
    public void close_browser()
    {
        driver.quit();
    }

    //number 0 has the highest priority

    @Test(priority = 0)
    public void mmhostels_page_validation() throws Exception
    {

        // Task1 : Validate Logo
        System.out.println("Validating HomePage Logo of top left corner");
        System.out.println("Task1 : Validate Logo");

     //   checkfor_element_present(obj_HomePage.mmnmandir_logo());
        validateElementPresentwithScreenshot(obj_HomePage.mmnmandir_logo(), "logo");

      //  Assert.assertTrue(checkfor_element_present(obj_HomePage.mmnmandir_logo()));
        System.out.println("Logo MANMANDIR Logo Present");

    }

    @Test(priority = 2)
    @Parameters({"boys_pg_url_string", "sav_fname", "sav_lname", "sav_email", "sav_mobile", "sav_yourmessage"})
    public void menu_mousehover(String boys_pg_url_string, String sav_fname, String sav_lname, String sav_email, String sav_mobile, String sav_yourmessage) throws Exception
    {
        String href_Boys = null;

        System.out.println("Task3 : Mouse hover on PG Location, then click on Manmandir Boyes Hostel-Navrangpura");
        WebElement ele = null;
        WebElement ele_b = null;

        Actions action = new Actions(driver);

        //Home

      //  Assert.assertTrue(checkfor_element_present(obj_HomePage.menu_button_Home()));
        System.out.println("Home menu item is present ...");
        ele = get_web_element(obj_HomePage.menu_button_Home());
        action.moveToElement(ele).perform();
        Thread.sleep(2000);

        //About Us
        ele = get_web_element(obj_HomePage.menu_button_AboutUs());
        Assert.assertTrue(ele.isDisplayed());
        System.out.println("About Us menu item is present ...");
        action.moveToElement(ele).perform();
        Thread.sleep(2000);

        //Amenities
        ele = get_web_element(obj_HomePage.menu_button_Amenities());
        Assert.assertTrue(ele.isDisplayed());
        System.out.println("Amenities menu item is present ...");
        action.moveToElement(ele).perform();
        Thread.sleep(2000);

        //PG Locations
        ele = get_web_element(obj_HomePage.menu_button_PG_Location());
        Assert.assertTrue(ele.isDisplayed());
        System.out.println("PG Location menu item is present ...");
        action.moveToElement(ele).perform();
        Thread.sleep(2000);

        // menu items of PG locations
        ele_b = get_web_element(obj_HomePage.Menu_item_Boys());
        boolean present=ele_b.isDisplayed();
        System.out.println("booelan value: " + present);

        if(ele_b.isDisplayed())
        {
            action.moveToElement(ele_b).perform();
            ele_b.click();
            Thread.sleep(3000);
            System.out.println("The Boys pg sub menu item url is clicked: ");
            href_Boys = driver.findElement(obj_HomePage.Menu_item_Boys()).getAttribute("href");
            System.out.println("The href url is : " + href_Boys);
            Assert.assertTrue(href_Boys.contains(boys_pg_url_string));
            System.out.println("Task4: Validate URL contains string: " + boys_pg_url_string);
        }


        //Validate PG Location is highlghted or not
        System.out.println("Task5: Validate PG Locatios option is now highlighted");
        String color = driver.findElement(obj_HomePage.Menu_item_Boys()).getCssValue("color");
        String backcolor = driver.findElement(obj_HomePage.Menu_item_Boys()).getCssValue("background-color");
        System.out.println("The color of menu item" + color);
        System.out.println("The background color of selected menu item is: " + backcolor);

        if(!color.equals(backcolor)){
            System.out.println("menu_button_PG_Location is highlighted!");
        }
        else{
            System.out.println("The menu_button_PG_Location is not highlighted!");
        }

        // Scroll to Schedule a Visit
        System.out.println("Page will scroll to Schedule a Visit..");
        WebElement element = driver.findElement(obj_mbpg.Schedule_a_Visit_Text());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);


        //Enter data to Schedule a visit

        typeInTExtBox(obj_sav.first_name(), sav_fname);
        typeInTExtBox(obj_sav.last_name(), sav_lname);
        typeInTExtBox(obj_sav.email(), sav_email);
        typeInTExtBox(obj_sav.mobile(), sav_mobile);

        Select dd_gender = new Select(driver.findElement(By.xpath("//select[@id='ff_4_dropdown']")));
        dd_gender.selectByVisibleText("Male");


        Select dd_ima = new Select(get_web_element(obj_sav.drop_down_Iam_a()));
        dd_ima.selectByVisibleText("Working Professional");


        Select dd_dofstay = new Select(get_web_element(obj_sav.drop_down_duration_of_stay()));
        dd_dofstay.selectByIndex(1);

        //Using Javascript executor - Start
        //First create document object
        // Insepect -> console -> document.getElementById('ff_4_datetime')

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('ff_4_datetime').value='25/03/2024 11:55 AM'");

        // End

        typeInTExtBox(obj_sav.input_text_Your_Message(), sav_yourmessage);
        Thread.sleep(3000);

            }


    @Test(priority = 1)
    @Parameters({"mobile", "email"})
    public void mobile_email_validation(String mobile, String email) throws Exception
    {

      // Task2 : Read the mobile, email from application then compare with xml / properties file

        System.out.println("Task2 : Read the mobile, email from application then compare with xml / properties file");

        String mob1 = driver.findElement(obj_HomePage.homepage_mobile_number()).getText();
        String email1 = driver.findElement(obj_HomePage.homepage_email()).getText();

        System.out.println("Mobile Number from xml file: " + mobile);
        System.out.println("Email from xml file: " + email);


        System.out.println(email1);

        if(mobile.trim().equals(mob1.trim()))
        {
            System.out.println("Mobile compared: " + mob1);
        }
        else
        {
            System.out.println("Mobile not found");
        }

        if(email.trim().equals(email1.trim()))
        {
            System.out.println("email compared: " + email1);
        }
        else
        {
            System.out.println("email not found");
        }

    }



}
