package elegantobject.employment.dontusestaticmethod;

/**
 * "조합 가능한 데코레이터"<p>
 * <p>
 * 객체 인스턴스를 선언하는 것만으로 해당 객체에 대해서 알 수 있게 하는 것이 OOP입니다.<p>
 * 조합 가능한 객체를 데코레이터라고 부릅니다.<p>
 * 아래 예시 클래스는 조합가능한 각각 데코레이터입니다.<p>
 *
 * @see File
 * @see Directory
 * @see FileName
 * <p>
 * 프로그래머는 데코레이터를 조합하는 일을 제외한 다른 일은 하지 말아야 합니다.<p>
 */
class ComposableDecorator {

    public static void main(String[] args) {
        /**
         * 프로그래머가 작성해야할 객체 인스턴스의 데코레이터 조합 형태
         */
        File file = new File(
                new Directory("/var/usrs"),
                new FileName("filename.jpg")
        );
    }

    private static class File {
        private final Directory directory;
        private final FileName fileName;

        public File(Directory directory, FileName fileName) {
            this.directory = directory;
            this.fileName = fileName;
        }
    }

    private static class Directory {
        private final String path;

        public Directory(String path) {
            this.path = path;
        }
    }

    private static class FileName {
        private final String name;

        public FileName(String name) {
            this.name = name;
        }
    }
}
