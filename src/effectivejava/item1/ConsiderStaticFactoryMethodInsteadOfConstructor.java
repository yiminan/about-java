package effectivejava.item1;

/**
 * "생성자 대신 정적 팩터리 메서드를 고려하라"<p>
 * <p>
 * 클래스는 클라이언트에 public 생성자를 대신해서 정적 팩토리 메서드를 제공할 수 있습니다.<p>
 * 정적 팩토리 메서드는 장점과 단점이 둘 다 존재합니다.<p>
 * 장점)<p>
 * 1. 이름을 가질 수 있습니다.<p>
 * - 기존의 생성자는 new라는 키워드 밖에 없지만, 원하는 대로 팩토리 메서드의 이름을 작명할 수 있습니다.<p>
 * 2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 됩니다.<p>
 * - 정적 팩토리 메서드를 호출할 때마다 내부에서 생성자로 객체를 생성해도되고, 객체를 재사용해도 됩니다.<p>
 * - 플라이웨이트(Flyweight Pattern)과 비슷한 패턴입니다.<p>
 * - ex) Boolean.valueOf(boolean)<p>
 * - 인스턴스를 살아있게 할지 통제가 가능합니다. 1) singleton object 2) non-instantiable object 3) immutable object를 선택 가능<p>
 * 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있습니다.<p>
 * - 인터페이스를 구현하는 여러 객체가 있다고 가정하면, 필요한 경우에 따라서 다른 객체 반환이 가능합니다.<p>
 * - 대표적인 예로, {@link java.util.Collections Collections Class}가 있습니다.<p>
 * - Collections Class는 정적 팩토리 메서드를 통해서 원하는 인스턴스를 얻게 되어있습니다.<p>
 * - 하나의 클래스에서 하위 여러 객체를 반환 받을 수 있기 때문에 수 많은 클래스를 생성하지 않아도 됩니다.<p>
 * 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.<p>
 * - 반환 타입의 하위 타입이면 어떤 클래스의 객체를 반환해도 상관없습니다.<p>
 * - ex) {@link java.util.EnumSet EnumSet}은 원소가 64개 이하이면 {@link java.util.RegularEnumSet RegularEnumSet}, 65개 이상이면 {@link java.util.JumboEnumSet JumboEnumSet}을 반환합니다.<p>
 * - 클라이언트는 정적 팩토리 메서드를 사용만하면 되지, 무엇이 반환되는지는 신경 안써도 된다.<p>
 */
class ConsiderStaticFactoryMethodInsteadOfConstructor {
}
