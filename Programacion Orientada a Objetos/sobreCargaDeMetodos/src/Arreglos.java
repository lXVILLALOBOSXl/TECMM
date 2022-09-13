public class Arreglos<E> {
    private Object[][] array;
    public int rows;
    public int columns;

    public Arreglos() {
        this.array = new Object[0][0];
        this.rows = 0;
    }

    public Arreglos(int size) {
        this.array = new Object[1][size];
        this.rows = 1;
        this.columns = size;
    }

    public Arreglos(int rows, int columns) {
        this.array = new Object[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public String print(){
        String matrix = "{";
        for (int x = 0; x < this.rows; x++){

            if(x > 0){
                matrix+= "\n{";
            }

            for (int y = 0;  y < this.columns; y++) {
                if (y != (this.columns - 1)) {
                    matrix +=  (this.array[x][y] + ", ");
                }else {
                    matrix += (this.array[x][y].toString());
                }
            }
            matrix +=  "}";
        }
        return matrix;
    }

    public void insert(int index, Object value){
        this.array[0][index] = value;
    }

    public void insert(int row, int column, Object value){
        this.array[row][column] = value;
    }

    public Object get(int row, int column){
        return this.array[row][column];
    }

    public int sum(){
        int sum = 0;
        for (int x = 0; x < this.rows; x++){
            for (int y = 0;  y < this.columns; y++) {
                sum += (int)this.array[x][y];
            }
        }
        return sum;
    }

    public static Arreglos sum(Arreglos arrayA, Arreglos arrayB){
        Arreglos sum = new Arreglos(arrayA.rows, arrayB.columns);
        for (int x = 0; x < arrayA.rows; x++){
            for (int y = 0;  y < arrayA.columns; y++) {
                sum.insert (x,y,(int)arrayA.get(x,y) + (int)arrayB.get(x,y));
            }
        }
        return sum;
    }

    public static Arreglos sub(Arreglos arrayA, Arreglos arrayB){
        Arreglos sum = new Arreglos(arrayA.rows, arrayB.columns);
        for (int x = 0; x < arrayA.rows; x++){
            for (int y = 0;  y < arrayA.columns; y++) {
                sum.insert (x,y,(int)arrayA.get(x,y) - (int)arrayB.get(x,y));
            }
        }
        return sum;
    }

    public static int sum(int[] array){
        int sum = 0;
        for (int y = 0;  y < array.length; y++) {
            sum += array[y];
        }
        return sum;
    }

    public static int sum(int[][] array){
        int sum = 0;
        for (int x = 0; x < array.length; x++){
            for (int y = 0;  y < array[0].length; y++) {
                sum += array[x][y];
            }
        }
        return sum;
    }

    public static int[][] sum(int[][] arrayA, int[][] arrayB){
        int[][] sum = new int[arrayA.length][arrayA[0].length];
        for (int x = 0; x < arrayA.length; x++){
            for (int y = 0;  y < arrayA[0].length; y++) {
                sum[x][y] = arrayA[x][y] + arrayB[x][y];
            }
        }
        return sum;
    }

    public static int[][] sub(int[][] arrayA, int[][] arrayB){
        int[][] sum = new int[arrayA.length][arrayA[0].length];
        for (int x = 0; x < arrayA.length; x++){
            for (int y = 0;  y < arrayA[0].length; y++) {
                sum[x][y] = arrayA[x][y] - arrayB[x][y];
            }
        }
        return sum;
    }

    public int sumY(int column){
        int sum = 0;
        for (int x = 0; x < this.rows; x++){
            sum += (int)this.array[x][column];
        }
        return sum;
    }

    public int sumX(int row){
        int sum = 0;
        for (int y = 0; y < this.columns; y++){
            sum += (int)this.array[row][y];
        }
        return sum;
    }

    public static int sum(int column, int[][] matrix){
        int sum = 0;
        for (int x = 0; x < matrix.length; x++){
            sum += matrix[x][column];
        }
        return sum;
    }

    public static int sum(int[][] matrix, int row){
        int sum = 0;
        for (int y = 0; y < matrix[0].length; y++){
            sum += matrix[row][y];
        }
        return sum;
    }


}
