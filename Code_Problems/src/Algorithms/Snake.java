package Algorithms;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	
	static ArrayList<ArrayList<Integer>> snakes = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> snake;
	
	public static void findSnakes(int[][] grid) {
		snakes = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < grid.length; i++) {
			
			for(int j = 0; j < grid[i].length; j++) {
				snake  = new ArrayList<Integer>();
				
				snake.add(grid[i][j]);
				continueSnakeR(grid, i, j);
				snake = new ArrayList<Integer>();
				
				snake.add(grid[i][j]);
				continueSnakeB(grid, i, j);
			}
		}
		
		Iterator<ArrayList<Integer>> i = snakes.iterator();
		int max = 0;
		int count = 0;
		ArrayList<ArrayList<Integer>> allSnakes = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> longest = new ArrayList<Integer>();
		
		while(i.hasNext()) {
			ArrayList<Integer> temp = i.next();
			
			if(!allSnakes.contains(temp)) {
				allSnakes.add(temp);
			}
			if(temp.size() > max) {
				longest = temp;
				max = temp.size();
			}
		}
		
		System.out.println("All applicable snakes: "+ allSnakes.toString());
		System.out.println("Longest snake sequence has a length of "+ max + " and was the first to be found: "+ longest.toString() + ".");
	}


	public static void continueSnakeR(int[][] grid, int row, int col) {
		
		if(col == grid[row].length-1 && row+1 == grid.length-1) {
			if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
				
				snake.add(grid[row+1][col]);
			
				snakes.add(snake);
			}
			
		} else if(row == grid.length-1 && col+1 == grid[row].length-1) {
			if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
				
				snake.add(grid[row][col+1]);
				snakes.add(snake);
			}
			
		} else if(row == grid.length-1 && col == grid[row].length-1) {
			snakes.add(snake);
			
		} else if(col+1 != grid[row].length && row+1 != grid.length) {
			if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
			
				snake.add(grid[row][col+1]);
			
				continueSnakeR(grid, row, col+1);
			} else if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
			
				snake.add(grid[row+1][col]);
			
				continueSnakeR(grid, row+1, col);
			} else {
				snakes.add(snake);
			}
		} else {
			snakes.add(snake);
		}	
	}
	
	public static void continueSnakeB(int[][] grid, int row, int col) {
		
		
		if(row == grid.length-1 && col+1 == grid[row].length-1) {
			if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
				
				snake.add(grid[row][col+1]);
				snakes.add(snake);
			} else {
				snakes.add(snake);
			}
			
		} else if(col == grid[row].length-1 && row+1 == grid.length-1) {
			if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
				
				snake.add(grid[row+1][col]);
			
				snakes.add(snake);
			} else {
				snakes.add(snake);
			}
			
		} else if(row == grid.length-1 && col == grid[row].length-1) {
			snakes.add(snake);
			
		}  else if(row+1 != grid.length && col+1 < grid[row].length) {
			if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
			
				snake.add(grid[row+1][col]);
			
				continueSnakeB(grid, row+1, col);
			} else if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
			
				snake.add(grid[row][col+1]);
			
				continueSnakeB(grid, row, col+1);
			} else {
				snakes.add(snake);
			}
			
		} else {
			snakes.add(snake);
		}	
	}

	
	
	//////////////////////////
	
	/*public static void continueSnakeR(int[][] grid, int row, int col) {
		
		if(col == grid[row].length-1 && row+1 == grid.length-1) {
			if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
				
				snake.add(grid[row+1][col]);
			
				snakes.add(snake);
			}
			
		} else if(row == grid.length-1 && col+1 == grid[row].length-1) {
			if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
				
				snake.add(grid[row][col+1]);
				snakes.add(snake);
			}
			
		} else if(row == grid.length-1 && col == grid[row].length-1) {
			//snake.add(grid[row][col]);
			snakes.add(snake);
			
		} else if(col+1 != grid[row].length && row+1 != grid.length) {
			if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
			
				snake.add(grid[row][col+1]);
			
				continueSnakeRT(grid, row, col+1);
			} else if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
			
				snake.add(grid[row+1][col]);
			
				continueSnakeRT(grid, row+1, col);
			} else {
				snakes.add(snake);
			}
		} else if(row+1 != grid.length && col+1 != grid[row].length) {
			if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
			
				snake.add(grid[row+1][col]);
			
				continueSnakeRT(grid, row+1, col);
			} else if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
			
				snake.add(grid[row][col+1]);
			
				continueSnakeRT(grid, row, col+1);
			} else {
				snakes.add(snake);
			}
			
		} 	else {
			snakes.add(snake);
		}	
	}
	
	public static void continueSnakeB(int[][] grid, int row, int col) {
		
		
		if(row == grid.length-1 && col+1 == grid[row].length-1) {
			if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
				
				snake.add(grid[row][col+1]);
				snakes.add(snake);
			} else {
				snakes.add(snake);
			}
			
		} else if(col == grid[row].length-1 && row+1 == grid.length-1) {
			if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
				
				snake.add(grid[row+1][col]);
			
				snakes.add(snake);
			} else {
				snakes.add(snake);
			}
			
		} else if(row == grid.length-1 && col == grid[row].length-1) {
			//snake.add(grid[row][col]);
			snakes.add(snake);
			
		}  else if(row+1 != grid.length && col+1 < grid[row].length) {
			if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
			
				snake.add(grid[row+1][col]);
			
				continueSnakeBT(grid, row+1, col);
			} else if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
			
				snake.add(grid[row][col+1]);
			
				continueSnakeBT(grid, row, col+1);
			} else {
				snakes.add(snake);
			}
			
		} else if(col+1 != grid[row].length && row+1 != grid.length) {
			if(grid[row][col+1] == grid[row][col] - 1 || grid[row][col+1] == grid[row][col] + 1) {
			
				snake.add(grid[row][col+1]);
			
				continueSnakeBT(grid, row, col+1);
			} else if(grid[row+1][col] == grid[row][col] - 1 || grid[row+1][col] == grid[row][col] + 1) {
			
				snake.add(grid[row+1][col]);
			
				continueSnakeBT(grid, row+1, col);
			} else {
				snakes.add(snake);
			}
		} else {
			snakes.add(snake);
		}	
	}*/
	
	
	
	public static void main(String[] args) {
		int[][] snakeTest = { // 1, 2, 1, 0 | 1, 2, 3, 4, 3, 4, 3 | 
				{1, 2, 3, 5},
				{3, 1, 4, 2},
				{5, 0, 3, 5},
				{1, 4, 4, 3}
		};
		
		int[][] snakeTest1 = {
				{2, 5, 2, 2, 0, 1},
				{0, 4, 8, 1, 5, 7},
				{2, 5, 9, 5, 8, 7},
				{7, 1, 4, 4, 4, 2},
				{9, 2, 4, 2, 8, 7},
				{3, 2, 7, 7, 7, 8},
		};
		
		
		int[][] snakeTest2 = {
			{5, 7, 5, 3, 4, 4, 5, 4, 1},
			{0, 8, 8, 7, 6, 0, 9, 2, 4},
			{1, 8, 6, 8, 0, 1, 8, 0, 4},
			{7, 5, 7, 8, 7, 9, 9, 2, 4},
			{6, 4, 8, 4, 4, 7, 8, 1, 5},
			{3, 1, 5, 4, 1, 3, 0, 7, 8},
			{7, 5, 0, 3, 7, 5, 0, 7, 3},
			{8, 7, 1, 2, 0, 7, 9, 6, 5},
			{7, 0, 7, 4, 1, 4, 9, 2, 2}
		};
		
		
		findSnakes(snakeTest);
		findSnakes(snakeTest1);
		findSnakes(snakeTest2);
		
		
		/*
		 * All applicable snakes: [[1, 2, 3, 4, 3, 4, 3], [1, 2, 1, 0], [2, 3, 4, 3, 4, 3], [2, 1, 0], [3, 4, 3, 4, 3], [5], [3], [1, 0], [4, 3, 4, 3], [2], [0], [3, 4, 3], [1], [4], [4, 3]]
			Longest snake sequence has a length of 7 and looks like: [1, 2, 3, 4, 3, 4, 3]
			All applicable snakes: [[2], [5, 4, 5], [2, 1], [0, 1], [1], [0], [4, 5], [8, 9], [5], [7], [9], [5, 4], [8, 7], [1, 2], [4], [8, 7, 8], [7, 8], [3], [8]]
			Longest snake sequence has a length of 3 and looks like: [5, 4, 5]
			All applicable snakes: [[5], [7, 8], [3, 4], [4], [4, 5, 4], [5, 4], [1], [0, 1], [8], [8, 7, 6], [8, 7, 8], [7, 6], [6], [9, 8, 9, 8], [2], [6, 7, 8, 7], [6, 7, 8], [8, 9, 8], [0], [7, 8, 7], [8, 7], [7], [9], [9, 8], [2, 1], [3], [5, 4, 3, 2], [4, 3, 2], [0, 1, 2], [3, 2], [7, 6, 5], [1, 2], [6, 5]]
			Longest snake sequence has a length of 4 and looks like: [9, 8, 9, 8]
			
			All applicable snakes: [[1, 2, 3, 4, 3, 4, 3], [1, 2, 1, 0], [2, 3, 4, 3, 4, 3], [2, 1, 0], [3, 4, 3, 4, 3], [5], [3], [1, 0], [4, 3, 4, 3], [2], [0], [3, 4, 3], [1], [4], [4, 3]]
			Longest snake sequence has a length of 7 and looks like: [1, 2, 3, 4, 3, 4, 3]
			All applicable snakes: [[2], [5, 4, 5], [2, 1], [0, 1], [1], [0], [4, 5], [8, 9], [5], [7], [9], [5, 4], [8, 7], [1, 2], [4], [8, 7, 8], [7, 8], [3], [8]]
			Longest snake sequence has a length of 3 and looks like: [5, 4, 5]
			All applicable snakes: [[5], [7, 8], [3, 4], [4], [4, 5, 4], [5, 4], [1], [0, 1], [8], [8, 7, 6], [8, 7, 8], [7, 6], [6], [9, 8, 9, 8], [2], [6, 7, 8, 7], [6, 7, 8], [8, 9, 8], [0], [7, 8, 7], [8, 7], [7], [9], [9, 8], [2, 1], [3], [5, 4, 3, 2], [4, 3, 2], [0, 1, 2], [3, 2], [7, 6, 5], [1, 2], [6, 5]]
			Longest snake sequence has a length of 4 and looks like: [9, 8, 9, 8]

		 */
		
	}

}
