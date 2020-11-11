import java.time.LocalDate;

public class Card {
		private String cardNumber;
		private int pin;
		private LocalDate date;
		
		public Card(String cardNumber, int pin, LocalDate date) {
			super();
			this.cardNumber = cardNumber;
			this.pin = pin;
			this.date = date;
		}
		
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
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
}
