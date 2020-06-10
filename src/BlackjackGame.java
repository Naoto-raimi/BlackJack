public class BlackjackGame {
    private Player player;

    private Dealer dealer;

    private Deck deck;

    private Referee referee;

    public BlackjackGame(Player player, Dealer dealer, Deck deck, Referee referee) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.referee = referee;
    }

    public void start() {
        System.out.println("ブラックジャックへようこそ！");
        // 1回目のヒット
        player.drawCard(deck.releaseCard());
        dealer.drawCard(deck.releaseCard());
        System.out.println(dealer);
        // 2回目のヒット
        player.drawCard(deck.releaseCard());
        dealer.drawCard(deck.releaseCard());
        System.out.println(player);

        while (true) {
            System.out.println("--------------");
            // プレイヤーがカードを引くか意思決定する
            boolean playerWillDraw = player.willDraw();
            if (playerWillDraw) {
                // プレイヤーがカードを引く
                player.drawCard(deck.releaseCard());
                System.out.println(player);
            }

            // ディーラーがカードを引くか意思決定する
            boolean dealerWillDraw = dealer.willDraw();
            if (dealerWillDraw) {
                // ディーラーがカードを引く
                dealer.drawCard(deck.releaseCard());
                System.out.println("ディーラーがカードを引きました");
            }

            // プレイヤーとディーラーの両方がこれ以上カードをヒットしない、
            // またはどちらかがバーストしたら繰り返しを終了する
            if (playerWillDraw == false && dealerWillDraw == false
                    || player.isBust() || dealer.isBust()) {
                break;
            }
        }

        System.out.println("--------------");
        System.out.println(player);
        System.out.println(dealer);

        showWinner(player, dealer);
    }

    private void showWinner(Player player, Dealer dealer) {
        Result result = referee.judge(player, dealer);
        switch (result) {
            case DRAW:
                System.out.println("引き分けです。");
                break;
            case PLAYER_WIN:
                System.out.println(player.getName() + "の勝ちです！");
                break;
            default:
                System.out.println(dealer.getName() + "の勝ちです！");
        }
    }
}
