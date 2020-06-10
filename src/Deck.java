import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    private final List<Card> cardDeck;

    public Deck(){
        // デッキを初期化
        //enum values 定義した列挙子をまとめて返す
        ArrayList<Card> cardDeck = new ArrayList<>(52);
        for(Card card: Card.values()){
            cardDeck.add(card);
        }
        //デッキをシャッフル
        Collections.shuffle(cardDeck);
        this.cardDeck = cardDeck;

        //中身を確認
        for(Card card: cardDeck){
            System.out.println(card);
        }
    }

    //一番後ろの要素を取得して削除する(先頭を削除すると処理が重い？)
    //removeは削除した要素が戻り値となる
    public Card releaseCard(){
        return cardDeck.remove(cardDeck.size()-1);
    }

}
