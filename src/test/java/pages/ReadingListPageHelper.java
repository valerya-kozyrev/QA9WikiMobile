package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadingListPageHelper extends PageBase{
    @FindBy(id = "org.wikipedia:id/item_container")
    WebElement firstReadingList;
    @FindBy(id = "org.wikipedia:id/item_title")
    WebElement firstReadingListTitle;
    @FindBy(id = "org.wikipedia:id/item_reading_list_statistical_description")
    WebElement firstReadingListDescription;
    @FindBy(id = "org.wikipedia:id/item_title")
    WebElement myReadingListTitle;
    @FindBy(id = "org.wikipedia:id/page_list_item_container")
    WebElement firstArticleInReadingList;
    @FindBy(id = "org.wikipedia:id/page_list_item_title")//xpath = "//*[@text = 'Java']")
    WebElement firstArticleInReadingListTitle;
    @FindBy(id = "org.wikipedia:id/page_list_item_description")//xpath = "//*[contains(@text, 'island of Indonesia']")
    WebElement firstArticleInReadingListDescription;


    public void ReadingListPageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsVisible(firstReadingListTitle,10);
        waitUntilElementIsVisible(firstReadingListDescription,10);
    }

    public void openFirstReadingList(){
        waitUntilElementIsVisible(firstReadingList,10);
        firstReadingList.click();
    }

    public void waitUntilMyReadingListIsLoaded(){
        waitUntilElementIsVisible(myReadingListTitle,10);
//        waitUntilElementIsClickable(firstArticleInReadingList,10);
//        waitUntilElementIsVisible(firstArticleInReadingListTitle,10);
//        waitUntilElementIsVisible(firstArticleInReadingListDescription,10);
    }

    public void openFirstArticleInReadingList(){
        firstArticleInReadingList.click();
    }

    public String getFirstArticleInReadingListTitleText(){
        return firstArticleInReadingListTitle.getText();
    }

    public String getFirstArticleInReadingListDescriptionText(){
        return firstArticleInReadingListDescription.getText();
    }


}
