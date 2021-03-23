package elegantobject.employment.dontusestaticmethod;

class DontUseStaticMethod {
    private static class WebPageWithStaticMethod {
        public static String read(String uri) {
            // HTTP 요청을 만들고,
            // UTF-8 문자열로 변환한다.
            return "";
        }
    }
}
