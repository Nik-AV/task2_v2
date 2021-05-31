package pages;

import framework.BasePage;
import framework.ConfProperties;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private static final String pageName = pages.MainPage.class.getName();
    private static final By MainPageUniqueElement = By.xpath("//header[@class='b-main-page-blocks-header-2 cfix']");
    private static final String navigationItem = "//span[@class='b-main-navigation__text'][contains(text(), '%s')]";

    public MainPage() {
        super(MainPageUniqueElement,pageName );
    }

    public void navigateMenu(String navigationItemValue){

        baseElement.clickElement(By.xpath(String.format(navigationItem, navigationItemValue)));
    }
}
