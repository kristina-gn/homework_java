package org.example;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class UnicornUITest {
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Kristina");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Goncharova");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
        usernameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanCreateAccount() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Kristina");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Goncharova");

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Street");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("City");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("State");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("123456");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("1234567890");

        String usernameValue = "username";
        SelenideElement username = element(Selectors.byId("customer.username"));
        username.sendKeys(usernameValue);

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("Password");

        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("Password");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement welcomeToAccount = element(Selectors.byClassName("title"));
        welcomeToAccount.shouldHave(Condition.text("Welcome " + usernameValue));
    }
}
