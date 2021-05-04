package recursion;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Recursion {

    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        if(Recursion.map.containsKey(n)){
            return Recursion.map.get(n);
        }
        if(n == 1){
            return 1;
        }
        
        if(n == 2){
            return 2;
        }
        
        if(n == 3){
            return 4;
        }
        
        
        int result =  Recursion.stepPerms(n-1) + Recursion.stepPerms(n-2) + Recursion.stepPerms(n-3);
        Recursion.map.put(n, result);
        return result;

    }
    
    // static int stepPerms2(int m, int n) {
        
    //     if(m-n == 1){
    //         return 1;
    //     }
        
    //     if(m-n == 2){
    //         return 2;
    //     }
        
    //     if(m-n == 2){
    //         return 2;
    //     }
    //     return Solution.stepPerms(m-n);

    // }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
