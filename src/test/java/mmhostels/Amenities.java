package mmhostels;

import Page_Object_Model.HomePage;
import Page_Object_Model.Schedule_a_visit;
import Page_Object_Model.manmandir_boys_pg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import action.action_class;

public class Amenities extends action_class{

    WebDriver driver= null;
    HomePage obj_HomePage;
    manmandir_boys_pg obj_mbpg;

    Schedule_a_visit obj_sav;

    @BeforeClass
    @Parameters("url")
    public void launch_browser(String url) throws Exception
    {
        //Objects of Page Object model Class

        obj_HomePage = new HomePage();
        obj_mbpg = new manmandir_boys_pg();
        obj_sav = new Schedule_a_visit();

        driver = getDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);
    }

    @AfterClass
    public void close_browser()
    {
        driver.quit();
    }

    @Test(priority = 0)
    @Parameters("param_amenities")
    public void validate_amenities(String param_amenities) throws Exception
    {
        WebElement ele = null;
        WebElement ele_b = null;

        System.out.println("Amenities");
        Actions action = new Actions(driver);

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
            Thread.sleep(1000);
            System.out.println("The Boys pg sub menu item url is clicked: ");
        }

        // Scroll to Schedule a Visit
        System.out.println("Page will scroll to Amenities..");
        WebElement element = driver.findElement(obj_HomePage.text_Amenities());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);


        String amenity_name=null;

        int count = size_count_elements(obj_HomePage.all_Amenities());

        for(int i=1; i<=count; i++)
        {
            amenity_name=driver.findElement(By.xpath("(//h3[@class='elementor-image-box-title'])["+ i +"]")).getText();
            Assert.assertTrue(param_amenities.contains(amenity_name.trim()));
            System.out.println("Found Amenity: " + i + " " + amenity_name);
        }

        // Click on Logo should return to Home page
        System.out.println("Task 9: Click on Logo should return to Home page");
        Assert.assertTrue(checkfor_element_present(obj_mbpg.mmnmandir_logo()));
        clickButtonsandExplicitWait(obj_mbpg.mmnmandir_logo(), 5000);
        System.out.println("Clicked on Logo MANMANDIR and back to main page");


        clickButtonsandExplicitWait(obj_mbpg.sav_button_right_top_corner_home_pg(), 3000);
        String popup_header_text= driver.findElement(obj_mbpg.sav_popup_header_text()).getText();
        System.out.println("Popup header text is: " + popup_header_text);
        driver.findElement(By.xpath("//a[@class='paoc-close-popup paoc-popup-close']")).click();

        String url_ig=driver.findElement(By.xpath("(//a[contains(@href, 'instagram.com')])[1]")).getAttribute("href");
        System.out.println("The url is: " + url_ig);

        WebElement elb = driver.findElement(By.xpath("(//a[contains(@href, 'instagram.com')])[1]"));
        elb.click();
        Thread.sleep(5000);

    }
}
