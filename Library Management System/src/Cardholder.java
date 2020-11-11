public class Cardholder {

    private String cardHolderID;
    private String name;
    private int age;
    private String cardNumber;
    
    
    public Cardholder(String cHolder, String n, int a, String cardNum ) {
        cardHolderID=cHolder;
        name=n;
        age=a;
        cardNumber=cardNum;
    }
    
    public String getCardHolderID() {
        return  cardHolderID;
    }

    public void setCardHolderID(String cHolder) {
        cardHolderID=cHolder;
    }
    
    
    public String getName() {
        return  name;
    }

    public void setName(String n) {
        name=n;
    }
    
    
    public int getAge() {
        return  age;
    }

    public void setAge(int a) {
        age=a;
    }
    
    
    
    public String getCardNumber() {
        return  cardNumber;
    }

    public void setCardNumber(String cNum) {
        cardNumber=cNum;
    }
    
    
    
    

}