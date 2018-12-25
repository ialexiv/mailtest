package ql;

import org.junit.Before;
import org.junit.Test;
import ql.pages.LoginPage;
import ql.pages.MailMainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class AppTest {

    LoginPage loginPage;
    MailMainPage mailMainPage;
    private static final String MESSAGE_BODY = "Hello world";
    private static final String RECIPIENT = "recipientAddress";
    private static final String MESSAGE_THEME = "test";
    private static final String SUCCESS_TITLE_CLASS_NAME = "message-sent__title";
    private static final String SUCCESS_MESSAGE = "Ваше письмо отправлено. Перейти во Входящие";

    private static final String LOGIN = "mailRuLogin";
    private static final String PASSWORD = "mailRuPass";

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        mailMainPage = new MailMainPage();
        loginPage.goToLoginPage();
    }

    @Test
    public void simpleSendingMessageTest() {
        loginPage.doLogin(LOGIN, PASSWORD);
        mailMainPage.sendMessage(MESSAGE_BODY, RECIPIENT, MESSAGE_THEME);
        $(byClassName(SUCCESS_TITLE_CLASS_NAME)).shouldHave(text(SUCCESS_MESSAGE));
    }

}
