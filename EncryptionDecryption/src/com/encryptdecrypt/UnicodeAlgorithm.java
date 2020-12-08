package encryptdecrypt;

public class UnicodeAlgorithm extends BaseMethods {
    public UnicodeAlgorithm(String[] arguments) {
        super(arguments);
    }

    @Override
    public String encryption(String value, String data) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            result.append((char) (data.charAt(i) + (Integer.parseInt(value))));
        }
        return result.toString();
    }

    @Override
    public String decryption(String value, String data) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            result.append((char) (data.charAt(i) - (Integer.parseInt(value))));
        }
        return result.toString();
    }

    public String multiCryptFunc(String[] arguments, String data) {
        BaseMethods baseMethods = MachinesFactory.newInstance(arguments[5], arguments);
        if (arguments[0].equals("dec")) {
            return baseMethods.decryption(arguments[1], data);
        }
        return baseMethods.encryption(arguments[1], data);
    }

    public String multiCryptFunc(String[] arguments) {
        BaseMethods baseMethods = MachinesFactory.newInstance(arguments[5], arguments);
        if (arguments[0].equals("dec")) {
            return baseMethods.decryption(arguments[1], arguments[2]);
        }
        return baseMethods.encryption(arguments[1], arguments[2]);
    }
}
