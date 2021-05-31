package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;
import static framework.Browser.getLoadWait;
import static java.lang.Double.parseDouble;

public class BaseElement {
    protected static Browser browser = Browser.getInstance();
    protected WebElement webElement;
    protected Actions actions = new Actions(browser.getDriver());
    private WebDriver driver = Browser.getDriver();

    public BaseElement(By by) {
        this.webElement = getElement(by);
    }


    public static WebElement getElement(By locator) {
        return new WebDriverWait(Browser.getDriver(), getLoadWait())
                .until(driver -> driver.findElement(locator));
    }


    public static List<WebElement> getElements(By locator) {
        return new WebDriverWait(Browser.getDriver(), getLoadWait())
                .until(driver -> driver.findElements(locator));
    }

    public void clickElement(By locator) {
        waitElementBeClickable(locator);
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getElement(locator));
        }
        getElement(locator).click();
    }

    public void JSclick(String locator) {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.xpath(locator));
        js.executeScript("arguments[0].click();", element);
    }

    public void clickAndWait(By locator) {
        clickElement(locator);
        waitForPageToLoad();
    }

    public void waitElementBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), getLoadWait());
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), getLoadWait());
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By locator) {
        waitElementBeClickable(locator);
        return getElement(locator).getText();
    }

    public void sendKeys(By locator, String key)
    {
        waitElementBeClickable(locator);
    getElement(locator).sendKeys(key);
    }


    public boolean isElementPresentedOnPage(By locator){
        boolean elementPresence = true;
        try {
            getElement(locator);
        } catch (Exception e){
            elementPresence = false;
        }
    return elementPresence;
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), getLoadWait());
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver d) {
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");

                if (result != null && result instanceof Boolean && (Boolean) result) {
                    return true;
                }
                return false;
            }
        });
    }

    public boolean verifyElementContainsText(String locator, String text) {

        List<WebElement> elements = driver.findElements(By.xpath(locator));

        for (WebElement element : elements) {
            if (element.getText().contains(text) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyElementInRange(String locator, int min, int max) {

        List<WebElement> elements = driver.findElements(By.className(locator));

        for (WebElement element : elements) {
            String str = element.getText().split("\"")[0];
            double inches = parseDouble(str);
            if (inches < min || inches > max) {
                return false;
            }
        }
        return true;
    }
}
