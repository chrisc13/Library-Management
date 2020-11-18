import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Card {
    private long cardNumber;
    private int pin;
    private LocalDate date;

    public Card(int pin, LocalDate date) {

        this.cardNumber = generateCardNumber();
        this.pin = pin;
        this.date = date;
    }

    public Card(long cardNumber, int pin, LocalDate date) {
//			super();
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.date = date;
    }

    public long generateCardNumber() {
        String cardNumStr = "";

        Random rand = new Random();
        int firstNum = rand.nextInt(9) + 1; //the first digit will be between 1 and 9;
        cardNumStr += String.valueOf(firstNum);

        for (int i = 0; i < 11; i++) {
            int num = rand.nextInt(10); //generate a number between 0 and 9
            cardNumStr += num;
        }

        return Long.parseLong(cardNumStr);
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFormattedDate(){
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
