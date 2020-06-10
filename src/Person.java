public interface Person {
    //カードを引く
    void drawCard(Card card);

    //名前の取得
    String getName();

    //手札の合計値を算出
    int getSumPoint();

    //手札の枚数を算出
    int getHandsNum();

    //バーストの判定
    boolean isBust();

    //カードを引けるかの判定
    boolean willDraw();

    @Override
    String toString();


}
