package elegantobject.employment.dontusestaticmethod;

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
