import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        experiment2();
    }

    public static void experiment2() {
        System.out.println("안녕하세요");

        PrintStream originalOut = System.out; //모니터

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //배열
        PrintStream printStream = new PrintStream(outputStream); //배열로 가는 스트림(통로)

        System.setOut(printStream); //out이 원래 모니터였는데 배열로 가능 통로로 바꿈

        System.out.print("하하하"); //모니터가 아니라 배열로 출력 -> 콘솔에 출력 안 됨

        String outStr = outputStream.toString(); //배열에 저장된 값 저장
        System.setOut(originalOut); //원래 모니터로 돌리기
        printStream.close();

        if (outStr.equals("하하하")) {
            System.out.println("출력 결과가 일치합니다.");
        } else {
            System.out.println("출력 결과가 일치하지 않습니다.");
        }

        System.out.println(outStr);
    }

    public static void experiment1() {

        String input = """
                등록
                너 자신을 알라
                """;
        Scanner sc = new Scanner(input); //scanner는 키보드에 입력된 데이터를 읽어옴 -> 코드가
        String cmd = sc.nextLine();
        String saying = sc.nextLine();
        System.out.println("입력한 명령어: " + cmd);
        System.out.println("입력한 명언: " + saying);

    }

}
