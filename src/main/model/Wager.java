package model;

// The chosen match to wager on and the amount chosen
public class Wager {
    Integer amount;
    Match match;

    public Wager(Match m, Integer amount) {
        amount = 0;
        m = new Match("", "");
    }

    public Match getMatchWagered() {
        return match;
    }


    public Integer getAmountWagered() {
        return amount;
    }

}
