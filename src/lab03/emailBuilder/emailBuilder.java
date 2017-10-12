package lab03.emailBuilder;



public class emailBuilder {
    public static void main(String args[]) {
        EmailMessage wiadomosc = null;
        try {
            wiadomosc = EmailMessage.builder()
                    .from("middleOfNowhere@agh.edu.pl")
                    .to("prenc@student.agh.edu.pl")
                    .subject("Mail testowy")
                    .content("Brak tresci")
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assert wiadomosc != null;
        System.out.println(wiadomosc.toString());
//        wiadomosc.send();

    }
}
