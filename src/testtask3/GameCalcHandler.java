package testtask3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameCalcHandler {
    private Game game;
    private Integer iterations;
    public GameCalcHandler(ArrayList<Integer> pl1Sequence, ArrayList<Integer> pl2Sequence, int numDiceRolls, int iters) {
        this.game = new Game(pl1Sequence, pl2Sequence, numDiceRolls);
        this.iterations = iters;
        // System.out.println(pl1Sequence);
        // System.out.println(pl2Sequence);
        // System.out.println(numDiceRolls);
        // System.out.println(iters);
    }

    public HashMap<String, Double> startCompute() {
        HashMap<String, Double> probabilities = new HashMap<>();
        probabilities.put("Player1", 0.0);
        probabilities.put("Player2", 0.0);
        probabilities.put("Draw", 0.0);
        for (int i = 0; i < this.iterations; ++i) {
            if (i % 1_000_000 == 0) {
                System.out.println(i);
            }
            String gameRes = this.game.calcGameResult();
            probabilities.put(gameRes, probabilities.get(gameRes)+1);
        }
        for (Map.Entry<String, Double> pair: probabilities.entrySet()) {
            probabilities.put(pair.getKey(), pair.getValue()/this.iterations);
        }
        System.out.println(probabilities);
        return probabilities;
    }
}
