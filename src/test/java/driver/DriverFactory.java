package driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static String dockerHubUrl = System.getenv("hubUrl");   //http://192.168.16.56:4444/wd/hub

    static String proxyAddress=System.getenv("proxyAddress");
    static String proxyUser=System.getenv("proxyUser");
    static String proxyPass=System.getenv("proxyPass");

    public static RemoteWebDriver getDriver() throws MalformedURLException {
        System.out.println("proxy user: "+proxyUser);
        DesiredCapabilities capabilities;
        System.out.println("grid url: "+dockerHubUrl);
        String browser = System.getenv("BROWSER");
        System.out.println("browser: "+browser);
        if (browser == null) {
            capabilities=DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            ChromeDriverManager.getInstance().arch64().proxy(proxyAddress).proxyUser(proxyUser).proxyPass(proxyPass).setup();
            return new RemoteWebDriver(new URL(dockerHubUrl),capabilities);
        }
        switch (browser)
        {
            case "IE":
                capabilities=DesiredCapabilities.internetExplorer();
                capabilities.setBrowserName("IE");
                InternetExplorerDriverManager.getInstance().arch64().proxy(proxyAddress).proxyUser(proxyUser).proxyPass(proxyPass).setup();
                return new RemoteWebDriver(new URL(dockerHubUrl),capabilities);
            case "FIREFOX":
                capabilities=DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                FirefoxDriverManager.getInstance().arch64().proxy(proxyAddress).proxyUser(proxyUser).proxyPass(proxyPass).setup();
                return new RemoteWebDriver(new URL(dockerHubUrl),capabilities);
            case "CHROME":
                capabilities=DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                ChromeDriverManager.getInstance().arch64().proxy(proxyAddress).proxyUser(proxyUser).proxyPass(proxyPass).setup();
                return new RemoteWebDriver(new URL(dockerHubUrl),capabilities);
            default:
                capabilities=DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                ChromeDriverManager.getInstance().arch64().proxy(proxyAddress).proxyUser(proxyUser).proxyPass(proxyPass).setup();
                return new RemoteWebDriver(new URL(dockerHubUrl),capabilities);
        }
    }
}
