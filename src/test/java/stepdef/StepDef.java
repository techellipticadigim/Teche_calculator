package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.modules.CalculatorModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertiesReader;

import java.time.Duration;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class StepDef {

    private static final Logger logger = LoggerFactory.getLogger(StepDef.class);
    public WebDriver driver;
    public CalculatorModule calculatorModule;


    @Given("the calculator application is open")
    public void the_calculator_application_is_open() {
        try {
            String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
            logger.info("Browser opened successfully.");
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(Objects.requireNonNull(PropertiesReader.getEndPoint()).getProperty("url"));
            calculatorModule = new CalculatorModule(driver);
            logger.info("URL opened successfully.");
        } catch (Exception e) {
            logger.error("Error opening the browser: {}", e.getMessage(), e);
        }
    }
    //   @add_interferring number
    @When("the user enters the {int} interfering number")
    public void the_user_enters_the_interfering_number(Integer int1) throws Exception {
        String strNum = String.valueOf(int1);
        for (char c : strNum.toCharArray()) {
            calculatorModule.enterNumber(parseInt(String.valueOf(c)));
        }
        logger.debug("Number entered: {}", int1);

    }

    @And("user hit {string} operator")
    public void userHitOperator(String arg0)throws Exception {
        if(arg0.equals("+")){
            calculatorModule.clickButton("add");
        }else if (arg0.equals("-")) {
            calculatorModule.clickButton("sub");
        }else if (arg0.equals("*")) {
            calculatorModule.clickButton("mul");
        }else if (arg0.equals("/")) {
            calculatorModule.clickButton("div");
        }
    }

    @When("the user hit the equals {string} button")
    public void the_user_hit_the_equals_button(String buttontype) throws Exception {
        logger.debug("Clicking the equals button: {}", buttontype);
        calculatorModule.clickButton("equals");
    }

    @Then("the result {int} should be display")
    public void the_result_should_be_display(int expectedResult) throws Exception {
        int actualResult = calculatorModule.getResult();
        assert actualResult == expectedResult : "Expected result: " + expectedResult + ", but found: " + actualResult;
        logger.info("Expected result: {}, Actual result: {}", expectedResult, actualResult);

    }

    //for @add_negative
  @When("the user enters the {int} number")
    public void the_user_enters_the_number(Integer int1) throws Exception {
        String strNum1 = String.valueOf(int1);
        for (char c1 : strNum1.toCharArray()) {
            if (c1 == '-') {
                calculatorModule.clickButton("sub");
            } else {
                calculatorModule.enterNumber(parseInt(String.valueOf(c1)));
            }
        }
    }
    @When("the user looks at the application name should be {string} display")
    public void theUserLooksAtTheApplicationNameShouldBeDisplay(String expectedFormat) {
        String actualNameDisplay = calculatorModule.applicationName();
        Assert.assertTrue(actualNameDisplay.contains(expectedFormat));
    }
    @After
    public void teardown(){
        try{
            driver.close();
        driver.quit();
        }catch(Exception e){

        }
    }

}

