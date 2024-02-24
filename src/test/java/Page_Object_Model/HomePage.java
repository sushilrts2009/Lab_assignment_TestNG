package Page_Object_Model;

import org.openqa.selenium.By;

public class HomePage {

    public By mmnmandir_logo()
    {
        return By.xpath("(//img[contains(@src, 'man_mandir_logo_w.png')])[1]");
    }


    public By homepage_mobile_number()
    {
        return By.xpath("(//span[@class='elementor-icon-list-text'])[1]");
    }

    public By homepage_email()
    {
        return By.xpath("(//span[@class='elementor-icon-list-text'])[2]");
    }

    public By menu_button_Home()
    {
        return By.xpath("(//div[@class='menu-new-menu-container'])[2]//a[text()='Home']");
    }

    public By menu_button_AboutUs()
    {
        return By.xpath("(//div[@class='menu-new-menu-container'])[2]//a[text()='About Us']");
    }

    public By menu_button_Amenities()
    {
        return By.xpath("(//div[@class='menu-new-menu-container'])[2]//a[text()='Amenities']");
    }

    public By menu_button_PG_Location()
    {
        return  By.xpath("(//div[@class='menu-new-menu-container'])[2]//a[text()='PG Locations']");
    }

    public  By menu_button_Contact_Us()
    {
        return  By.xpath("(//div[@class='menu-new-menu-container'])[2]//a[text()='Contact Us']");
    }

    public By Menu_item_Boys()
    {
        return By.xpath("(//a[text()='Manmandir Boys Pg – Navrangpura'])[2]");
    }

    public By text_Amenities()
    {
        return By.xpath("//h2[text()='Amenities']");
    }

    public By all_Amenities()
    {
        return By.xpath("//h3[@class='elementor-image-box-title']");
    }

}
