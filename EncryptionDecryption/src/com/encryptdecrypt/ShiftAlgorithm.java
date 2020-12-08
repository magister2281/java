package encryptdecrypt;

public class ShiftAlgorithm extends BaseMethods {


    public ShiftAlgorithm(String[] arguments) {
        super(arguments);
    }


    public String encryption(String value, String data) {
        StringBuilder result = new StringBuilder();
        int key = Integer.parseInt(value);
        for (int i = 0; i < data.length(); i++) {
            int letter = data.charAt(i);
            if ((letter >= 97 && letter <= 122)) {
                int index = letter + key;
                if (index > 122) {
                    index = index - 122;
                    result.append((char) (97 + (index - 1)));
                } else {
                    result.append((char) index);
                }
            } else if ((letter >= 65 && letter <= 90)) {
                int index = letter + key;
                if (index > 90) {
                    index = index - 90;
                    result.append((char) (65 + (index - 1)));
                } else {
                    result.append((char) index);
                }
            } else {
                result.append((char) letter);
            }
        }
        return result.toString();
    }

    @Override
    public String decryption(String value, String data) {
        StringBuilder result = new StringBuilder();
        int key = Integer.parseInt(value);
        for (int i = 0; i < data.length(); i++) {
            int letter = data.charAt(i);
            if ((letter >= 97 && letter <= 122)) {
                int index = letter - key;
                if (index < 97) {
                    index = index - 97;
                    result.append((char) (122 - (Math.abs(index) - 1)));
                } else {
                    result.append((char) index);
                }
            } else if ((letter >= 65 && letter <= 90)) {
                int index = letter - key;
                if (index < 65) {
                    index = index - 65;
                    result.append((char) (90 - (Math.abs(index) - 1)));
                } else {
                    result.append((char) index);
                }
            } else {
                result.append((char) letter);
            }
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
