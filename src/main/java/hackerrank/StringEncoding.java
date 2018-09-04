package hackerrank;

/**
 * Created by Peeyush on 6/11/2017.
 */
public class StringEncoding {

    public static void main(String[] args) {
        System.out.println(collapseString("GGGGGGrrrrrrrrrrrrrrrt"));
        System.out.println(collapseString("t"));
    }

    static String collapseString(String input) {

        String result = "";
        int temp=1;
        for(int i=0;i<input.length();){
            char x = input.charAt(i);
            int j=i+1;
            while(j<input.length()&&x==input.charAt(j)){
                temp++;
                j++;
            }
            result+=temp+""+input.charAt(j-1);
            temp=1;
            i=j;
        }
        return result;
    }
}
