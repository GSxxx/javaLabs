package lab03.emailBuilder;



public class emailBuilder {
    public static void main(String args[]) {
        EmailMessage wiadomosc = null;
        try {
            wiadomosc = EmailMessage.builder()
                    .from("mailfortests3@gmail.com")
                    .to("prenc@student.agh.edu.pl")
                    .subject("Super spamowy mail")
                    .content("To tylko spam")
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assert wiadomosc != null;
        System.out.println(wiadomosc.toString());
        wiadomosc.send();

    }
}
