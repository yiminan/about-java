package elegantobject.employment.immutableobjectisloyalorconstant;

import java.net.URI;
import java.util.*;

/**
 * "충성스러우면서 불변 객체이거나, 아니면 상수 객체이어야 합니다"<p>
 * <p>
 * 세상이 가변적이기 때문에 불변성을 반대하는 사람들이 있습니다.<p>
 * 세상은 가변적이지만, 그렇다고 해서 불변 객체로 세상을 만들 수 없는 건 아닙니다.<p>
 * 상태(state)와 데이터(data)에 관해서 오해하고 있기 때문입니다.<p>
 * 객체의 메서드가 호출할 때마다 서로 다른 값이 반환되더라도 이 객체는 불변입니다. 반환값의 변화는 중요하지 않습니다.<p>
 * '불변객체란 객체가 살아있는 동안 상태가 변하지 않는다는 사실입니다.'<p>
 * 직관적으로 사람들은 불변 객체의 메서드를 호출할 때마다 상수(contant)처럼 매번 동일한 데이터가 반환되길 기대합니다.<p>
 * <p>
 * 기본적으로, 모든 객체는 (1) 식별자(identity) (2) 상태(state) (3) 행동(behavior)을 포함합니다.<p>
 * (1) 식별자(identity)<p>
 * - '=='로 객체의 동일성을 판단할 수 있는 기준입니다.<p>
 * (2) 상태(state)<p>
 * - 'equals()'로 내부 내용의 비교로 동등성 여부를 확인할 수 있는 객체의 내용물입니다.<p>
 * (3) 행동(behavior)<p>
 * - 객체의 상태를 이용하여 기능을 제공하는 메서드입니다.<p>
 * <p>
 * 반면에, 가변 객체는 완전히 다른 방식으로 동작합니다.<p>
 * 가변 객체의 상태는 변경이 가능하기 때문에 반드시 상태에 id와 같은 독립적인 식별자를 별도로 포함해야합니다.<p>
 * 완벽한 OOP 세계에서는 불변 객체를 사용하기 때문에 equals(), hashCode()라는 메서드가 필요하지 않습니다.<p>
 * <p>
 * 불변 객체만을 이용해서 컬렉션을 구현하려면,<p>
 * (1) 상수 리스트(constant list)<p>
 * (2) 불변 리스트(immutable list)<p>
 * 로 구현할 수 있습니다.<p>
 * <p>
 * 객체가 대표하는 실제 엔티티와 객체의 상태가 동일한 경우에는 '불변' 대신 '상수(constant'라는 용어를 사용합니다.<p>
 * 상수 객체가 설계하고, 유지보수하고, 이해하기에 더 편하기 때문에 불변 객체보다는 상수 객체를 사용하는게 좋습니다.<p>
 * 불변 객체에 대해 이야기했던 대부분의 내용은 불변 객체의 특별한 경우인 상수 객체와 관련이 있습니다.<p>
 * 모든 시스템에서는 불변 객체로 설계되어야합니다.<p>
 */
class ImmutableObjectIsLoyalOrConstant {

    public static void main(String[] args) {
        /**
         * 불변 객체의 특정 케이스인 "상수 객체" 예시
         */
        ConstantList<Integer> constantList = new ConstantList<>();
        ConstantList<Integer> copyConstantList = constantList.with(1);
        System.out.println(constantList);
        System.out.println(copyConstantList);

        /**
         * "불변 객체" 예시
         */
        ImmutableList<Integer> immutableList = new ImmutableList<>();
        System.out.println(immutableList);
    }

    /**
     * content로 내용물이 바뀔 수 있지만,<p>
     * WebPage는 불변 객체입니다.<p>
     * 불변 객체의 기준은 객체의 상태(state)가 변하는 지입니다.<p>
     */
    private static class WebPage {
        private final URI uri;

        public WebPage(URI uri) {
            this.uri = uri;
        }

        public String content() {
            // uri에 해당하는 내용을 HTTP GET 요청
            // 웹 페이지의 컨텐츠를 읽은 후,
            // 읽혀진 컨텐츠를 UTF-8 문자열로 반환한다.
            return new String("");
        }
    }

    private static class ConstantList<T> {
        private final List<T> list;

        ConstantList() {
            this(new ArrayList<T>());
        }

        private ConstantList(List<T> list) {
            this.list = list;
        }

        ConstantList<T> with(T value) {
            list.add(value);
            return new ConstantList<T>(new ArrayList<>(list));
        }

        public List<T> list() {
            return Collections.unmodifiableList(list);
        }
    }

    private static class ImmutableList<T> {
        private final List<T> items = new LinkedList<T>();

        void add(T value) {
            this.items.add(value);
        }

        public List<T> items() {
            return Collections.unmodifiableList(items);
        }
    }
}
