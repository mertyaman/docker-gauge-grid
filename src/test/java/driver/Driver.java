package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;

public class Driver implements ICustomScreenshotGrabber{
    public static WebDriver webDriver;
    public static Wait<WebDriver> wait;

    @BeforeSuite
    public void initializeDriver() throws MalformedURLException {
        webDriver = DriverFactory.getDriver();
        wait = new WebDriverWait(webDriver, 6000);
    }

    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }

    @Override
    public byte[] takeScreenshot() {
        byte[] screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
