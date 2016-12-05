//package Sudoku;

public class SolverEasy extends Solver {

	public SolverEasy() {
		super();
		System.out.println("Difficulty set to easy");
	}

	public boolean solvable(Sudoku s) {
		Sudoku sc = new Sudoku(s);// Sudoku-Copy
		boolean work = true;
		while (work && !sc.isSolved()) {
			work = false;
			for (int i = 0; i < 9; i++) {
				if (solveLine(sc, i)) {
					work = true;
				}
			}
			for (int i = 0; i < 9; i++) {
				if (solveColumn(sc, i)) {
					work = true;
				}
			}
		}
		System.out.println("Solved"+sc);
		return sc.isSolved();
	}

	private boolean solveLine(Sudoku s, int line) {
		// solves a line with exactly one missing element
		int sum = 0;
		int missingno; // Missing Number
		int foundColumn = -1;
		for (int i = 0; i < 9; i++) {
			int temp = s.getAt(line, i);
			sum += temp;
			if (temp == 0) {
				if (foundColumn > -1) {
					return true;// true = something changed
				}
				foundColumn = i;
			}
		}
		if (sum == 45) {
			return false;// already solved
		}
		missingno = 45 - sum;
		s.setAt(line, foundColumn, missingno);
		return true;
	}

	private boolean solveColumn(Sudoku s, int column) {
		// solves a column with exactly one missing element
		int sum = 0;
		int missingno; // Missing Number
		int foundLine = -1;
		for (int i = 0; i < 9; i++) {
			int temp = s.getAt(i, column);
			sum += temp;
			if (temp == 0) {
				if (foundLine > -1) {
					return true;// true = something changed
				}
				foundLine = i;
			}
		}
		if (sum == 45) {
			return false;// already solved
		}
		missingno = 45 - sum;
		s.setAt(foundLine, column, missingno);
		return true;
	}
}
