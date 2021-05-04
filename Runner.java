import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Runner {

    /*
     * Complete the 'itemsSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY items as parameter.
     */

    public static int fourthBit(int number) {
        String str = Integer.toBinaryString(number);
        try{
            System.out.println(str);
            if(str.length() < 4){
                return 0;
            }
            System.out.println(str.charAt(str.length() - 4)+"");

           return Integer.parseInt(str.charAt(str.length() - 4)+"");

        }catch(Exception e){
            return 0;
        }
  
      }
    public static void main(String[] args) {
        Runner.fourthBit(90998);

    }
}