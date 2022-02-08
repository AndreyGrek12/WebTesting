package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    private final WebDriver driver;

    @FindBy (xpath = "//span[@jsname='ubtiRe']")
    private WebElement expression;

    @FindBy (xpath = "//span[@jsname='VssY5c']")
    private WebElement value;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Получение выражения")
    public String getTextFromExpression(){
        return expression.getText();
    }

    @Step("Получение значения выражения")
    public String getTextFromValue(){
        return value.getText();
    }

    @Step("Нажатие {buttonText} в калькуляторе")
    public CalculatorPage clickButton(String buttonText) {
        driver.findElement(By.xpath("//*[text() = '" + buttonText + "' and @role='button']")).click();
        return this;
    }
}
