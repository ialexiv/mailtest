package ql.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String URL = "https://mail.ru";

    private SelenideElement loginField = $(byId("mailbox:login"));
    private SelenideElement passwordField = $(byId("mailbox:password"));
    private SelenideElement submitButton = $(byCssSelector("#mailbox\\:submit"));

    public LoginPage(boolean startMaximized, String reportsFolder, String targetBrowser, boolean isHeadless, boolean isHoldBrowser) {
        Configuration.startMaximized = startMaximized;
        Configuration.reportsFolder = reportsFolder;
        Configuration.browser = targetBrowser;
        Configuration.headless = isHeadless;
        Configuration.holdBrowserOpen = isHoldBrowser;
    }

    public LoginPage() {
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.browser = "firefox";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
    }

    public void goToLoginPage() {
        open(URL);
    }

    public void doLogin(String login, String password) {
        goToLoginPage();
        setLogin(login);
        setPassword(password);
        submitButtonClick();
    }

    private void setLogin(String login) {
        loginField.setValue(login);
    }

    private void setPassword(String password) {
        passwordField.setValue(password);
    }

    private void submitButtonClick() {
        submitButton.click();
    }

}
