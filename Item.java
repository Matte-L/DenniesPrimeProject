public class Item {
    private String name;
    private int price;      //in cents

    public Item(String name, int price){ //default constructor for toTxt
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void print(){
        System.out.println(name + ": $" + price/100 + '.' +price%100);
    }
}
