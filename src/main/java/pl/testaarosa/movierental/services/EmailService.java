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
        LOGGER.info("\033[34m Movierental is starting email preparation....\033[0m");
        try {
            SimpleMailMessage mailMessage = getSimpleMailMessage(mail);
            javaMailSender.send(mailMessage);
            LOGGER.info("\033[34m Email has been sent to -> " + mail.getMailTo() + " \033[34m and CC to -> \033[0m" + mail.getToCc());
        } catch (MailException e) {
            LOGGER.error("\033[31m Failed to process email sending \033[0m", e.getMessage(), e);
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
