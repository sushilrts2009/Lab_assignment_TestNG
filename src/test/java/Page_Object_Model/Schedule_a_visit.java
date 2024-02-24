package Page_Object_Model;

import org.openqa.selenium.By;

public class Schedule_a_visit {

    public By first_name()
    {
        return By.xpath("//input[@name='names[first_name]']");
    }

    public By last_name()
    {
        return By.xpath("//input[@name='names[last_name]']");
    }

    public By email()
    {
        return By.xpath("//input[@name='email']");
    }

    public By mobile()
    {
        return By.xpath("//input[@name='numeric-field']");
    }

    public By drop_down_gender()
    {
        return By.xpath("//select[@id='ff_4_dropdown']");
    }

    public By drop_down_Iam_a()
    {
        return By.xpath("//select[@id='ff_4_dropdown_2']");
    }

    public By drop_down_duration_of_stay()
    {
        return By.xpath("//select[@id='ff_4_dropdown_1']");
    }

    public By date_picker()
    {
        return By.xpath("//input[@id='ff_4_datetime']");
    }

    public By input_text_Your_Message()
    {
        return By.xpath("//textarea[@id='ff_4_message']");
    }

    public By submit_button()
    {
        return By.xpath("//button[text()='Schedule a Visit']");
    }

}
