package ql.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MailMainPage {

    private static final String MESSAGE_BODY_TEXT_AREA_ID = "tinymce";

    private SelenideElement makeMessageButton = $(byText("Написать письмо"));
    private SelenideElement recipientField = $(byAttribute("data-original-name", "To"));
    private SelenideElement subjectField = $(byName("Subject"));
    private SelenideElement sendMessageButton = $(byText("Отправить"));

    public void sendMessage(String messageText, String recipient, String messageTheme) {
        makeMessageButtonClick();
        setRecipientField(recipient);
        setSubject(messageTheme);
        sendKeysToMessageBody(messageText);
        sendMessageButtonClick();
    }

    private void makeMessageButtonClick() {
        makeMessageButton.click();
    }

    private void setRecipientField(String recipient) {
        recipientField.setValue(recipient);
    }

    private void setSubject(String messageTheme) {
        subjectField.setValue(messageTheme);
    }

    private void sendKeysToMessageBody(String messageText) {
        Selenide.switchTo().frame(0);
        $(byId(MESSAGE_BODY_TEXT_AREA_ID)).sendKeys(messageText);
        Selenide.switchTo().defaultContent();
    }

    private void sendMessageButtonClick() {
        sendMessageButton.click();
    }
}
