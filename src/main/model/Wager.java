package model;

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

    //
    public Integer getAmountWagered() {
        return amount;
    }

}
