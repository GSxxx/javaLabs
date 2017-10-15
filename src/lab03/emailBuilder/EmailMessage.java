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
            if (!input.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+\\.[a-z]+")) {
                throw new Exception("Wrong email adress.");
            }
            this.from = input;
            return this;
        }

        Builder to(String... input) throws Exception{
            for(String x : input){
                if (!x.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+\\.[a-z]+")) {
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
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", "localhost");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.get(0)));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(content);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception mex) {
            mex.printStackTrace();
        }

    }
}



