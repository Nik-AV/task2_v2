package pages;

import framework.BasePage;
import org.openqa.selenium.By;

public class TVPage extends BasePage {

    private static final String pageName = TVPage.class.getName();
    private static final By TVPageUniqueElement = By.className("schema-header__title");
    private final String selectCheckbox = "//input[@value='parameter']";
    private final By selectPrice = By.xpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price'][@placeholder='до']");
    private final String selectMinInches = "//div[@class='schema-filter__group']/*[1]//option[@value='parameter']";
    private final String selectMaxInches = "//div[@class='schema-filter__group']/*[2]//option[@value='parameter']";
    private final String resolution = "//*[@class=\"schema-product__description\"]/span";
    private final String title = "//*[@class=\"schema-product__title\"]//span";
    private final By searchResult = By.xpath("//*[@class=\"schema-filter-button__sub schema-filter-button__sub_main\"][contains(text(), 'Найдено')]");
    private final String inches = "schema-product__description";

    public TVPage() {
        super (TVPageUniqueElement, pageName);
    }

    public void selectTVTitle(String Title){

        String locator = selectCheckbox.replaceAll("parameter", Title);
        baseElement.JSclick(locator);
    }

    public void selectPrice(String Price){

        baseElement.sendKeys(selectPrice, Price);
    }

    public void selectTVResolution(String Resolution){

        String locator = selectCheckbox.replaceAll("parameter", Resolution);
        baseElement.JSclick(locator);
    }

    public void selectTVMinInches(String MinInches){

        String locator = selectMinInches.replaceAll("parameter", MinInches);
        baseElement.clickElement(By.xpath(locator));
    }

    public void selectTVMaxInches(String MaxInches){

        String locator = selectMaxInches.replaceAll("parameter", MaxInches);
        baseElement.clickElement(By.xpath(locator));
    }
}
