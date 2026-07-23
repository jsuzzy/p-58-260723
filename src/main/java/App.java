import java.util.Scanner;

public class App {
    private Scanner sc;
    private int lastId = 0;
    private String cmd;

    public App(Scanner sc){
        this.sc = sc;
    }

    public void run(){
        System.out.println("== 명언 앱 ==");


        while (true){
            System.out.print("명령) ");
            cmd = sc.nextLine();

            switch (cmd) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    String saying = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    ++lastId;
                    System.out.printf("%d번 명언이 등록되었습니다.",lastId);
                }
                case "종료" -> {
                    return;
                }
            }
        }

    }
}
