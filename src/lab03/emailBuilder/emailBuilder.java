package lab03.emailBuilder;



public class emailBuilder {
    public static void main(String args[]) {
        EmailMessage wiadomosc = EmailMessage.builder()
                .from("middleOfNowhere@agh.edu.pl")
                .to("prenc@student.agh.edu.pl")
                .subject("Mail testowy")
                .content("Brak tresci")
                .build();

        System.out.println(wiadomosc.toString());
        wiadomosc.send();
    }
}
