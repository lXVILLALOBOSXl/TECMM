import java.util.Arrays;

public class Arreglos {

    private int[][] array;

    /**
     * Initializes an empty matrix
     */
    public Arreglos() {
        this.array = new int[0][0];
    }

    /**
     * Initializes a vector
     * @param size
     */
    public Arreglos(int size) {
        this.array = new int[1][size];
        this.fillArray();
    }

    /**
     * Initializes a matrix
     * @param rows
     * @param columns
     */
    public Arreglos(int rows, int columns) {
        this.array = new int[rows][columns];
        this.fillArray();
    }

    /**
     * assigns values to all instance positions that has called it
     */
    private void fillArray(){
        if(this.array.length > 1){
            for (int y = 0; y < this.array[0].length; y++){
                for (int x = 0;  x < this.array.length; x++) {
                    this.insert(x, y, Util.getNumber("Position [" + x + "][" + y + "] "));
                }
            }
            return;
        }
        for (int i = 0; i < this.array[0].length; i++){
            this.insert(i, Util.getNumber("Position [" + i + "]"));
        }
    }

    /**
     * assigns value an instance position vector that has called it
     * @param index
     * @param value
     */
    private void insert(int index, int value){
        this.array[0][index] = value;
    }

    /**
     * assigns value an instance position matrix that has called it
     * @param row
     * @param column
     * @param value
     */
    private void insert(int row, int column, int value){
        this.array[row][column] = value;
    }

    /**
     * sums vector contents
     * @param array
     * @return sum
     */
    public static int sum(int[] array){
        int sum = 0;
        for (int y = 0;  y < array.length; y++) {
            sum += array[y];
        }
        return sum;
    }

    /**
     * sums matrix contents
     * @param array
     * @return sum
     */
    public static int sum(int[][] array){
        int sum = 0;
        for (int x = 0; x < array.length; x++){
            for (int y = 0;  y < array[0].length; y++) {
                sum += array[x][y];
            }
        }
        return sum;
    }

    /**
     * Sums 2 arrays
     * @param arrayA
     * @param arrayB
     * @return sum
     */
    public static int[][] sum(int[][] arrayA, int[][] arrayB){
        int[][] sum = new int[arrayA.length][arrayA[0].length];
        for (int x = 0; x < arrayA.length; x++){
            for (int y = 0;  y < arrayA[0].length; y++) {
                sum[x][y] = arrayA[x][y] + arrayB[x][y];
            }
        }
        return sum;
    }

    /**
     * Subs 2 arrays
     * @param arrayA
     * @param arrayB
     * @return sub
     */
    public static int[][] sub(int[][] arrayA, int[][] arrayB){
        int[][] sum = new int[arrayA.length][arrayA[0].length];
        for (int x = 0; x < arrayA.length; x++){
            for (int y = 0;  y < arrayA[0].length; y++) {
                sum[x][y] = arrayA[x][y] - arrayB[x][y];
            }
        }
        return sum;
    }

    /**
     * Sums specific column values
     * @param column
     * @param matrix
     * @return sum
     */
    public static int sum(int column, int[][] matrix){
        int sum = 0;
        for (int x = 0; x < matrix.length; x++){
            sum += matrix[x][column];
        }
        return sum;
    }

    /**
     * Sums specific row values
     * @param matrix
     * @param row
     * @return sum
     */
    public static int sum(int[][] matrix, int row){
        int sum = 0;
        for (int y = 0; y < matrix[0].length; y++){
            sum += matrix[row][y];
        }
        return sum;
    }

    public int[][] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return this.print();
    }

    /**
     * Prints instance that has called it
     * @return
     */
    private String print(){
        String array = "{";
        for (int x = 0; x < this.array.length; x++){
            if(x > 0){
                array+= "\n{";
            }
            for (int y = 0;  y < this.array[0].length; y++) {
                if (y != (this.array[0].length - 1)) {
                    array +=  (this.array[x][y] + ", ");
                }else {
                    array += (this.array[x][y]);
                }
            }
            array +=  "}";
        }
        return array;
    }
}
