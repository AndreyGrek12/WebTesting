package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import page.MainPage;
import page.CalculatorPage;


class TestOne extends BaseTest {

    @Test
    @Description ("Проверка операций с целыми числами")
    public void case1(){
        MainPage mainPage = new MainPage(driver);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        mainPage.sendTextInField("Калькулятор");
        mainPage.clickForSearch();
        for (char i: "(1+2)×3−40÷5=".toCharArray()){
            calculatorPage.clickButton(String.valueOf(i));
        }
        Assert.assertEquals(calculatorPage.getTextFromExpression(),"(1 + 2) × 3 - 40 ÷ 5 =");
        Assert.assertEquals(calculatorPage.getTextFromValue(),"1");
    }

    @Test
    @Description ("Проверка деления на ноль")
    public void case2(){
        MainPage mainPage = new MainPage(driver);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        mainPage.sendTextInField("Калькулятор");
        mainPage.clickForSearch();
        calculatorPage.clickButton("6").clickButton("÷").clickButton("0").clickButton("=");
        Assert.assertEquals(calculatorPage.getTextFromExpression(),"6 ÷ 0 =");
        Assert.assertEquals(calculatorPage.getTextFromValue(),"Infinity");
    }

    @Test
    @Description ("Проверка ошибки при отсутствии значения")
    public void case3(){
        MainPage mainPage = new MainPage(driver);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        mainPage.sendTextInField("Калькулятор");
        mainPage.clickForSearch();
        calculatorPage.clickButton("sin").clickButton("=");
        Assert.assertEquals(calculatorPage.getTextFromExpression(),"sin() =");
        Assert.assertEquals(calculatorPage.getTextFromValue(),"Error");
    }

}
