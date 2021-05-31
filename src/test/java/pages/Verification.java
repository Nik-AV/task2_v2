package pages;
import framework.BasePage;
import org.openqa.selenium.By;

public class Verification extends BasePage{

    private static final String pageName = TVPage.class.getName();
    private static final By PageUniqueElement = By.className("schema-header__title");
    private final String resolution = "//*[@class=\"schema-product__description\"]/span";
    private final String title = "//*[@class=\"schema-product__title\"]//span";
    private final By searchResult = By.xpath("//*[@class=\"schema-filter-button__sub schema-filter-button__sub_main\"][contains(text(), 'Найдено')]");
    private final String inches = "schema-product__description";

    public Verification() {
        super (PageUniqueElement, pageName);
    }

    public void isReady(){
        baseElement.waitElementBeVisible(searchResult);
    }

    public boolean verifyResolution(String Resolution) {

        if (baseElement.verifyElementContainsText(resolution, Resolution)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean verifyTitle(String Title) {

        Title = Title.substring(0,1).toUpperCase()+Title.substring(1);
        return baseElement.verifyElementContainsText(title, Title);
    }

    public boolean verifyInches(String MinInches, String MaxInches) {

        int minInch = Integer.parseInt(MinInches)/10;
        int maxInch = Integer.parseInt(MaxInches)/10;
        if (baseElement.verifyElementInRange(inches, minInch, maxInch)) {
            return true;
        }else {
            return false;
        }
    }

    /*
    public boolean verifyPrice(String preconditionPrice) {

        List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"schema-product__price\"]/*//*"));

        for (WebElement element : elements) {

            String str = element.getText();
            str = str.substring(0,str.length()-6) + "." + str.substring(str.length()-5,str.length()-3);
            double price = parseDouble(str);
            if (price > Double.parseDouble(preconditionPrice)) {

                System.out.println("Price check failed");
                return false;
            }

        }
        System.out.println("Price check passed");
        return true;
    }

    */
}
