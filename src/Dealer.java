import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player{
    private static final int DEALER_THRESHOLD = 17;

    public Dealer(String name) {
        super(name);
    }

    @Override
    public boolean willDraw() {
        return super.getSumPoint() < DEALER_THRESHOLD;
    }

}
