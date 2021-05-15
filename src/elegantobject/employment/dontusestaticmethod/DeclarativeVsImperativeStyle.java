package elegantobject.employment.dontusestaticmethod;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;

/**
 * "선언형 스타일 VS 명령형 스타일 (declarative vs. imperative style)"<p>
 * <p>
 * 명령형 프로그래밍(imperative programming)에서는 '프로그램의 상태를 변경하는 문장(statement)을 사용해서 계산 방식을 차례대로 서술'합니다.<p>
 * 이와 달리 선언형 프로그래밍(devlarative programming)에서는 '제어 흐름을 서술하지 않고 계산 로직을 표현'합니다.<p>
 * 선언형 프로그래밍은 엔티티와 엔티티 사이의 관계로 구성되는 자연스러운 사고 패러다임에 더 가깝습니다.<p>
 * 선언형과 명령형 프로그래밍의 차이점은 "기능을 사용하는 방법의 차이"에 있습니다.<p>
 * <p>
 * 선언형 프로그래밍의 장점 <p>
 * 1. 성능 최적화<p>
 *  - 원하는 시점과 위치에 기능을 사용할 수 있다.<p>
 * 2. 다형성 사용<p>
 *  - interface 구현이나 class 상속을 구현하여 다형성을 사용하여 객체의 다형성을 사용할 수 있습니다.<p>
 *  - 쉽게 선언형으로 구현된 코드를 변경할 수 있습니다.<p>
 *  - 선언형 프로그래밍으로 구현된 객체는 일급 시민입니다.<p>
 *  - 다형성으로 낮춘 결합도는 좋은 유지보수성을 가지게 해줍니다.<p>
 * 3. 표현력 증가<p>
 *  - 기존에 "알고리즘(algorithm)과 실행(execution)" 대신 "객체(object)와 행동(behavior)"의 관점으로 봐야합니다.<p>
 *  - 선언형 프로그래밍으로 작성하는 것이 올바르다는 것을 알게될 수 있습니다.<p>
 * 4. 코드 응집도 증가<p>
 *  - 선언형 프로그래밍은 코드를 일일히 순서대로 시간적 결합도(temppral coupling)를 가지고 프로그래밍하지 않습니다.<p>
 *  - 같은 기능을 하는 코드를 응집시켜서 하나의 선언형 객체로 사용하기 때문에 유지보수성이 좋습니다.<p>
 * <p>
 * 정적 메서드는 객체지향 소프트웨어의 암적인 존재입니다. 한 번 사용하게 되면, 정적 메서드의 개체 수는 계속해서 증가하게 됩니다.<p>
 * 처음부터 정적 메서드를 사용해서는 안됩니다.<p>
 * <p>
 * 오픈 소스에서 작성되어있는 정적 메서드를 사용할 때는 정적 메서드를 감싸는 클래스를 만들어 종양인 정적 메서드를 고립시켜야합니다.<p>
 * 고립시키게 되면 나중에 정적 메서드의 호출을 제거해야하는 경우, 선언형 래핑 클래스의 구현 코드를 바꿔주기만해도 됩니다.<p>
 */
class DeclarativeVsImperativeStyle {

    public static void main(String[] args) {
        /**
         * "명령형 프로그래밍"<p>
         * 정적 메서드 예시<p>
         */
        int max = Math.max(3, 6);
        System.out.println(max);
        /**
         * "선언형 프로그래밍"<p>
         * 객체 사용 예시<p>
         */
        Number num = new Between(new Integer(1), new Integer(2), new Integer(3));
        System.out.println(num.intValue());
        /**
         * 아래와 같은 오픈 소스 정적 메서드를 사용하는 경우, 래핑해주는 선언형 클래스를 만들어 사용해야한다.<p>
         * Collections.singletonList(FileUtils.readLines(this.file)).iterator()<p>
         */
        Iterable<String> lines = new FileLines(new File("README.md"));
        System.out.println(lines.iterator());
    }

    /**
     * Apache Commons의 FileUtils 처럼 오픈 소스로 제공하는 정적 메서드 클래스를 래핑하여 사용하는 선언형 객체 예시<p>
     */
    private static class FileLines implements Iterable<String> {
        private final File file;

        public FileLines(File file) {
            this.file = file;
        }

        @Override
        public Iterator<String> iterator() {
            return Collections.singletonList(FileUtils.readLines(this.file)).iterator();
        }

        /**
         * 예시 제공을 위한 Apache Commons의 FileUtils를 Fake Object로 만들기 위한 클래스<p>
         */
        private static class FileUtils {
            public static String readLines(File file) {
                return "";// 구현 코드는 예시로만 제공한다.
            }
        }
    }

    private interface Number {

        int intValue();
    }

    private static class Integer implements Number {

        private final int num;

        public Integer(int num) {
            this.num = num;
        }

        @Override
        public int intValue() {
            return this.num;
        }
    }

    private static class Between implements Number {

        private final Number num;

        public Between(Number left, Number right, Number middle) {
            this.num = new Min(new Max(left, middle), right);
        }

        @Override
        public int intValue() {
            return this.num.intValue();
        }
    }

    private static class Max implements Number {

        private final Number left;
        private final Number right;

        public Max(Number left, Number right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int intValue() {
            if (left.intValue() > right.intValue()) {
                return left.intValue();
            }
            return right.intValue();
        }
    }

    private static class Min implements Number {

        private final Number left;
        private final Number right;

        public Min(Number left, Number right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int intValue() {
            if (left.intValue() > right.intValue()) {
                return left.intValue();
            }
            return right.intValue();
        }
    }

    private static class Math {

        public static int max(int a, int b) {
            if (a > b) {
                return a;
            }
            return b;
        }

        public static int min(int a, int b) {
            if (a < b) {
                return a;
            }
            return b;
        }

        public static int between(int a, int b, int c) {
            return Math.min(Math.max(a, c), b);
        }
    }
}
