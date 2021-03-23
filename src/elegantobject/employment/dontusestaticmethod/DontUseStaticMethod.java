package elegantobject.employment.dontusestaticmethod;

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
