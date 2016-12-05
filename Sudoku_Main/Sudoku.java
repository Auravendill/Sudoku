//package Sudoku;

import java.lang.Math; // Math -> random numbers
import java.lang.StringBuilder; // for the toString-method
// makes Sudoku in constructor

public class Sudoku { // class body
	private int mtx[][]; // int matrix
	// constructor makes Sudoku

	public Sudoku() { // constructor header
		mtx = new int[9][9]; // initialize matrix
		int num; // numbers of first row
		boolean fit; // boolean to check whether
		System.out.println("\n\nChanges in game:"); // Announces switches
													// rows/cols
		// ---------------------------------------- // a number is already
		// present
		for (int i = 0; i < 9; i++) { // loop over first row
			do { // loop till number is found
				fit = false; // start with number == new
				num = (int) (Math.random() * 10 / 1); // random numbers (1-9)
				if (num != 0) { // 0 not valid for sudoku
					fit = true; // fit = true till number found
					for (int j = 0; j < i; j++) { // check in first row
						if (mtx[0][j] == num) { // whether number exists
							fit = false; // break loop, if number
							break; // exists, and start over
						} // end of if-exists-clause
					} // end of not-equals-0-clause
				} // end of loop over first row
				if (fit)
					mtx[0][i] = num; // if number is new --> put
			} while (fit == false); // loop till number is found
		} // first row is filled randomly
			// fill rows and shift them
		for (int j = 0; j < 9; j++) { // loop over the other 8 rows
			if (j < 6)
				mtx[1][j + 3] = mtx[0][j]; // shift numbers by 3 columms
			else
				mtx[1][j - 6] = mtx[0][j]; // start over at 0 if necessary
			if (j < 3)
				mtx[2][j + 6] = mtx[0][j]; // shift numbers by 3 columms
			else
				mtx[2][j - 3] = mtx[0][j]; // start over at 0 if necessary
		} // first three rows are filled
			// fill rows 4 till 9
		for (int i = 1; i < 3; i++) { // iterate over rows 1 - 3
			for (int j = 0; j < 9; j++) { // iterate over all columns
				if (j + i < 9) { // if the shift is possible
					mtx[i * 3][j + i] = mtx[0][j]; // add row 1 to row 4 and row
													// 7
					mtx[i * 3 + 1][j + i] = mtx[1][j]; // add row 2 to row 5 and
														// row 8
					mtx[i * 3 + 2][j + i] = mtx[2][j]; // add row 3 to row 6 and
														// row 9
				} // and shift by one or two
				else { // if shift is not possible
					mtx[i * 3][j + i - 9] = mtx[0][j]; // add row 1 to row 4 and
														// row 7
					mtx[i * 3 + 1][j + i - 9] = mtx[1][j]; // add row 2 to row 5
															// and row 8
					mtx[i * 3 + 2][j + i - 9] = mtx[2][j]; // add row 3 to row 6
															// and row 9
				} // and shift back by 9 to fit
			} // end of loop over columns
		} // end of loop over rows
			// ---------------------------------------- // change rows within
			// packs
		int sw = 0; // to register row switches
		int tmp; // variable for triangel switch
		boolean one = false; // first pack switched or not
		int one_num = 0; // counts till two numbers
		boolean two = false; // second pack switched or not
		int two_num = 0; // counts till two numbers
		boolean thr = false; // third pack switched or not
		int thr_num = 0; // counts till two numbers
		while (sw != 7) { // until mask does not equal 7
			num = (int) (Math.random() * 10 / 1); // random numbers (1-9)
			if (num != 9) { // 9 is not a valid row number
				if ((num <= 2) && (one != true)) { // number <= 2, rows
													// unswitched
					if (one_num == 0) { // if no number was found yet
						one_num = num; // save first number
					} // and continue with randomizer
					else { // if there is already a number
						for (int j = 0; j < 9; j++) { // iterate over all
														// columns
							tmp = mtx[num][j]; // save value in variable
							mtx[num][j] = mtx[one_num][j]; // value of one row
															// to other
							mtx[one_num][j] = tmp; // insert variable into other
						} // end of column iteration
						sw += 1; // add last 1 to mask
						one = true; // first pack of three changed
						System.out.println("Rows changed: " + // for debugging
								num + " " + one_num); // show changed rows
					} // end of number-present-clause
				} // end of if-clause rows <= 2
				if ((num > 2) && (num < 6) && (two != true)) {// 2<number<6,
																// rows
																// unswitched
					if (two_num == 0) { // if no number was found yet
						two_num = num; // save first number
					} // and continue with randomizer
					else { // if there is already a number
						for (int j = 0; j < 9; j++) { // iterate over all
														// columns
							tmp = mtx[num][j]; // save value in variable
							mtx[num][j] = mtx[two_num][j]; // value of one row
															// to other
							mtx[two_num][j] = tmp; // insert variable into other
						} // end of column iteration
						sw += 2; // add 2 to mask
						two = true; // second pack of three changed
						System.out.println("Rows changed: " + // for debugging
								num + " " + two_num); // show changed rows
					} // end of number-present-clause
				} // end of if-clause rows <= 2
				if ((num >= 6) && (thr != true)) { // number >= 6, rows
													// unswitched
					if (thr_num == 0) { // if no number was found yet
						thr_num = num; // save first number
					} // and continue with randomizer
					else { // if there is already a number
						for (int j = 0; j < 9; j++) { // iterate over all
														// columns
							tmp = mtx[num][j]; // save value in variable
							mtx[num][j] = mtx[thr_num][j]; // value of one row
															// to other
							mtx[thr_num][j] = tmp; // insert variable into other
						} // end of column iteration
						sw += 4; // add 4 to mask
						thr = true; // third pack of three changed
						System.out.println("Rows changed: " + // for debugging
								num + " " + thr_num); // show changed rows
					} // end of number-present-clause
				} // end of if-clause rows <= 2
			} // end of not-equals-9-clause
		} // end of switches of the rows
			// ---------------------------------------- // change columns within
			// packs
		sw = 0; // to register column switches
		one = false; // first pack switched or not
		one_num = 0; // counts till two numbers
		two = false; // second pack switched or not
		two_num = 0; // counts till two numbers
		thr = false; // third pack switched or not
		thr_num = 0; // counts till two numbers
		while (sw != 7) { // until mask does not equal 7
			num = (int) (Math.random() * 10 / 1); // random numbers (1-9)
			if (num != 9) { // 9 is not a valid row number
				if ((num <= 2) && (one != true)) { // number<=2 columns
													// unswitched
					if (one_num == 0) { // if no number was found yet
						one_num = num; // save first number
					} // and continue with randomizer
					else { // if there is already a number
						for (int j = 0; j < 9; j++) { // iterate over all rows
							tmp = mtx[j][num]; // save value in variable
							mtx[j][num] = mtx[j][one_num]; // value of one
															// column to other
							mtx[j][one_num] = tmp; // insert variable into other
						} // end of row iteration
						sw += 1; // add last 1 to mask
						one = true; // first pack of three changed
						System.out.println("Cols changed: " + // for debugging
								num + " " + one_num); // show changed columns
					} // end of number-present-clause
				} // end of if-clause rows <= 2
				if ((num > 2) && (num < 6) && (two != true)) {// 2<num<6,
																// columns
																// unswitched
					if (two_num == 0) { // if no number was found yet
						two_num = num; // save first number
					} // and continue with randomizer
					else { // if there is already a number
						for (int j = 0; j < 9; j++) { // iterate over all rows
							tmp = mtx[j][num]; // save value in variable
							mtx[j][num] = mtx[j][two_num]; // value of one
															// column to other
							mtx[j][two_num] = tmp; // insert variable into other
						} // end of row iteration
						sw += 2; // add 2 to mask
						two = true; // second pack of three changed
						System.out.println("Cols changed: " + // for debugging
								num + " " + two_num); // show changed columns
					} // end of number-present-clause
				} // end of if-clause columns<=2
				if ((num >= 6) && (thr != true)) { // number>=6 columns
													// unswitched
					if (thr_num == 0) { // if no number was found yet
						thr_num = num; // save first number
					} // and continue with randomizer
					else { // if there is already a number
						for (int j = 0; j < 9; j++) { // iterate over all rows
							tmp = mtx[j][num]; // save value in variable
							mtx[j][num] = mtx[j][thr_num]; // value of one
															// column to other
							mtx[j][thr_num] = tmp; // insert variable into other
						} // end of row iteration
						sw += 4; // add 4 to mask
						thr = true; // third pack of three changed
						System.out.println("Cols changed: " + // for debugging
								num + " " + thr_num); // show changed columns
					} // end of number-present-clause
				} // end of if-clause columns<=2
			} // end of not-equals-9-clause
		} // end of switches in columns
		System.out.println("");
	} // constructor has finished

	public Sudoku(Sudoku s) { // Copy-Constructor
		mtx = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				mtx[i][j] = s.getAt(i, j);
			}
		}
	}

	public boolean isSolved() {// 0 = leeres Feld (wegen Integer)
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (mtx[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// ------------------------------------------ // print Sudoku on screen

	public String toString() { // method header
		StringBuilder str = new StringBuilder(); // String contains whole game
		for (int i = 0; i < 9; i++) { // iterate over all rows
			str.append("\n"); // linefeed to next row
			if ((i == 3) || (i == 6))
				str.append("\n"); // empty row all three rows
			for (int j = 0; j < 9; j++) { // iterate over all columns
				if ((j == 3) || (j == 6))
					str.append(" "); // empty column all three rows
				str.append(mtx[i][j]); // insert value of the matrix
				if (j != 8)
					str.append(" "); // no blank at end of row
			} // loop over columns finished
		} // loop over rows finished
		return str.toString(); // return String with Sudoku
	} // toString-method finished

	public int getAt(int x, int y) {
		return this.mtx[x][y];
	}

	public void setAt(int x, int y, int wert) {
		this.mtx[x][y] = wert;
	}

} // end of code