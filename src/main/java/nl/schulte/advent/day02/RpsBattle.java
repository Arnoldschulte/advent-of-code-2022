package nl.schulte.advent.day02;

public class RpsBattle {

    private static final int pointsForWinning = 6;
    private static final int pointsForDrawing = 3;

    private final Shape opponent;
    private final Shape player;

    public RpsBattle(String line, boolean decrypting) {
        final String[] split = line.split(" ");
        this.opponent = Shape.getShapeByTextOpponent(split[0]);
        if (decrypting) {
            this.player = Shape.decryptShapeByOpponentAndOutcome(opponent, Outcome.getOutcomeByText(split[1]));
        } else {
            this.player = Shape.getShapeByTextPlayer(split[1]);
        }
    }

    private boolean youWon() {
        return opponent.equals(Shape.PAPER) && player.equals(Shape.SCISSORS) ||
                opponent.equals(Shape.ROCK) && player.equals(Shape.PAPER) ||
                opponent.equals(Shape.SCISSORS) && player.equals(Shape.ROCK);
    }

    private boolean isDraw() {
        return opponent.equals(player);
    }

    public int calculatePoints() {
        if (youWon()) {
            return pointsForWinning + player.getPoints();
        } else if (isDraw()) {
            return pointsForDrawing + player.getPoints();
        } else {
            return player.getPoints();
        }
    }
}
