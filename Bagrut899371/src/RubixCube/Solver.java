package RubixCube;

public class Solver {

    private String name;
    private Time[] times;

    public Solver(String name, Time[] times) {
        this.name = name;
        this.setTimes(times);
    }

    public Time[] getTimes() {
        Time[] times = new Time[10];
        for (int i = 0; i < 10; i++) {
            times[i] = this.times[i].copy();
        }
        return times;
    }

    public static int[] championship(Solver[] solvers, Time timeToBeat){
        int[] results = new int[solvers.length];
        for (int i = 0; i < solvers.length; i++) {
            if(solvers[i].getShortestTime().shorter(timeToBeat)) results[i] = 1;
            else results[i] = 0;
        }
        return results;
    }

    public void setTimes(Time[] times) {
        this.times = new Time[10];
        for (int i = 0; i < 10; i++) {
            this.times[i] = times[i].copy();
        }
    }

    public Time getShortestTime(){
        Time shortest = times[0];
        for (int i = 0; i < times.length; i++) {
            if(times[i].shorter(shortest)) shortest = times[i];
        }
        return shortest.copy();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
