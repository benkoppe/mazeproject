package com.csc345;

import com.csc345.core.Maze;
import com.csc345.core.Node;
import com.csc345.core.maze_algorithms.MazeAlgorithmType;
import com.csc345.core.maze_algorithms.MazeAlgorithm;
import com.csc345.core.solve_algorithms.SolveAlgorithmType;
import com.csc345.core.solve_algorithms.SolveAlgorithm;
import com.csc345.data.List;
import com.csc345.data.types.RowCol;

/**
 * Main class for the program's command line testing output.
 */
public class Main {
    /**
     * Main method for the program. 
     * Example programmatic maze creation and solving.
     * 
     * NOTE: This is not the main method for the JavaFX application! 
     * Users should run through that entry point instead, see README.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // example programmatic maze creation and solving
        
        RowCol mazeSize = new RowCol(10, 10);
        Node[] nodes = Maze.createNodes(mazeSize.getRow(), mazeSize.getCol());
        
        Maze.printMaze(nodes, mazeSize.getCol());

        MazeAlgorithm backtracking = MazeAlgorithmType.BACKTRACKING.getAlgorithm(nodes);
        backtracking.finishImmediately();

        Maze.printMaze(nodes, mazeSize.getCol());

        SolveAlgorithm aStar = SolveAlgorithmType.ASTAR.getAlgorithm(nodes, 0, nodes.length - 1, Maze.createHeuristic(mazeSize.getCol()));

        aStar.finishImmediately();

        List<Integer> path = aStar.getPath();
        
        Maze.printMazeSolution(path, nodes, mazeSize.getCol());

    }
}
