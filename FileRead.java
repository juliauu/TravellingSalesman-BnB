package branch_and_bound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead{
    private int[][] matrix;

    public FileRead(){
        matrix = null;
    }


    public int[][] getMatrix(){
        return matrix;
    }

    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    public void displayMatrix(){
        for (int i = 0; i < getMatrix().length; i++) {
            for (int j = 0; j < getMatrix().length; j++) {
                System.out.print(getMatrix()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void readFile(String fileName){
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int size = scanner.nextInt();
            setMatrix(new int[size][size]);

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    getMatrix()[i][j] = scanner.nextInt();
                }

                if (i == size - 1) break;
                else scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Plik nie istnieje");
        }

    }
}
