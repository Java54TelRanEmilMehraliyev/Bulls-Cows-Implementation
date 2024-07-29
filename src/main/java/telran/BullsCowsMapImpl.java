package telran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsCowsMapImpl implements BullsCowsService {
    private Map<Long, Game> games = new HashMap<>();
    private long nextId = 1;

    @Override
    public Long createNewGame() {
        long gameId = nextId++;
        String serverSequence = generateServerSequence();
        Game newGame = new Game(gameId, serverSequence);
        games.put(gameId, newGame);
        return gameId;
    }

    private String generateServerSequence() {
        String digits = "0123456789";
        StringBuilder sequence = new StringBuilder();
        while (sequence.length() < 4) {
            int index = (int) (Math.random() * digits.length());
            char digit = digits.charAt(index);
            if (sequence.indexOf(String.valueOf(digit)) == -1) {
                sequence.append(digit);
            }
        }
        return sequence.toString();
    }

    @Override
    public List<MoveResult> getResults(long gameId, Move move) {
        Game game = games.get(gameId);
        if (game != null) {
            return game.moveProcess(move);
        }
        return null;
    }

    @Override
    public Boolean isGameOver(long gameId) {
        Game game = games.get(gameId);
        if (game != null) {
            return game.isFinished();
        }
        return false;
    }

    public Map<Long, Game> getGames() {
        return games;
    }
}