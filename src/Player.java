import java.util.Scanner;

public class Player implements Person{

    private String name;
    private Hands hands;
    private boolean noMoreDraw;

    public Player(String name){
        this.name = name;
        this.hands = new Hands();
        this.noMoreDraw = false;
    };

    @Override
    public void drawCard(Card card){
        hands.addCard(card);
    }


    public void showHands(){
        System.out.println(this.name + "さんの手札");
        hands.showHands();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHandsNum(){
        return hands.calculateHandsNum();
    }

    @Override
    public int getSumPoint(){
        return hands.calculateTotal();
    }

    @Override
    public boolean isBust() {
        int score = hands.calculateTotal();
        return score > hands.MAX_TOTAL_VALUE;
    }

    @Override
    public boolean willDraw() {
        if(noMoreDraw) {
            return false; //noMoreDrawがTrueならもうカード弾けない
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("カードを引きますか？(y/n)");
        String answer = scanner.next();
        boolean willDraw = answer.equalsIgnoreCase("y");
        if(!willDraw) {
            noMoreDraw = true;
        }
        return willDraw;
    }

    @Override
    public String toString() {
        String text = name + "の現在のカード : " + hands.showHands() + "\n"
                + "合計 : " + getSumPoint();
        if (isBust()) {
            text += "(バースト)";
        }
        return text;
    }
}
