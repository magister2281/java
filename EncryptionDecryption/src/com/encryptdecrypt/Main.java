package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String [] argss = {"-mode", "dec", "-out", "D:\\newfolder\\Encryption-Decryption\\Encryption-Decryption\\task\\src\\encryptdecrypt\\road_to_treasure.txt", "-in", "D:\\newfolder\\Encryption-Decryption\\Encryption-Decryption\\task\\src\\encryptdecrypt\\protected.txt", "-key", "5", "-alg", "unicode"};
        Encryptor encryptor = new Encryptor();
        System.out.println(encryptor.interactionWithAllMethods(args));

    }
}




