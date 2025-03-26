package branch_and_bound;

public class Main {
    public static void main(String[] args){
        //Menu.displayMenu();
        branch_and_bound.FileRead fileReader = new FileRead();
        fileReader.readFile("branch_and_bound/matrix_8x8.txt");
        fileReader.displayMatrix();
        BB bb = new BB(fileReader.getMatrix());
        long begin = System.currentTimeMillis();
        bb.solve();
        long end = System.currentTimeMillis();
        long time = end - begin;

        System.out.println("czas: " + time + " ms");

        bb.displaySolution();
    }
}


