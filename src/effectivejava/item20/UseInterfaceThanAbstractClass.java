package effectivejava.item20;

import java.applet.AudioClip;

/**
 * "추상 클래스보다는 인터페이스를 우선하라"<p>
 * <p>
 * 자바가 제공하는 다중 구현 메커니증은 (1) 인터페이스 (2) 추상클래스 입니다.<p>
 * 물론 인터페이스에서 default method로 instance method를 구현형태로 제공할 수 있습니다.<p>
 * 기존 클래스에도 손쉽게 새로운 인터페이스를 사용 구현해 넣을 수 있습니다.<p>
 * 자바에서도 기존 클래스에 쉽게 {@link Comparable}, {@link Iterable}, {@link AutoCloseable}를 추가 구현할 수 있다.<p>
 * <p>
 * 인터페이스는 믹스인(mixin) 정의에 안성맞춤이다.<p>
 * 믹스인(mixin) 인터페이스를 구현한 클래스의 원래 주된 기능에 선택적 기능을 혼합한다고 해서 믹스인(mixin)이라고 합니다.<p>
 * 쉽게 생각하면, 추상 클래스는 상속 구현하게 된 클래스가 1개의 상속 밖에 불가능하지만, 믹스인 인터페이스는 여러 인터페이스를 선택해서 구현할 수 있다.<p>
 * <p>
 * 3.인터페이스로는 계층구조가 없는 타입 프레임워크를 만들 수 있습니다.<p>
 * 현실의 개념중에는 타입을 계층적으로 정의하면 수많은 개념을 구조적으로 잘 표현할 수 있는 개념이 있다.<p>
 */
class UseInterfaceThanAbstractClass {

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
}
