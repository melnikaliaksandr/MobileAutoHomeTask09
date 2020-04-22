package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {

    protected static String
        LOGIN_INPUT = "css:input[name='wpName']",
        PASSWORD_INPUT = "css:input[name='wpPassword']",
        LOGIN_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void enterLoginAndPassword(String login, String password) {
        this.trySendKeysWithFewAttempts(LOGIN_INPUT, login, "Cannot find and a login to the login input", 10);
        this.trySendKeysWithFewAttempts(PASSWORD_INPUT, password, "Cannot find and a password to the password input", 10);
    }

    public void clickLoginButton() {
        this.waitForElementPresent(LOGIN_BUTTON,"Cannot find and a login to the login input", 10);
        this.waitForElementAndClick(LOGIN_BUTTON,"Cannot find and a password to the password input", 5);
    }

}
