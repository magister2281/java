package encryptdecrypt;

abstract class Exceptions {
    public static String indexOutOfBoundsException(int i, String[] args) {
        String result = "";
        try {
            result = args[i + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return result;
        }
        return result;
    }

    public static String parseIntException(String str) {
        try {
            Integer.parseInt(str);
            return str;
        } catch (NumberFormatException e) {
            return "0";
        }
    }
}
