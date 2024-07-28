package telran;

public class MoveResult {
	private String clientSequence;
	private int bulls;
	private int cows;

	public MoveResult(String clientSequence, int bulls, int cows) {
		this.clientSequence = clientSequence;
		this.bulls = bulls;
		this.cows = cows;
	}
	public String getClientSequence() {
		return clientSequence;
	}

	public int getBulls() {
		return bulls;
	}
	public int getCows() {
		return cows;
	}
}
