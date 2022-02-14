package com.example.aboutjava.effectivejava.item20;

/**
 * "Item 20 - 추상 클래스보다는 인터페이스를 우선하라"<p>
 * <p>
 * 자바가 제공하는 다중 구현 메커니증은 (1) 인터페이스 (2) 추상클래스 입니다.<p>
 * 물론 인터페이스에서 default method로 instance method를 구현형태로 제공할 수 있습니다.<p>
 * <p>
 * 1.기존 클래스에도 손쉽게 새로운 인터페이스를 사용 구현해 넣을 수 있습니다.<p>
 * 자바에서도 기존 클래스에 쉽게 {@link Comparable}, {@link Iterable}, {@link AutoCloseable}를 추가 구현할 수 있다.<p>
 * <p>
 * 2.인터페이스는 믹스인(mixin) 정의에 안성맞춤이다.<p>
 * 믹스인(mixin) 인터페이스를 구현한 클래스의 원래 주된 기능에 선택적 기능을 혼합한다고 해서 믹스인(mixin)이라고 합니다.<p>
 * 쉽게 생각하면, 추상 클래스는 상속 구현하게 된 클래스가 1개의 상속 밖에 불가능하지만, 믹스인 인터페이스는 여러 인터페이스를 선택해서 구현할 수 있다.<p>
 * <p>
 * 3.인터페이스로는 계층구조가 없는 타입 프레임워크를 만들 수 있습니다.<p>
 * 현실의 개념중에는 타입을 계층적으로 정의하면 수많은 개념을 구조적으로 잘 표현할 수 있는 개념이 있다.<p>
 * 가수와 작곡가가 싱어송 라이터가 될 수 있는 예시입니다. 이렇게 계층적 구조가 없는 개념들은 인터페이스로 만들기 편합니다.<p>
 * <p>
 * 4.래퍼 클래스 관용구와 함께 사용하면 기능을 향상시키는 안전하고 강력한 수단이 됩니다.<p>
 * 타입을 추상 클래스로 정의해두면 그 타입에 기능을 추가하는 방법을 상속뿐이다. 상속은 래퍼 클래스보다 활용도가 떨어지고 깨지기는 더 쉽다.<p>
 * 자바 8부터는 디폴트 메서드를 제공한다. 따라서 구현 방법이 명확한 것이 있다면 이를 디폴트 메서드로 제공해 개발자들의 수고를 덜어줄 수 있다.<p>
 * 하지만 디폴트 메서드에도 제약은 존재한다. equals와 hashCode 같은 Object의 메서드는 디폴트 메서드로 제공해서는 안된다.<p>
 * 또한 인스턴스 필드를 가질 수 없고 public이 아닌 정적 멤버도 가질 수 없다.<p>
 * 마지막으로, 본인이 만들지 않은 인터페이스에는 디폴트 메서드를 추가할 수 없다.<p>
 * 한편, 추상 골격 구현 클래스를 함께 제공하면 인터페이스와 추상 클래스의 장점을 모두 취할 수 있다.<p>
 * 인터페이스로 타입을 정의하고 필요한 일부를 디폴트 메서드로 구현한다.<p>
 * 추상 골격 클래스에서는 나머지 메서드들 구현한다.<p>
 * 이렇게 해두면 단순히 골격 구현을 확장하는 것만으로 이 인터페이스를 구현하는데 필요한 일이 대부분 완료된다. 바로 템플릿 메서드 패턴이다.<p>
 * 이러한 추상 골격 클래스의 좋은 예는 자바 컬렉션 프레임워크에서 AbstractList, AbstractSet, AbstractMap 등이 있다.<p>
 * <p>
 * 결론)<p>
 * - 일반적으로 다중 구현용 타입으로는 인터페이스가 적합하다.<p>
 * - 복잡한 인터페이스라면 골격 구현을 함께 제공하는 방법을 고려하자.<p>
 * - 골격 구현은 가능한 한 인터페이스의 디폴트 메서드로 제공하여 인터페이스를 구현한 모든 곳에서 활용하도록 하는 것이 좋다.<p>
 */
