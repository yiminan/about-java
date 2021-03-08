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

        /**
         * 조정자 예시입니다.
         * Pixel에는 color를 셋팅해달라고 요청합니다.
         * 요청 이후에 무언 가를 달라고 하지 않습니다.
         */
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
