package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.BullsCowsMapImpl;
import telran.BullsCowsService;
import telran.Move;
import telran.MoveResult;

import java.util.List;

class BullsCowsMapImplTest {
    BullsCowsService service;

    @BeforeEach
    void setUp() {
        service = new BullsCowsMapImpl();
    }

    @Test
    void testCreateNewGame() {
        Long gameId = service.createNewGame();
        assertNotNull(gameId, "Game ID should not be null");
    }

    @Test
    void testGetResults() {
        Long gameId = service.createNewGame();
        Move move = new Move(gameId, "8711");
        List<MoveResult> results = service.getResults(gameId, move);
        assertNotNull(results, "Results should not be null");
        assertFalse(results.isEmpty(), "Results should not be empty");
        assertEquals(1, results.size(), "Results size should be 1");
    }

    @Test
    void testIsGameOver() {
        Long gameId = service.createNewGame();
        assertFalse(service.isGameOver(gameId), "Game should not be over at the start");

        // Simulate a winning move
        BullsCowsMapImpl serviceImpl = (BullsCowsMapImpl) service;
        String serverSequence = serviceImpl.getGames().get(gameId).getServerSequence();
        Move winningMove = new Move(gameId, serverSequence);
        service.getResults(gameId, winningMove);

        assertTrue(service.isGameOver(gameId), "Game should be over after a winning move");
    }
}