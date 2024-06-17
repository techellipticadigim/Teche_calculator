package org.modules;

import org.exception.InvalidCalculatorNumberException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.pageobject.CalculatorScreenPageObject.*;

public class CalculatorModule {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorModule.class);
    public WebDriver driver;
    public CalculatorModule(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method is use to enter number .
     * If user providing number more then 9999 and less then 0
     * this method will return InvalidCalculatorNumberException
     * If number is equal to 0, it clicks on a button represented by btn_0.
     * If number is equal to 1, it clicks on a button represented by btn_1.
     * This pattern continues up to 9, where each value of number corresponds to clicking a specific button.
     * If number is not between 0 and 9 (inclusive), it throws an InvalidCalculatorNumberException with a
     * message indicating the invalid number.
     */

    public void enterNumber(int number) throws InvalidCalculatorNumberException {
        logger.debug("Attempting to click number: {}", number);
        if (number < 0 || number > 9999) {
            throw new InvalidCalculatorNumberException("Invalid number: " + number);
        }
        if (number == 0) {
            driver.findElement(btn_0).click();
        } else if (number == 1) {
           driver.findElement(btn_1).click();
        } else if (number == 2) {
            driver.findElement(btn_2).click();
        } else if (number == 3) {
            driver.findElement(btn_3).click();
        } else if (number == 4) {
             driver.findElement(btn_4).click();
        } else if (number == 5) {
            driver.findElement(btn_5).click();
        } else if (number == 6) {
           driver.findElement(btn_6).click();
        } else if (number == 7) {
            driver.findElement(btn_7).click();
        } else if (number == 8) {
             driver.findElement(btn_8).click();
        } else if (number == 9) {
             driver.findElement(btn_9).click();
        } else {
            throw new InvalidCalculatorNumberException("Invalid number: " + number);
        }

    }
    /**
     * This method is use to click button .
     * It declares a variable buttonElement of type WebElement.
     * It uses a switch statement to determine which button to click based on the value of buttonType.
     * For each case ("add", "sub", "div", etc.), it finds the corresponding button element using driver.findElement()
     * method and assigns it to the buttonElement variable.
     * After finding the button element, it logs a debug message indicating which button was clicked.
     * If buttonType does not match any of the predefined cases, it throws an InvalidCalculatorNumberException
     * with an appropriate error message.
     * Finally, it clicks on the identified button element using buttonElement.click().
     */

    public void clickButton(String buttonType) throws InvalidCalculatorNumberException {
        WebElement buttonElement;
        switch(buttonType) {
            case "add":
                buttonElement = driver.findElement(btn_addition);
                logger.debug("Clicked the addition button");
                break;
            case "sub":
                buttonElement = driver.findElement(btn_minus);
                logger.debug("Clicked the subtraction button");
                break;
            case "div":
                buttonElement = driver.findElement(btn_division);
                logger.debug("Clicked the division button");
                break;
            case "mul":
                buttonElement = driver.findElement(btn_multiply);
                logger.debug("Clicked the multiplication button");
                break;
            case "equals":
                buttonElement = driver.findElement(btn_equals);
                logger.debug("Clicked the equals button");
                break;
            case "dot":
                buttonElement = driver.findElement(btn_dot);
                logger.debug("Clicked the dot button");
                break;
            case "clear":
                buttonElement = driver.findElement(btn_clear);
                logger.debug("Clicked the clear button");
                break;
            default:
                throw new InvalidCalculatorNumberException("Invalid button type: " + buttonType);
        }
        buttonElement.click();
    }


    public int getResult() {
        WebElement resultFieldElement = driver.findElement(btn_result);
        String resultText = resultFieldElement.getText().replaceAll("[^\\d]", ""); // Remove non-numeric characters
        int result = Integer.parseInt(resultText);
        logger.debug("Result obtained: {}", result);
        return result;
    }

 public String applicationName() {
        WebElement viewApplicationName = driver.findElement(name);
        return viewApplicationName.getText();
     }

 public void appTitle() {
        WebElement viewAppTitle = driver.findElement(title);
        viewAppTitle.getText();
 }


   /* public void clickAddButton() {
        WebElement addButtonElement = driver.findElement(btn_addition);
        addButtonElement.click();
        logger.debug("Clicked the addition button");
    }

    public void clickSubButton() {
        WebElement subButtonElement = driver.findElement(btn_minus);
        subButtonElement.click();
        logger.debug("Clicked the subtraction button");
    }

    public void clickDivButton() {
        WebElement divButtonElement = driver.findElement(btn_division);
        divButtonElement.click();
        logger.debug("Clicked the division button");
    }

    public void clickMulButton() {
        WebElement mulButtonElement = driver.findElement(btn_multiply);
        mulButtonElement.click();
        logger.debug("Clicked the multiplication button");
    }

    public void clickEqualsButton() {
        WebElement equalsButtonElement = driver.findElement(btn_equals);
        equalsButtonElement.click();
        logger.debug("Clicked the equals button");
    }

    public void clickDotButton() {
        WebElement dotButtonElement = driver.findElement(btn_dot);
        dotButtonElement.click();
        logger.debug("Clicked the dot button");
    }

    public void clickClearButton() {
        WebElement clearButtonElement = driver.findElement(btn_clear);
        clearButtonElement.click();
        logger.debug("Clicked the clear button");
    }


    }*/

}
