package elegantobject.step2_education.step2_4_makemethodnamecarefully;

/**
 * "조정자(Manipulator)는 동사다"<p>
 * <p>
 * 객체는 실세계에 엔티티(Entity)를 대표합니다.<p>
 * 엔티티에게 행위를 요청하고, 뭔가가 만들어질 것이라고 예상하지 않는 경우 조정자를 사용합니다.<p>
 * 조정자는 메서드이름과 반환타입만 보면 프로시저(Procedure)라고 볼 수도 있는데, 사실 차이가 있습니다.<p>
 * <p>
 * 프로시저와 조정자의 차이<p>
 * - 조정자 : 객체에게 행위를 요청<p>
 * - 프로시저 : 객체에게 행위를 지시<p>
 * <p>
 * 빌더 패턴은 유지보수성이 낮고, 응집도가 떨어지는 객체를 만들기 때문에 생성자로 만들기에 어려운 객체에 사용합니다.<p>
 * 빌더와 빌더 패턴은 다릅니다.<p>
 * 빌더는 무언가를 만드는 메서드이고, 빌더 패턴은 객체를 만들기 위해서 생성자를 대신하는 패턴입니다.<p>
 */
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
         * 조정자 예시입니다.<p>
         * Pixel에는 color를 셋팅해달라고 요청합니다.<p>
         * 요청 이후에 무언 가를 달라고 하지 않습니다.<p>
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

    /**
     * 빌더 패턴 예시입니다.<p>
     * 빌더 패턴은 빌더의 형태를 객체 생성에 필요한 부분을 사용하는 것입니다.<p>
     */
    private static class Book {
        private String author;
        private String title;
        private int page;

        private Book withAuthor(String author) {
            this.author = author;
            return this;
        }

        private Book withTitle(String title) {
            this.title = title;
            return this;
        }

        private Book withPage(int page) {
            this.page = page;
            return this;
        }
    }
}
