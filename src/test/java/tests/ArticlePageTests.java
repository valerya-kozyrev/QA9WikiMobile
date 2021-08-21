package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePageHelper;
import pages.HomePageHelper;
import pages.ReadingListPageHelper;

public class ArticlePageTests extends TestBase {

    HomePageHelper homePage;
    ArticlePageHelper articlePage;
    ReadingListPageHelper readingListPage;

    @BeforeMethod
    public void initTest() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        articlePage = PageFactory.initElements(driver, ArticlePageHelper.class);
        readingListPage = PageFactory.initElements(driver, ReadingListPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        homePage.searchBy("Java");
        homePage.firstArticleInSearchOpen();
        articlePage.waitUntilPageIsLoaded();
    }


    @Test
    public void searchAndPutToReadingList() throws InterruptedException {
        articlePage.addArticleToTheNewlyCreatedReadingList();
        articlePage.waitUntilPageIsLoaded();
        articlePage.returnToTheMainPage();
        homePage.waitUntilPageIsLoaded();
        homePage.clickOnReadingListIcon();
        readingListPage.waitUntilPageIsLoaded();
        readingListPage.openFirstReadingList();
//        readingListPage.waitUntilMyReadingListIsLoaded();
        Thread.sleep(3000);
        Assert.assertEquals("Java", readingListPage.getFirstArticleInReadingListTitleText());
        Assert.assertEquals("island of Indonesia", readingListPage.getFirstArticleInReadingListDescriptionText());
}

}
