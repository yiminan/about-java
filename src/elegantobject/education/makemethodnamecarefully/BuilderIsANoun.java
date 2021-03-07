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
}
