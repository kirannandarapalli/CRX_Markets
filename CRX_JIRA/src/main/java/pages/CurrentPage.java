package pages;

import net.serenitybdd.core.pages.PageObject;

/**
 * @author Kiran Nandarapalli
 *
 */

public class CurrentPage extends PageObject {
    public String noticeMessage() {
        return $(".notice").getText();
    }
}