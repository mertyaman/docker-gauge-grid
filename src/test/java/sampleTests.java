import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import static driver.Driver.wait;
import static driver.Driver.webDriver;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class sampleTests {
    @Step("Open bilyoner.com homepage")
    public void firstTest() {
        webDriver.get("https://www.bilyoner.com");
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Please be patience .... Searching ...");
                return webDriver.findElement(By.tagName("title")) != null;
            }
        });
        System.out.println(webDriver.findElement(By.tagName("body")).getText());
        assertEquals("URL must be https://www.bilyoner.com/", "https://www.bilyoner.com/", webDriver.getCurrentUrl());
    }

    @Step("Login with <15787600> and <987123>")
    public void login(String userid, String pass) throws InterruptedException {
        webDriver.findElement(By.cssSelector(".qa-input-userid")).sendKeys(userid);
        webDriver.findElement(By.cssSelector(".qa-input-password")).sendKeys(pass);
        webDriver.findElement(By.cssSelector(".btn.qa-button-login")).click();
        Thread.sleep(3000);
        assertTrue("Username goruntulenemedi.", webDriver.findElement(By.cssSelector(".user-panel__name.qa-username")).isDisplayed());
    }

    @ContinueOnFailure
    @Step("Open betting page")
    public void bettingpage() throws InterruptedException {
        webDriver.findElement(By.cssSelector(".qa-header-button-shortcut-bahis-yap")).click();
        Thread.sleep(3000);
        List<WebElement> teamNamesList=webDriver.findElements(By.cssSelector(".team-description"));
        assertTrue("Takim isimleri goruntulenemedi.",teamNamesList.size()>0);
    }

    @ContinueOnFailure
    @Step("Close browser window")
    public void closeBrowser() {
        webDriver.quit();
    }

}

