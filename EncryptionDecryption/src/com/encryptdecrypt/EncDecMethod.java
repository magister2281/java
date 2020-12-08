package encryptdecrypt;

public interface EncDecMethod {
String  encryption(String value,String data);
String decryption(String value,String data);
String multiCryptFunc(String[] arguments,String data);
String multiCryptFunc(String[] args);
}
