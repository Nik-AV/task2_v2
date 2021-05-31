package pages;

import framework.BasePage;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage {

    private static final String pageName = CatalogPage.class.getName();
    private static final By CatalogPageUniqueElement = By.className("catalog-navigation__title");
    private final String catalogNavigationItem = "//span[@class='catalog-navigation-classifier__item-title-wrapper'][contains(text(), '%s')]";
    private final String catalogSectionNavigationItem = "//div[@class='catalog-navigation-list__aside-title'][contains(text(), '%s')]";
    private final String catalogSubSectionNavigationItem = "//span[@class='catalog-navigation-list__dropdown-title'][contains(text(), '%s')]";

    public CatalogPage() {
        super(CatalogPageUniqueElement,pageName );
    }

    public void navigateCatalogMenu(String catalogNavigationItemValue){

       baseElement.clickElement(By.xpath(String.format(catalogNavigationItem, catalogNavigationItemValue)));
    }

    public void navigateCatalogSection(String sectionNavigationItemValue){

        baseElement.clickElement(By.xpath(String.format(catalogSectionNavigationItem, sectionNavigationItemValue)));
    }

    public void navigateCatalogSubSection(String subSectionNavigationItemValue){

        baseElement.clickElement(By.xpath(String.format(catalogSubSectionNavigationItem, subSectionNavigationItemValue)));
    }
}