class UseInterfaceThanAbstractClass {

    /**
     * Example)<p>
     * 1.기존 클래스에도 손쉽게 새로운 인터페이스를 사용 구현해 넣을 수 있습니다.<p>
     */
    private class User implements Comparable<User> {
        private final String nickName;
        private final int age;

        User(String nickName, int age) {
            this.nickName = nickName;
            this.age = age;
        }

        @Override
        public int compareTo(User user) {
            if (this.age > user.age) {
                return 1;
            }
            if (this.age < user.age) {
                return -1;
            }
            return 0;
        }
    }

    /**
     * Example)<p>
     * 2.인터페이스는 믹스인(mixin) 정의에 안성맞춤이다.<p>
     */
    private class IU implements Singer, SongWriter {
        @Override
        public AudioClip sing(Song s) {
            return null;
        }

        @Override
        public Song compose(int chartPosition) {
            return null;
        }
    }

    /**
     * Example)<p>
     * 3.인터페이스로는 계층구조가 없는 타입 프레임워크를 만들 수 있습니다.<p>
     */
    private interface SingerSongWriter extends Singer, SongWriter {
        AudioClip strum();

        void actSensitive();
    }

    private interface Singer {
        AudioClip sing(Song s);

        interface AudioClip {
        }
    }

    private interface SongWriter {
        Song compose(int chartPosition);
    }

    private interface Song {
    }

    /**
     * Example)<p>
     * 4.래퍼 클래스 관용구와 함께 사용하면 기능을 향상시키는 안전하고 강력한 수단이 됩니다.<p>
     */
    public interface Coffee {
        void boilWater();

        void putEspresso();

        void putIce();

        void putExtra();

        void makeCoffee();
    }

    public abstract class AbstractCoffee implements Coffee {
        @Override
        public void boilWater() {
            System.out.println("물을 끓인다.");
        }

        @Override
        public void putEspresso() {
            System.out.println("에스프레소를 넣는다.");
        }

        @Override
        public void putIce() {
            System.out.println("얼음을 넣는다.");
        }
    }

    public class IceAmericano extends AbstractCoffee implements Coffee {

        @Override
        public void putExtra() {
            System.out.println("시럽을 넣는다.");
        }

        @Override
        public void makeCoffee() {
            boilWater();
            putEspresso();
            putExtra();
            putIce();
        }
    }

    public class IceLatte extends AbstractCoffee implements Coffee {

        @Override
        public void putExtra() {
            System.out.println("우유를 넣는다.");
        }

        @Override
        public void makeCoffee() {
            boilWater();
            putEspresso();
            putExtra();
            putIce();
        }
    }

    /**
     * Reference)<p>
     * 이미 상속을 사용하고 있는 경우 자바에서 추상 골격 클래스를 다중 상속하는 방법<p>
     */
    public class MilkCream {
        public void putCream() {
            System.out.println("우유 크림을 넣는다.");
        }
    }

    public class IceCappuccino extends MilkCream implements Coffee {
        InnerAbstractCoffee innerAbstractCoffee = new InnerAbstractCoffee();

        @Override
        public void boilWater() {
            innerAbstractCoffee.boilWater();
        }

        @Override
        public void putEspresso() {
            innerAbstractCoffee.putEspresso();
        }

        @Override
        public void putIce() {
            innerAbstractCoffee.putIce();
        }

        @Override
        public void putExtra() {
            innerAbstractCoffee.putExtra();
            putCream();
        }

        @Override
        public void makeCoffee() {
            boilWater();
            putEspresso();
            putIce();
            putExtra();
        }

        // private 내부 클래스 - 추상 골격 클래스를 상속한다.
        private class InnerAbstractCoffee extends AbstractCoffee {

            @Override
            public void putExtra() {
                System.out.println("우유를 넣는다.");
            }

            @Override
            public void makeCoffee() {
                System.out.println("커피를 만든다.");
            }
        }
    }
}
