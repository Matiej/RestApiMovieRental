package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.cfg.AdminConfig;
import pl.testaarosa.movierental.domain.Mail;
import pl.testaarosa.movierental.form.UpdateUserForm;
import pl.testaarosa.movierental.form.UserForm;

import static java.util.Optional.ofNullable;

@Service
public class EmailNotifierService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private EmailService emailService;

    public void sendEmailToNewUser(UserForm userForm) {
        String subject = "Welcome " + userForm.getName() + ", Testaarosa movierental app created Yours account";

        StringBuilder message = new StringBuilder("Yours account created as above: " + "\n"
                + "Name: " + userForm.getName() + ",  surname: " + userForm.getSurname() + "\n"
                + "City: " + userForm.getCity() + ",  street: " + userForm.getStreet() + "\n"
                + " ** Birthday: " + userForm.getBirthday() + "\n"
                + "User email: " + userForm.getEmail() + " \n Date of registration: " + userForm.getRegisterDate() + "\n\n"
                + "############################################## \n" + "YOU CAN FIND ME HERE:  http://www.testaarosa.pl");

        ofNullable(userForm).ifPresent(c -> emailService.send(new Mail(
                c.getEmail(), subject, message.toString(), adminConfig.getAdminMail())));
    }

    public void sendEmailToUpdatedUser(UpdateUserForm updateUserForm) {
        String subject = "Welcome " + updateUserForm.getName() + ", Testaarosa movierental app created Yours account";

        StringBuilder message = new StringBuilder("Yours account updated  as above: " + "\n"
                + "Name: " +updateUserForm.getName() + ",  surname: " + updateUserForm.getSurname() + "\n"
                + "City: " + updateUserForm.getCity() + ",  street: " + updateUserForm.getStreet() + "\n"
                + " ** Birthday: " + updateUserForm.getBirthday() + "\n"    //TODO zamienić na update date
                + "User email: " + updateUserForm.getEmail() + " \n Date of registration: " + updateUserForm.getRegisterDate() + "\n\n"
                + "############################################## \n" + "YOU CAN FIND ME HERE:  http://www.testaarosa.pl");

        ofNullable(updateUserForm).ifPresent(c -> emailService.send(new Mail(
                c.getEmail(), subject, message.toString(), adminConfig.getAdminMail())));
    }
}
