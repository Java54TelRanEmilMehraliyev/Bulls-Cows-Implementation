package telran;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private long id;
	private String serverSequence;
	private boolean isFinished;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private List<MoveResult> results;
	
	public Game(long id, String serverSequence) {
		super();
		this.id = id;
		this.serverSequence = serverSequence;
		this.isFinished = isFinished;
		this.startTime = startTime;
		this.endTime = endTime;
		this.results = new ArrayList<>();
	}
	public long getId() {
        return id;
    }

    public String getServerSequence() {
        return serverSequence;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<MoveResult> getResults() {
        return results;
    }

    public List<MoveResult> moveProcess(Move move) {
        String clientSequence = move.getClientSequence();
        int bulls = 0;
        int cows = 0;

        // Calculate bulls and cows
        for (int i = 0; i < 4; i++) {
            if (clientSequence.charAt(i) == serverSequence.charAt(i)) {
                bulls++;
            } else if (serverSequence.contains(Character.toString(clientSequence.charAt(i)))) {
                cows++;
            }
        }

        MoveResult result = new MoveResult(clientSequence, bulls, cows);
        results.add(result);

        if (bulls == 4) {
            isFinished = true;
            endTime = LocalDateTime.now();
        }

        return results;
    }
}
