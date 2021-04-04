package elegantobject.employment.dontusestaticmethod;

class ComposableDecorator {
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
