package model;

// The chosen match to wager on and the amount chosen
public class Wager {
    Integer amount;
    Match match;

    public Wager(Match match, Integer amount) {
        this.amount = amount;
        this.match = match;
    }

    public Match getMatchWagered() {
        return match;
    }


    public Integer getAmountWagered() {
        return amount;
    }

}
