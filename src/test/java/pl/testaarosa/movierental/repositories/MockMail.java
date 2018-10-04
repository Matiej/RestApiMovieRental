package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.Mail;

import java.util.LinkedList;
import java.util.List;

public class MockMail {

    public List<Mail> mailList() {
        Mail mail1 = new Mail();
        mail1.setMailTo("mailsent@gmail.com");
        mail1.setMessage("Message1");
        mail1.setSubject("sub1");
        mail1.setToCc("mailcc@gmail.com");

        Mail mail2 = new Mail();
        mail2.setMailTo("mailsent@gmail.com");
        mail2.setMessage("Message1");
        mail2.setSubject("sub1");
        mail2.setToCc("mailcc@gmail.com");

        List<Mail> mailList = new LinkedList<>();
        mailList.add(mail1);
        mailList.add(mail2);

        return mailList;
    }
}
