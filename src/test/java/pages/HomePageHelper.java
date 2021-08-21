package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HomePageHelper extends PageBase{

    @FindBy(xpath = "//*[@resource-id = 'org.wikipedia:id/search_container']/*[@class='android.widget.TextView']")
    WebElement searchField;
    @FindBy(id = "org.wikipedia:id/search_src_text")
    WebElement searchFieldInside;
    @FindBy(id = "org.wikipedia:id/page_list_item_container")
    WebElement firstArticle;
    @FindBy(id = "org.wikipedia:id/page_list_item_title")
    WebElement firstArticleInSearchTitle;
    @FindBy(id = "org.wikipedia:id/page_list_item_description")
    WebElement firstArticleInSearchDescription;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='My lists']/android.widget.ImageView")
    WebElement readingListIcon;

    public HomePageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(searchField,5);
    }

    public String getSearchFieldText(){
        return searchField.getText();
    }

    public void searchBy(String text) {
        searchField.click();
        waitUntilElementIsClickable(searchFieldInside,5);
        searchFieldInside.sendKeys(text);
        waitUntilElementIsVisible(firstArticle,5);
    }

    public String getFirstArticleInSearchTitleText(){
        return firstArticleInSearchTitle.getText();
    }

    public String getFirstArticleInSearchDescriptionText(){
        return firstArticleInSearchDescription.getText();
    }

    public void firstArticleInSearchOpen() {
        firstArticle.click();
    }

    public void clickOnReadingListIcon() {
        readingListIcon.click();
    }
}
