package Page_Object_Model;

import org.openqa.selenium.By;

public class manmandir_boys_pg {

    public By Schedule_a_Visit_Text()
    {
        return By.xpath("//h2[text()='Schedule a Visit']");
    }
    public By mmnmandir_logo()
    {
        return By.xpath("(//img[contains(@src, 'mmt.png')])[2]");
    }

    public  By sav_popup_header_text()
    {
        return  By.xpath("//div[@class='paoc-popup-margin paoc-popup-mheading']");
    }

    public By sav_button_right_top_corner_home_pg()
    {
        return By.xpath("(//a[text()='Schedule a visit'])[1]");
    }
}
