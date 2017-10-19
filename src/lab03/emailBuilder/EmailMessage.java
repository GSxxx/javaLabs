package lab03.emailBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional


    EmailMessage(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.content = builder.content;
        this.mimeType = builder.mimeType;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
    }


    static Builder builder() {
        return new EmailMessage.Builder();
    }

    public static class Builder {
        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; //optional

        Builder from(String input) throws Exception {
            if (!input.matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?")) {
                throw new Exception("Wrong email adress.");
            }
            this.from = input;
            return this;
        }

        Builder to(String... input) throws Exception {
            for (String x : input) {
                if (!x.matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?")) {
                    throw new Exception("Wrong email adress.");
                }
            }
            this.to = new LinkedList<>(Arrays.asList(input));
            return this;
        }

        Builder subject(String input) {
            this.subject = input;
            return this;
        }

        Builder content(String input) {
            this.content = input;
            return this;
        }

        public Builder mimeType(String input) {
            this.mimeType = input;
            return this;
        }

        public Builder cc(String... input) {
            this.cc = new LinkedList<>(Arrays.asList(input));
            return this;
        }

        public Builder bcc(String... input) {
            this.bcc = new LinkedList<>(Arrays.asList(input));
            return this;
        }

        EmailMessage build() {
            return new EmailMessage(this);
        }
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n", from, to, subject, content);
    }

    public void send() {
        final String username = "mailfortests3@gmail.com";
        final String password = "kwiatek123";

        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to.get(0)));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Message sent!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}





