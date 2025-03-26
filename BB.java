package branch_and_bound;

import java.util.ArrayList;
import java.util.List;

public class BB{
    private int cost;
    private int[][] matrix;
    private int numOfCities;
    private List<Integer> path;

    public int[][] getMatrix(){
        return matrix;
    }


    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }


    public int getNumOfCities(){
        return numOfCities;
    }


    public void setNumOfCities(int numOfCities){
        this.numOfCities = numOfCities;
    }


    public int getCost(){
        return cost;
    }


    public void setCost(int cost){
        this.cost = cost;
    }


    public List<Integer> getPath(){
        return path;
    }


    public void setPath(List<Integer> path){
        this.path = path;
    }

    public BB(int[][] matrix) {
        setMatrix(matrix);
        setNumOfCities(matrix.length);
        setCost(Integer.MAX_VALUE);
        setPath(new ArrayList<>());
    }


    public void solve() {
        List<Integer> initialTour = new ArrayList<>();
        for (int i = 0; i < getNumOfCities(); i++) {
            initialTour.add(i);
        }

        cost = Integer.MAX_VALUE;
        path = new ArrayList<>();

        branchAndBound(initialTour, 1, 0);

        path.add(path.get(0));

    }

    private void branchAndBound(List<Integer> tour, int level, int costSoFar) {
        if (level == numOfCities) {
            int pcost = costSoFar + matrix[tour.get(level - 1)][tour.get(0)];
            if (pcost < cost) {
                cost = pcost;
                path = new ArrayList<>(tour);
            }
        } else {
            for (int i = level; i < numOfCities; i++) {
                swap(tour, level, i);
                int newCost = costSoFar + matrix[tour.get(level - 1)][tour.get(level)];
                if (newCost < cost) {
                    branchAndBound(tour, level + 1, newCost);
                }
                swap(tour, level, i);
            }
        }
    }

    public void displaySolution() {
        System.out.println(this);
    }

    private void swap(List<Integer> tour, int i, int j) {
        int temp = tour.get(i);
        tour.set(i, tour.get(j));
        tour.set(j, temp);
    }
    @Override
    public String toString() {
        return "dlugosc sciezki = " + cost + "\nciag wierzcholkow: " + path;
    }
}
