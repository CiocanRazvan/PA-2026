public class Matrix2D {
    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Specifica doua argumente: <n> <type> ");
            return;
        }

        long start = System.nanoTime();

        int n = Integer.parseInt(args[0]);
        String shape = args[1];

        System.out.println("Am primit de la linia de comanda: " +n);

        int[][] matrix = new int[n][n];

        if(n < 50) {

            if(shape.equalsIgnoreCase("rectangle") && n>7) {
                createrectangle(matrix);
            }
            else if(shape.equalsIgnoreCase("circle") && n>4){
                createcircle(matrix);
            }
            else{
                System.out.println("Incorrect shape or n too small!");
                return;
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 255) {
                        System.out.print(matrix[i][j] + " ");
                    } else if (matrix[i][j] == 0) {
                        System.out.print(" " + matrix[i][j] + "  ");
                    }
                }
                System.out.println();
            }

            String output = createUnicode(matrix);

            System.out.println(output);


        }else {

            long end = System.nanoTime();

            System.out.println("Timp: " + (end - start) + "ns");

            //am intalnit OutOfMemoryError? cand am dat valoarea pentru n=35000
        }

    }

    static void createrectangle(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = 255;
            }
        }

        int mijloc = m.length/4;
        int mijloc2 = m.length/8;

        if(m.length == 3){
            mijloc = 1;
        }
        for(int i = mijloc; i < m.length - mijloc; i++){
            for(int j = mijloc2; j < m.length - mijloc2 ; j ++){
                m[i][j] = 0;
            }
        }
    }

    static void createcircle(int[][] m){
        int n = m.length;
        int raza = n/4;

        int x_c = (n-1)/2;
        int y_c = (n-1)/2;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                m[i][j]=0;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int f = (i - x_c)*(i - x_c) + (j - y_c)*(j - y_c);
                if(f <= raza*raza){
                    m[i][j]=255;
                }
            }
        }
    }

    static String createUnicode(int[][] m){
        int n = m.length;
        String s = "";

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(m[i][j] == 0){
                    s += "\u2600 ";
                }
                else if(m[i][j]==255){
                    s += "\u2610 ";
                }
            }
            s += "\n";
        }
        return s;
    }
}