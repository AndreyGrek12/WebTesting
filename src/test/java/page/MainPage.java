package page;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//input[@aria-label='Найти']")
    private WebElement textField;

    @FindBy(xpath = "//input[@aria-label='Поиск в Google']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Ввести {text} в строку поиска")
    public void sendTextInField(String text) {
        textField.sendKeys(text);
    }
    @Step("Нажать кнопку поиска")
    public void clickForSearch(){
        searchButton.click();
    }
}
