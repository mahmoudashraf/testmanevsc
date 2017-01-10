package game.of.life;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import game.of.life.Cell.CellState;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CellTest {
	
	@Test
	@Parameters({
		"ALIVE, 0, DEAD",
		"ALIVE, 1, DEAD",
		"ALIVE, 2, ALIVE",
		"ALIVE, 3, ALIVE",
		"ALIVE, 4, DEAD",
		"ALIVE, 5, DEAD",
		"ALIVE, 6, DEAD",
		"ALIVE, 7, DEAD",
		"ALIVE, 8, DEAD",
		"DEAD, 0, DEAD",
		"DEAD, 1, DEAD",
		"DEAD, 2, DEAD",
		"DEAD, 3, ALIVE",
		"DEAD, 4, DEAD",
		"DEAD, 5, DEAD",
		"DEAD, 6, DEAD",
		"DEAD, 7, DEAD",
		"DEAD, 8, DEAD"
		})
	public void ShouldFullfillTransition(String initial, int numberOfNeighbors, String expected){
		CellState initialState = CellState.valueOf(initial);
		Cell uut = new Cell(initialState);
		
		uut.update(numberOfNeighbors);
		CellState actual = uut.getState();
		
		CellState expectedState = CellState.valueOf(expected);
		assertEquals(expectedState, actual);
	}
	
	@Test
	@Parameters({"ALIVE", "DEAD"})
	public void shouldReturnItsState(String initial) {
		CellState original = CellState.valueOf(initial);
		Cell uut = new Cell(original);
		
		assertEquals(original, uut.getState());
	}
}
