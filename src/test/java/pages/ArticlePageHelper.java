package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePageHelper extends PageBase {

    @FindBy(id = "org.wikipedia:id/view_page_title_text")
    WebElement articleTitle;
    @FindBy(id = "org.wikipedia:id/view_page_subtitle_text")
    WebElement articleDescription;
    @FindBy(xpath = "//*[@content-desc='Add this article to a reading list']")
    WebElement readingListIcon;
    @FindBy(id = "onboarding_button")
    WebElement gotItButton;
    @FindBy(id = "text_input")
    WebElement nameOfTheReadingListInputField;
    @FindBy(id = "android:id/button1")
    WebElement okButton;


    public ArticlePageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(articleTitle, 5);
        waitUntilElementIsVisible(articleDescription, 5);
    }

    public String getArticleTitleText() {
        return articleTitle.getText();
    }

    public String getArticleDescriptionText() {
        return articleDescription.getText();
    }

    public void addArticleToTheNewlyCreatedReadingList() {
        clickOnReadingListIcon();
        waitUntilElementIsClickable(gotItButton, 5);
        acceptReadingListMessage();
        defaultNameOfTheReadingListInput();
    }

    public void clickOnReadingListIcon() {
        readingListIcon.click();
    }

    public void acceptReadingListMessage() {
        gotItButton.click();
    }

    public void defaultNameOfTheReadingListInput() {
        waitUntilElementIsClickable(okButton, 5);
        clickOnOkButton();
    }

    public void nameOfTheReadingListInput(String text) {
        waitUntilElementIsClickable(nameOfTheReadingListInputField, 5);
        fillInTheNameOfReadingList(text);
        clickOnOkButton();
    }

    public void fillInTheNameOfReadingList(String text) {
        nameOfTheReadingListInputField.sendKeys(text);
    }

    public void clickOnOkButton() {
        okButton.click();
    }

    public void returnToTheMainPage() {
        driver.navigate().back();
    }
}
