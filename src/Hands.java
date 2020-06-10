import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hands {
    public static final int MAX_TOTAL_VALUE = 21;

    private final List<Card> cardList;

    public Hands(){
        cardList = new ArrayList<>();
    }

    //手札に加える
    public void addCard(Card card){
        cardList.add(card);
    }

    //手札の中身を見せる
    public String showHands(){
        String handString = "現在のカード";
        for(Card card : cardList){
            handString += " " + card.cardDescription();
        }
        return handString;
    }

    //手札の枚数を返す
    public int calculateHandsNum(){
        return cardList.size();
    }

    //手札の合計値を計算する
    public int calculateTotal() {
        int total = cardList.stream()
                .mapToInt(card -> card.getNumber().getPoint())
                .sum();

        List<Card> aceList = cardList.stream()
                .filter(this::isAce)
                .collect(Collectors.toList());

        // エースは11として計算しているので、
        // 最大でエースの枚数だけ10を引ける
        for (Card ace : aceList) {
            if (total > MAX_TOTAL_VALUE) {
                total -= ace.getNumber().getPoint();
                total += ace.getNumber().getAnotherPoint();
            }
        }

        return total;
    }

    private boolean isAce(Card card) {
        return card.getNumber() == Number.ACE;
    }
}
