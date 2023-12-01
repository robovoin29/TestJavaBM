package testtask3;

import java.util.ArrayList;
import java.util.Random;

class Game {
    private final PlayerInfo player1;
    private final PlayerInfo player2;
    private final Integer numDiceRolls;
    private String result;
    Game(ArrayList<Integer> pl1Sequence, ArrayList<Integer> pl2Sequence, int numDiceRolls) {
        this.player1 = new PlayerInfo(pl1Sequence);
        this.player2 = new PlayerInfo(pl2Sequence);
        this.numDiceRolls = numDiceRolls;
    }

    private ArrayList<Integer> randomDiceSequence() {
        ArrayList<Integer> diceSequence = new ArrayList<>();
        for (int i = 0; i < numDiceRolls; ++i) {
            Random random = new Random();
            diceSequence.add(random.nextInt(1, 7));
        }
        return diceSequence;
    }

    private Integer calcPlayerScore(PlayerInfo player, ArrayList<Integer> diceSequence) {
        Integer playerScore=0;
        player.setCurIdxSkip(0);
        for (int i = 0; i < diceSequence.size() - 2; ++i) {
            if (player.getCurIdxSkip() == 0) {
                ArrayList<Integer> tempPlayerSeq = player.getSequence();
                boolean isScored = true;
                for (int j = 0; j < 3; ++j) {
                    if (!tempPlayerSeq.get(j).equals(diceSequence.get(i+j))) {
                        isScored = false;
                        break;
                    }
                }
                if (isScored) {
                    playerScore++;
                    player.setCurIdxSkip(2);
                }
            } else {
                player.setCurIdxSkip(player.getCurIdxSkip()-1);
            }
        }
        return playerScore;
    }

    String calcGameResult() {
        ArrayList<Integer> diceSequence = randomDiceSequence();
        //System.out.println(this.player1.getSequence());
        //System.out.println(this.player2.getSequence());
        //System.out.println(diceSequence);
        Integer player1score = this.calcPlayerScore(this.player1, diceSequence);
        Integer player2score = this.calcPlayerScore(this.player2, diceSequence);
        //System.out.println(player1score);
        //System.out.println(player2score);
        if (player1score > player2score) {
            return "Player1";
        }
        if (player2score > player1score) {
            return "Player2";
        }
        return "Draw";
    }
}
