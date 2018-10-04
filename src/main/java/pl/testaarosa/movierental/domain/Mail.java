package pl.testaarosa.movierental.domain;


import java.util.Objects;

public class Mail {

    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

    public Mail() {
    }

    public Mail(String mailTo, String subject, String message) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }

    public Mail(String mailTo, String subject, String message, String toCc) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.toCc = toCc;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToCc() {
        return toCc;
    }

    public void setToCc(String toCc) {
        this.toCc = toCc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(mailTo, mail.mailTo) &&
                Objects.equals(subject, mail.subject) &&
                Objects.equals(message, mail.message) &&
                Objects.equals(toCc, mail.toCc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailTo, subject, message, toCc);
    }
}
