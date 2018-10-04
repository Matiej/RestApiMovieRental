package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockMail;

import java.util.List;

public class MailTestSuit {

    private MockMail mockMail = new MockMail();

    @Test
    public void testMail() {
        //given
        List<Mail> mailList = mockMail.mailList();
        Mail mail1 = mailList.get(0);
        Mail mail2 = mailList.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(mail1, mail2).testEquals();
    }
}
