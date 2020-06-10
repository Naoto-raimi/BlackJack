public enum Number {
    ACE(1,"A",11){
        @Override
        public int getAnotherPoint(){
            return 1;
        }
    },
    TWO(2,"2",2),
    THREE(3,"3",3),
    FOUR(4,"4",4),
    FIVE(5,"5",5),
    SIX(6,"6",6),
    SEVEN(7,"7",7),
    EIGHT(8,"8",8),
    NINE(9,"9",9),
    TEN(10,"10",10),
    JACK(11,"J",10),
    QUEEN(12,"Q",10),
    KING(13,"K",10);

    private int num;
    private String trampNum;
    private int point;

    private Number(int num, String trampNum, int point){
        this.num = num;
        this.trampNum = trampNum;
        this.point = point;
    }

    public int getNum() {
        return num;
    }

    public String getTrampNum() {
        return trampNum;
    }

    public int getPoint() {
        return point;
    }

    public int getAnotherPoint(){
        return point;
    }
}
