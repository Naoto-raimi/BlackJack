public class Main {
    public static void main(String[] args) {
        Player player = new Player("カイジ");
        Dealer dealer = new Dealer("利根川");
        Deck deck = new Deck();
        Referee referee = new Referee();

        BlackjackGame game = new BlackjackGame(player,dealer,deck,referee);
        game.start();
    }
}
