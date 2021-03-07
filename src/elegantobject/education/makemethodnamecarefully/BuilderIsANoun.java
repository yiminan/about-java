package elegantobject.education.makemethodnamecarefully;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class BuilderIsANoun {

    private interface WrongBuilder {
        InputStream load(URL url);

        String read(File file);

        int add(int x, int y);
    }

    private interface GoodBuilder {
        // InputStream load(URL url); =변환=>
        InputStream stream(URL url);

        // String read(File file); =변환=>
        String content(File file);

        // int add(int x, int y); =변환=>
        int sum(int x, int y);
    }
}
