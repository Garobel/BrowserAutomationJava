// Browser Automation

// dependencies fro this project are :
    // -selenium 
    // -JSON In Java » 20220320
    // -Chrome DRIVER version Versión 103.0.5060.114   

import java.sql.Driver;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.indexeddb.model.Key;
import org.openqa.selenium.devtools.v101.webauthn.model.Ctap2Version;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App {
    public static void main(String[] args) throws Exception {

        // set property is used to get access for using jar files in it's memory location
        System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver");
        
        // creating object chromedriver for our current version 
        WebDriver driver = new ChromeDriver();

        // we open the browser at the following url
        driver.get("https://jsonplaceholder.typicode.com/users/1");

        // we get our Json data in plain-text from html element <pre></pre>
        String text = driver.findElement(By.cssSelector("pre")).getText();

        // converting the json string value to JSON object using our JSON library
        
        JSONObject jsonObject = new JSONObject(text);

        //  getting the necessary content from our Json object

        String name = jsonObject.getString("name");
        String organisation = jsonObject.getJSONObject("company").getString("name");
        String phone = jsonObject.getString("phone");
        //  the phone content needs to be formatted . we split the string into an array by space.
        String[] splited = phone.split(" ");
        String email = jsonObject.getString("email");
        String message = "Test message from the java and selenium";

        // navigate to another web page and click on contact button

        driver.navigate().to("https://www.veroxos.com");
        driver.findElement(By.xpath("//*[@id=\"menu-1-a5ee844\"]/li[4]/a")).click();
        Thread.sleep(2000);
        // filling up the form 

        driver.findElement(By.name("form_fields[name]")).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(By.name("form_fields[email]")).sendKeys(email);
        Thread.sleep(1000);

        //  first position from splited array contains the numbers
        driver.findElement(By.name("form_fields[field_6178a92]")).sendKeys(splited[0]);
        Thread.sleep(1000);

        driver.findElement(By.name("form_fields[field_80929ef]")).sendKeys(organisation);
        Thread.sleep(1000);
        driver.findElement(By.name("form_fields[message]")).sendKeys(message);
        Thread.sleep(1000);

       
        
        //  submit the form
    
        driver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/section[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[7]/button")).submit();
    
        Thread.sleep(1000); 
        // driver.quit();
    }
}
