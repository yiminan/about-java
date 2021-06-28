package effectivejava.item4;

/**
 * "클래스 인스턴스화를 막으려면 private 생성자를 사용해야합니다."<p>
 * <p>
 * 정적 메서드와 정적 필드만 담은 클래스를 만들고 싶을 떄가 있습니다. 물론 OOP에는 위반되는 클래스입니다.<p>
 * 예시로, {@link java.lang.Math Math}, {@link java.util.Arrays Arrays}, {@link java.util.Collections Collections}가 있습니다.<p>
 * Utility Class는 Instance를 만들어서 사용하도록 만들어지지 않았습니다. 그래서 암묵적인 public 생성자 생성대신 private 생성자를 선언해줍니다.<p>
 * 'abstract class' 사용하면 Instance 생성을 막을 수 있다고 생각도 하는데, 하위 구현 클래스로 만들면 Instance를 만들 수 있어서 문제가 됩니다.<p>
 * <p>
 * 결론)<p>
 * 애초에 private 생성자를 만들면 상속도 불가능하고, Instance를 만들지도 못하게 됩니다.<p>
 */
class UsePrivateConstructorToBlockInstantiation {

    public static void main(String[] args) {
        try {
            new ExampleUtility();
        } catch (AssertionError ex) {
            System.out.println("인스턴스화가 불가능한 클래스 예외");
        }
    }

    private static class ExampleUtility {
        // public 생성자가 만들어져 인스턴스화 방지
        private ExampleUtility() {
            throw new AssertionError();
        }
    }
}
