package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.Mail;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail) {
        LOGGER.info("Movierental is starting email preparation....");
        try {
            SimpleMailMessage mailMessage = getSimpleMailMessage(mail);
            javaMailSender.send(mailMessage);
            LOGGER.info("Email has been sent to -> " + mail.getMailTo() + " and CC to -> " + mail.getToCc());
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending ", e.getMessage(), e);
        }
    }

    private SimpleMailMessage getSimpleMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());

        return mailMessage;
    }
}
