package tests;

import framework.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import pages.*;



public class OnlinerTest extends BaseTest {

    @Test
    @Parameters({"navigationItemValue", "catalogNavigationItemValue", "sectionNavigationItemValue",
            "subSectionNavigationItemValue", "Price", "Resolution", "Title", "MinInches", "MaxInches"})
    public void CatalogTest(String navigationItemValue, String catalogNavigationItemValue,
                                         String sectionNavigationItemValue, String subSectionNavigationItemValue,
                                         String Price, String Resolution, String Title, String MinInches, String MaxInches) throws InterruptedException {

        MainPage mainPage = new MainPage();
        mainPage.navigateMenu(navigationItemValue);

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateCatalogMenu(catalogNavigationItemValue);
        catalogPage.navigateCatalogSection(sectionNavigationItemValue);
        catalogPage.navigateCatalogSubSection(subSectionNavigationItemValue);

        TVPage tvPage = new TVPage();
        Verification verify = new Verification();

        tvPage.selectTVMinInches(MinInches);
        verify.isReady();

        tvPage.selectTVMaxInches(MaxInches);
        verify.isReady();
        tvPage.selectPrice(Price);
        verify.isReady();

        tvPage.selectTVTitle(Title);
        verify.isReady();

        tvPage.selectTVResolution(Resolution);
        verify.isReady();
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();

        System.out.println(verify.verifyTitle(Title));
        System.out.println(verify.verifyResolution(Resolution));
        System.out.println(verify.verifyInches(MinInches, MaxInches));
        softAssert.assertTrue(verify.verifyResolution(Resolution));
        softAssert.assertTrue(verify.verifyTitle(Title));
        softAssert.assertTrue(verify.verifyInches(MinInches, MaxInches));
        softAssert.assertAll();
    }
}




