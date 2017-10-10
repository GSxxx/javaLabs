package lab03.emailBuilder;

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


    public EmailMessage(String from, LinkedList<String> to, String subject, String content, String mimeType, LinkedList<String> cc, LinkedList<String> bcc) {
        this.from = from;
        this.to = to;
        if(subject!= null) this.subject = subject;
        if(content!= null) this.content = content;
        if(mimeType!= null) this.mimeType = mimeType;
        if(cc!= null) this.cc = cc;
        if(bcc!= null) this.bcc = bcc;
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public static class Builder {
    }

}



