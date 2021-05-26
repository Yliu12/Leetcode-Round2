package random;

class Result {

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
        Result.fourthBit(90998);

    }
}