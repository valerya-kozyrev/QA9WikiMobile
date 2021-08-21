package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePageHelper;
import pages.HomePageHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class HomePageTests extends TestBase {
    //    HomePageHelper homePage;
    ArticlePageHelper articlePage;

    @BeforeMethod
    public void initTest() {
//        homePage = PageFactory.initElements(driver, HomePageHelper.class);
//        homePage.waitUntilPageIsLoaded();
        articlePage = PageFactory.initElements(driver, ArticlePageHelper.class);
    }

    @Test
    public void wikiTest() {
        System.out.printf("Search text: " + homePage.getSearchFieldText());
        Assert.assertEquals("Search Wikipedia", homePage.getSearchFieldText());
    }

    @Test
    public void searchByTextAndOpenFirstArticleRotationTest() {
        homePage.searchBy("Java");
        System.out.println("First article title: " + homePage.getFirstArticleInSearchTitleText());
        System.out.println("First article description: " + homePage.getFirstArticleInSearchDescriptionText());
        Assert.assertEquals("Java", homePage.getFirstArticleInSearchTitleText());
        Assert.assertEquals("Island of Indonesia", homePage.getFirstArticleInSearchDescriptionText());
        homePage.firstArticleInSearchOpen();
        articlePage.waitUntilPageIsLoaded();

        articlePage.turnLandscape();
        articlePage.waitUntilPageIsLoaded();
        articlePage.turnPortrait();
        Assert.assertEquals("Java", articlePage.getArticleTitleText());
        Assert.assertEquals("Indonesian island", articlePage.getArticleDescriptionText());
    }

    @Test
    public void searchByTextAndOpenFirstArticleBackgroundTest() {
        homePage.searchBy("Java");
        System.out.println("First article title: " + homePage.getFirstArticleInSearchTitleText());
        System.out.println("First article description: " + homePage.getFirstArticleInSearchDescriptionText());
        Assert.assertEquals("Java", homePage.getFirstArticleInSearchTitleText());
        Assert.assertEquals("Island of Indonesia", homePage.getFirstArticleInSearchDescriptionText());
        homePage.firstArticleInSearchOpen();
        articlePage.waitUntilPageIsLoaded();

        homePage.runBackground(5);
        articlePage.waitUntilPageIsLoaded();
        Assert.assertEquals("Java", articlePage.getArticleTitleText());
        Assert.assertEquals("Indonesian island", articlePage.getArticleDescriptionText());
    }


}
