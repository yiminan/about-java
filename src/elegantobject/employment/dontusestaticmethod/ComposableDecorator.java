package elegantobject.employment.dontusestaticmethod;

class ComposableDecorator {
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
