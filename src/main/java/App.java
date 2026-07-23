import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private int lastId = 0;
    List<com.back.WiseSaying> wiseSayings = new ArrayList<>();

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

                    com.back.WiseSaying wiseSaying = new com.back.WiseSaying(lastId, saying, author);
                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.",lastId);
                }
                case "목록" -> {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    wiseSayings
                            .reversed()
                            .stream()
                            .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n",
                                    wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getSaying()));

                }
                case "종료" -> {
                    return;
                }
            }
        }

    }
}
