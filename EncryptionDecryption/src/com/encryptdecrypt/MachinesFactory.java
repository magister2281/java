package encryptdecrypt;

public class MachinesFactory {
    public static BaseMethods  newInstance(String type, String[] args) {
        if ("unicode".equals(type)) {
            return new UnicodeAlgorithm(args);
        }
        return new ShiftAlgorithm(args);
    }
}
