public class Card {
    private String suit;
    private String number;
    private int value;
    public Card(String suit, String number, int value){
        this.suit=suit;
        this.number=number;
        this.value=value;
    }
    public String getSuit() {
        return suit;
    }
    public String getNumber() {
        return number;
    }
    public int getValue() {
        return value;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setNumber(String value) {
        this.number = number;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return number+" Of "+suit;
    }
}
