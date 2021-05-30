package effectivejava.item1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;

/**
 * "생성자 대신 정적 팩터리 메서드를 고려하라"<p>
 * <p>
 * 클래스는 클라이언트에 public 생성자를 대신해서 정적 팩토리 메서드를 제공할 수 있습니다.<p>
 * 정적 팩토리 메서드는 장점과 단점이 둘 다 존재합니다.<p>
 * <p>
 * 장점)<p>
 * 1. 이름을 가질 수 있습니다.<p>
 * - 기존의 생성자는 new라는 키워드 밖에 없지만, 원하는 대로 팩토리 메서드의 이름을 작명할 수 있습니다.<p>
 * <p>
 * 2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 됩니다.<p>
 * - 정적 팩토리 메서드를 호출할 때마다 내부에서 생성자로 객체를 생성해도되고, 객체를 재사용해도 됩니다.<p>
 * - 플라이웨이트(Flyweight Pattern)과 비슷한 패턴입니다.<p>
 * - ex) Boolean.valueOf(boolean)<p>
 * - 인스턴스를 살아있게 할지 통제가 가능합니다. 1) singleton object 2) non-instantiable object 3) immutable object를 선택 가능<p>
 * <p>
 * 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있습니다.<p>
 * - 인터페이스를 구현하는 여러 객체가 있다고 가정하면, 필요한 경우에 따라서 다른 객체 반환이 가능합니다.<p>
 * - 대표적인 예로, {@link java.util.Collections Collections Class}가 있습니다.<p>
 * - Collections Class는 정적 팩토리 메서드를 통해서 원하는 인스턴스를 얻게 되어있습니다.<p>
 * - 하나의 클래스에서 하위 여러 객체를 반환 받을 수 있기 때문에 수 많은 클래스를 생성하지 않아도 됩니다.<p>
 * <p>
 * 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.<p>
 * - 반환 타입의 하위 타입이면 어떤 클래스의 객체를 반환해도 상관없습니다.<p>
 * - ex) {@link java.util.EnumSet EnumSet}은 원소가 64개 이하이면 {@link java.util.RegularEnumSet RegularEnumSet}, 65개 이상이면 {@link java.util.JumboEnumSet JumboEnumSet}을 반환합니다.<p>
 * - 클라이언트는 정적 팩토리 메서드를 사용만하면 되지, 무엇이 반환되는지는 신경 안써도 된다.<p>
 * <p>
 * 5. 정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 됩니다.<p>
 * - 객체 생성 시점에 new 키워드를 사용한다면 객체의 인스턴스가 반환됩니다. 하지만 정적 팩토리 메서드는 작성 시점에는 반환할 객체의 클래스가 없어도 됩니다.<p>
 * - 즉, JDBC라고 봤을 때, Connection과 관련된 객체를 생성한다면, Vendor별로 다른 생성 객체를 제공할 수 있습니다. 유연하게 반환할 수 있습니다.<p>
 * <p>
 * 단점)<p>
 * 1. 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩토리 메서드만 제공하면 하위 클래스를 만들 수 없습니다.<p>
 * - 유틸리티 클래스들은 상속할 수 없는 정적 팩토리 메서드만 가지고 있으니 상속이 가능해도 할 수 있는게 없습니다.<p>
 * - 정적 팩토리 메서드를 사용하면서, 상속을 사용하지 않고 컴포지션을 사용하고, 불변 타입을 만들려면 이 제약을 사용해야한다는 점에서 장점이 될 수 도 있습니다.<p>
 * <p>
 * 2. 정적 팩토리 메서드는 프로그래머가 찾기 어렵습니다.<p>
 * - new 를 사용한 생성자는 명확하지만, 직접 클래스에 들어가서 확인해보지 않으면 정적 팩토리 메서드는 내용을 확인할 수 없습니다.<p>
 * - 정적 팩토리 메서드가 찾기 어렵기 때문에 애초에 네이밍을 규약에 맞게 잘 생성해주어야합니다.<p>
 * - API Docs를 이용해서 정적 팩토리 메서드에 대한 내용을 잘 정리해야합니다.<p>
 */
class ConsiderStaticFactoryMethodInsteadOfConstructor {

    public static void main(String[] args) throws IOException {
        /**
         * "from"
         * - from이 호출되는 클래스 타입을 반환하는 정적 팩토리 메서드
         * - 1개 파라미터를 전달받는 경우
         */
        Date nowDate = Date.from(Instant.now());
        /**
         * "of"
         * - from이 호출되는 클래스 타입을 반환하는 정적 팩토리 메서드
         * - 2개이상 파라미터를 전달받는 경우
         */
        EnumSet types = EnumSet.of(Type.VIP, Type.GENERAL);
        /**
         * "valueOf"
         * - "from", "of"에서 조금 더 자세하게 네이밍한 정적 팩토리 메서드
         */
        BigInteger maxIntValue = BigInteger.valueOf(Integer.MAX_VALUE);
        /**
         * "instance" or "getInstance"
         * - 매개변수를 받는다면, 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스를 보장하진 않는다.
         * - 같은 인스턴스를 보장하지 않는 이유는 이미 생성된 인스턴스를 싱글턴 패턴과 같이 재사용할 수 있다.
         */
        StackWalker stackWalker = StackWalker.getInstance();
        /**
         * "create" or "newInstance"
         * -
         */
        List<String> strings = (List<String>) Array.newInstance(String.class, 10);
        /**
         * "getType"
         * -
         */
        FileStore testFile = Files.getFileStore(Path.of("/home/test.txt"));
        /**
         * "newType"
         */
        Files.newBufferedReader(Path.of("/home/test.txt"));
        /**
         * "type"
         */
        Collections.unmodifiableList(Arrays.asList(Type.VIP, Type.GENERAL));
    }

    private enum Type {VIP, GENERAL}
}
