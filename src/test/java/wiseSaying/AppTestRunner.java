package wiseSaying;

import com.back.App;
import com.back.global.AppContext;
import util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input + "종료");
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        AppContext.init(sc);
        App app = new App();
        app.run();

        TestUtil.clearSetOutToByteArray(outputStream);
        return outputStream.toString();
    }

}