import io.appium.java_client.remote.MobileCapabilityType;
import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class ExampleTest {
    public WebDriver driver;
    DesiredCapabilities capabilities;

    private By loginBtn = By.cssSelector(ta("loginBtn", "a.login-btn"));
    private By signupBtn = By.cssSelector(ta("signupBt", "div.sign-up-container > a"));
    private By emailFl = By.name(ta("emailF", "email"));

    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCuiTest");
        capabilities.setCapability(MobileCapabilityType.UDID, "DA31C63A-E2D2-4E97-A058-D763F81F2903");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");

        driver = new TrueAutomationDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void exampleTest() {
        driver.get("https://trueautomation.io");
        driver.findElement(loginBtn).click();
        driver.findElement(signupBtn).click();
        driver.findElement(emailFl).sendKeys("your@mail.com");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
