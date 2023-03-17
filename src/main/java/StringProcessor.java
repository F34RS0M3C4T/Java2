public class StringProcessor {
    public static String multiply(String string, int n) throws Exception {
        if (string == null){
            throw new Exception("Can't multiply null string");
        }

        if (n < 0) {
            throw new Exception("Can't multiply string negative times");
        }

        StringBuilder sb = new StringBuilder(string);
        for(int i = 0; i < n - 1; i++){
            sb.append(string);
        }

        return sb.toString();
    }

    public static int subs(String string1, String string2) throws Exception{
        if(string1 == null || string2 == null) {
            throw new Exception("String can't be null");
        }

        int counter = 0;
        for(int i = 0; i + string2.length() <= string1.length(); ++i){
            if(string1.substring(i, i + string2.length()).contains(string2)){
                counter++;
            }
        }

        return counter;
    }

    public static String toNumbers(String string)throws Exception{
        if(string == null) {
            throw new Exception("String can't be null");
        }

        String[] strFormatArr = {"one", "two", "three"};
        char[] intFormatArr = {'1', '2', '3'};

        StringBuilder sb = new StringBuilder(string);
        for(int i = 0; i < sb.length(); i++){
            if (Character.isDigit(sb.charAt(i))) {
                String strNumberFormat = strFormatArr[Integer.parseInt(String.valueOf(sb.charAt(i))) - 1];

                sb.deleteCharAt(i);
                sb.insert(i, strNumberFormat);
            }
//            switch (sb.charAt(i)){
//                case '1': {
//                    sb.deleteCharAt(i);
//                    sb.insert(i,"one");
//                    break;
//                }
//                case '2': {
//                    sb.deleteCharAt(i);
//                    sb.insert(i,"two");
//                    break;
//                }
//                case '3': {
//                    sb.deleteCharAt(i);
//                    sb.insert(i,"three");
//                    break;
//                }
//            }
        }

        return sb.toString();
    }

    public static String delete(StringBuilder sb) throws Exception{
        if (sb == null) {
            throw new Exception("String Builder can't be null");
        }

        StringBuilder sbTemp = new StringBuilder(sb);

        for (int i = 1; i < sb.length() / 2 + 1; i ++){
            sbTemp.deleteCharAt(i);
        }

        return sbTemp.toString();
    }
}
