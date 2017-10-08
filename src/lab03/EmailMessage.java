package lab03;

import java.util.LinkedList;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    //Przykładowy konstruktor (można założyć, że pola opcjonalne mogą być null)
    public EmailMessage(String from,
                        LinkedList<String> to,
                        String subject,
                        String content,
                        String mimeType,
                        LinkedList<String> cc,
                        LinkedList<String> bcc) {
        // wiele if, else, sprawdzania czy string jest e-mail, itd.
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    private static class Builder {
    }
}



