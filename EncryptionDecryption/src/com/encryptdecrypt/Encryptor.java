package encryptdecrypt;

public class Encryptor extends Exceptions {
    private static final String UNICODE = "unicode";

    public String interactionWithAllMethods(String[] arguments) {
        String[] args = readFromCommandLine(arguments);
        BaseMethods baseMethods = MachinesFactory.newInstance(args[5], args);
            if (inOut(args) && !dataIn(args)) {
                return baseMethods.writeFile(args[4], baseMethods.multiCryptFunc(args, baseMethods.readFile(args[3])));
            } else if (dataIn(args) && out(args)) {
                return baseMethods.writeFile(args[4], baseMethods.multiCryptFunc(args, baseMethods.readFile(args[2])));
            } else if (dataIn(args) && !out(args)) {
                return baseMethods.multiCryptFunc(args);
            } else if ((!dataIn(args)) && out(args)) {
                return baseMethods.writeFile(args[4], baseMethods.multiCryptFunc(args));
            } else if (!(dataIn(args) && out(args))) {
                return baseMethods.multiCryptFunc(args);
            }
        return "Something went wrong";
    }

    private static String[] readFromCommandLine(String[] args) {
        String[] commands = {"enc", "0", "", "", "", "shift"};
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    if (indexOutOfBoundsException(i, args).equals("dec")) {
                        commands[0] = "dec";
                    }
                    break;
                case "-key":
                    commands[1] = parseIntException(indexOutOfBoundsException(i, args));
                    break;
                case "-data":
                    commands[2] = indexOutOfBoundsException(i, args);
                    break;
                case "-in":
                    commands[3] = indexOutOfBoundsException(i, args);
                    break;
                case "-out":
                    commands[4] = indexOutOfBoundsException(i, args);
                    break;
                case "-alg":
                    if (indexOutOfBoundsException(i, args).equals(UNICODE)) {
                        commands[5] = UNICODE;
                    }
                    break;
                default:
                    break;
            }
        }
        return commands;
    }

    private static boolean inOut(String[] commands) {
        return commands[3].length() > 0 && commands[4].length() > 0;
    }

    private boolean dataIn(String[] commands) {
        return commands[2].length() > 0 && commands[3].length() > 0;
    }

    private boolean out(String[] commands) {
        return commands[4].length() > 0;
    }
}
