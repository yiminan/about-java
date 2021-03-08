package elegantobject.education.makemethodnamecarefully;

/**
 * "조정자(Manipulator)는 동사다"
 * 객체는 실세계에 엔티티(Entity)를 대표합니다.
 * 엔티티에게 행위를 요청하고, 뭔가가 만들어질 것이라고 예상하지 않는 경우 조정자를 사용합니다.
 * 조정자는 메서드이름과 반환타입만 보면 프로시저(Procedure)라고 볼 수도 있는데, 사실 차이가 있습니다.
 * 프로시저와 조정자의 차이
 * - 조정자 : 객체에게 행위를 요청
 * - 프로시저 : 객체에게 행위를 지시
 * 빌더 패턴은 유지보수성이 낮고, 응집도가 떨어지는 객체를 만들기 때문에 생성자로 만들기에 어려운 객체에 사용합니다.
 * 빌더와 빌더 패턴은 다릅니다.
 * 빌더는 무언가를 만드는 메서드이고, 빌더 패턴은 객체를 만들기 위해서 생성자를 대신하는 패턴입니다.
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
