package Sudoku;

//import java.util.ArrayList;

public class SudokuMain {

	public static void main(String args[]) {
		Sudoku sud_1 = new Sudoku();
		Solver test = new SolverEasy();
		System.out.println("Solvable: "+test.solvable(sud_1));
		System.out.println("\nOriginal:\n" + sud_1 + "\n\n");

	}

}