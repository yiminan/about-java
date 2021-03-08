package elegantobject.education.makemethodnamecarefully;

class ManipulatorIsAVerb {

    private static class Pixel {

        private final int x;
        private final int y;
        private Color color;

        public Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void paint(Color color) {
            this.color = color;
        }

    }

    private static class Color {
        private final String name;

        public Color(String name) {
            this.name = name;
        }
    }
}
