package elegantobject.step2_education.step2_4_makemethodnamecarefully;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * "빌더는 명사다"<p>
 * <p>
 * 메서드의 이름을 정할 때,<p>
 * 객체에게 무엇을 '만들어라(build)' 요청하는 것은 협력자에 대한 존중이 없는 예의에 없는 방식입니다.<p>
 * 무엇을 만들어야 하는 지만 요청하고, 만드는 방법은 객체 스스로 결정하도록 해야 합니다.<p>
 * 즉, 객체에게 어떤 일을 해야 하는 지를 직접적으로 이야기하지 않습니다.<p>
 */
class BuilderIsANoun {

    /**
     * 잘못된 빌더 이름 예시입니다.<p>
     * 객체에게 무엇을 할 지에 대해서 직접 지시하는 것이 아니고,<p>
     * 객체를 주체로 인정하고, 행위를 일일히 지시하지 않고 원하는 것만 요청해야합니다.<p>
     * 아래 인터페이스는 직접 객체의 할 일을 지시하는 형태의 잘못된 빌더 메서드의 예시입니다.<p>
     */
    private interface WrongBuilder {
        InputStream load(URL url);

        String read(File file);

        int add(int x, int y);
    }

    /**
     * 잘 사용된 빌더 이름 예시입니다.<p>
     * 객체를 존중해주고, 원하는 부분만 요청을 통해서 가져옵니다.<p>
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
