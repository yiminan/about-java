package elegantobject.step3_employment.dontusestaticmethod;

/**
 * "정적 메서드(static method)를 사용하지 않습니다"<p>
 * <p>
 * 정적 메서드를 사용하는 것은 null이 탄생한 것과 같이 잘못된 부분입니다.<p>
 * 사실 Java를 사용하는 입장에서는 static 키워드를 알 필요가 없습니다.<p>
 * 정적 메서드와 객체 방식이 큰 차이가 없을 것이라고 생각할 수도 있습니다.<p>
 * 오히려 객체를 사용하면, '객체 생성', '가비지 컬렉션'를 신경써야하지만, 정적 메서드는 생각할 필요가 없습니다.<p>
 * 게다가 정적 메서드가 사용할 때, 직관적으로 호출이 가능합니다.<p>
 * 그럼에도 유지보수성과 OOP 측면에서는 정적 메서드를 사용하면 안됩니다.<p>
 * 나중에 유지보수성에서 아주 힘들게 하는 요소가 될 수 있습니다.<p>
 */
class DontUseStaticMethod {

    public static void main(String[] args) {
        // static method를 사용한 예시
        System.out.println(WebPageWithStaticMethod.read("https://www.java.com"));
        // object를 사용한 예시
        System.out.println(new WebPageWithObject("https://www.java.com").content());
    }

    private static class WebPageWithStaticMethod {
        public static String read(String uri) {
            // HTTP 요청을 만들고,
            // UTF-8 문자열로 변환한다.
            return "";
        }
    }

    private static class WebPageWithObject {
        private final String uri;

        public WebPageWithObject(String uri) {
            this.uri = uri;
        }

        public String content() {
            // HTTP 요청을 만들고,
            // UTF-8 문자열로 변환한다.
            return "";
        }
    }
}
