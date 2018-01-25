package string;

public class StringMultiply {

    public static String multiply(String first, String second) {
        first  = reverse(first);
        second = reverse(second);

        int result[] = new int[first.length() + second.length()];

        int  intAtFirst, intAtSecond;
        //multiply each digit and do a summation at the corresponding index
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                intAtFirst  = Character.getNumericValue(first.charAt(i));
                intAtSecond = Character.getNumericValue(second.charAt(j));
                // record the results at the index location offset by i's current index in summation manner
                result[i+j] = result[i+j] + intAtFirst * intAtSecond;
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for (int i = 0; i < result.length; i++) {
            int mod = result[i]%10;
            int carry = result[i]/10;
            if(i+1 < result.length){
                result[i+1] = result[i+1] + carry;
            }
            sb.insert(0, mod);
        }

        //remove all front 0's if any
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","25"));
    }
}
