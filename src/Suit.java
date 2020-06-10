public enum Suit{
    SPADE("スペード"), HEART("ハート"), DIAMOND("ダイヤ"), CLUB("クローバー");

    private String mark;
    private Suit(String mark){
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}

