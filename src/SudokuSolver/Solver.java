package SudokuSolver;

import java.util.ArrayList;

public abstract class Solver {

    public final void execute() {
        startTimer();
        findApplicableCells();
        applyChanges();
        stopTimer();
        //time.TotalTime(time.startTimer(), time.stopTimer());
        timeToComplete();
    }

    protected abstract void findApplicableCells();

    protected abstract int[][] applyChanges();

    protected abstract long timeToComplete();

    private boolean deleteValue(ArrayList<Integer> values, int number) {
        for (int value : values) {
            if (value != number) {
                return false;
            }
        }

        return true;
    }
    public long startTimer(){
        long startTime = System.nanoTime();
        return startTime;
    }

    public long stopTimer(){
        long stopTime = System.nanoTime();
        return stopTime;
    }


}