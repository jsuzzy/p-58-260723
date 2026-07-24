package util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {

    private static PrintStream ORIGINAL_OUT = System.out;
    private static PrintStream CURRENT_OUT = System.out; //현재 스트림 관리

    public static Scanner genScanner(String input) {
        return new Scanner(input);
    }

    //모니터 => 배열
    public static ByteArrayOutputStream setOutToByteArray() {

        ORIGINAL_OUT = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        CURRENT_OUT = printStream;

        return outputStream;

    }

    //배열 => 모니터
    public static void clearSetOutToByteArray(ByteArrayOutputStream outputStream) {
        System.setOut(ORIGINAL_OUT);
        try {
            outputStream.close();
        } catch (Exception e) {
            System.out.println("aaa");
        }
        CURRENT_OUT.close();
    }
}