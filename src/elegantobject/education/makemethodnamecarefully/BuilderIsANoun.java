package elegantobject.education.makemethodnamecarefully;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class BuilderIsANoun {

    /**
     * 잘못된 빌더 이름 예시입니다.
     * 객체에게 무엇을 할 지에 대해서 직접 지시하는 것이 아니고,
     * 객체를 주체로 인정하고, 행위를 일일히 지시하지 않고 원하는 것만 요청해야합니다.
     * 아래 인터페이스는 직접 객체의 할 일을 지시하는 형태의 잘못된 빌더 메서드의 예시입니다.
     */
    private interface WrongBuilder {
        InputStream load(URL url);

        String read(File file);

        int add(int x, int y);
    }

    /**
     * 잘 사용된 빌더 이름 예시입니다.
     * 객체를 존중해주고, 원하는 부분만 요청을 통해서 가져옵니다.
     */
    private interface GoodBuilder {
        // InputStream load(URL url); =변환=>
        // 직접 load를 지시하지 않고, url을 통해서 stream을 요청해서 가져옵니다.
        InputStream stream(URL url);

        // String read(File file); =변환=>
        // 직접 read를 지시하지 않고, file을 전달하면 content를 요청해서 가져옵니다.
        String content(File file);

        // int add(int x, int y); =변환=>
        // 직접 add를 GoodBuilder에게 지시하지 않고, sum을 요청해서 가져옵니다.
        int sum(int x, int y);
    }
}
