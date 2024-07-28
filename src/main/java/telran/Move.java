package telran;

public class Move {
 private long gameId;
 private String clientSequence;

 public Move(long gameId, String clientSequence) {
	
	this.gameId = gameId;
	this.clientSequence = clientSequence;
}
 public long getGameId() {
	 return gameId;
 }
 public String getClientSequence() {
	 return clientSequence;
 }
}
