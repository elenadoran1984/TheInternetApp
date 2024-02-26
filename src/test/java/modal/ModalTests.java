package modal;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModalTests extends BaseTests {

    @Test
    public void testModal(){
       var entryAdPage =  homePage.clickEntryAd();
       assertEquals(entryAdPage.getTitle(),
               "This is a modal window",
               "Incorrect text title");
       assertEquals(entryAdPage.getBody(),
               "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).",
               "Incorrect text body");
       assertEquals(entryAdPage.getFooter(),
               "Close",
               "Incorrect text footer");
    }
}
