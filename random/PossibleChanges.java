package random;

import java.util.List;
import java.util.stream.Collectors;

class PossibleChanges {
 /*
* Complete the 'possibleChanges' function below.
*
* The function is expected to return a STRING_ARRAY.
* The function accepts STRING_ARRAY usernames as parameter.
*/

    public static List<String> possibleChanges(List<String> usernames) {
        // Write your code here 
          return  usernames.stream().map(username->canSwap(username)? "YES": "NO").collect(Collectors.toList());
        }
        
        private static boolean canSwap(String s) {
            for(int i = 0; i< s.length();i++){
                char current =s.charAt(i);
                for(int j = i; j<s.length(); j++ ){
                   char next = s.charAt(j);
                   if(next-current<0){
                       return true;
                   }
                }
            }
            return false;
        }
}
