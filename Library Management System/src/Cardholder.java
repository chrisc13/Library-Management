public class Cardholder {

    private String cardHolderID;
    private String name;
    private int age;
    private long cardNumber;

    public Cardholder(String n, int a, long cardNum ) {
        name=n;
        age=a;
        cardNumber=cardNum;
    }

    public Cardholder(String cHolder, String n, int a, long cardNum ) {
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
    
    
    
    public long getCardNumber() {
        return  cardNumber;
    }

    public void setCardNumber(long cNum) {
        cardNumber=cNum;
    }


    
    

}