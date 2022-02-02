package com.example.aboutjava.effectivejava.item14;

/**
 * "Item 14 - {@link Comparable}을 구현할지 고려해야합니다."<p>
 * <p>
 * {@link Comparable}를 구현하면, 수많은 제네릭 알고리즘과 컬렉션의 힘을 누릴 수 있습니다.<p>
 * 사실상 자바 플랫폼 라이브러리의 모든 값 클래스와 열거타입이 {@link Comparable}를 구현했다.<p>
 * compareTo 메서드를 구현할때는 필드 값 비교시 <와 >를 사용하면 안됩니다.<p>
 * 결론)<p>
 * {@link Comparable}를 구현한 객체들의 배열은 Arrays.sort()로 손쉽게 정렬할 수 있습니다.<p>
 * 알파벳, 숫자, 연대 같이 순서가 명확한 값 클래스를 작성한다면 {@link Comparable}를 구현하면 좋다.<p>
 * 박싱된 기본 타입 클래스가 제공하는 정적 compare 메서드를 사용하거나,<p>
 * {@link java.util.Comparator}가 제공하는 비교자 생성 메서드를 사용해야합니다.<p>
 *
 * @see <a href="https://recordsoflife.tistory.com/313">compareTo 메서드 구현 가이드</a>
 */
public class ConsiderWhetherToImplementComparable {

    static final class Book implements Comparable<Book> {
        private final String name;

        public Book(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Book book) {
            return String.CASE_INSENSITIVE_ORDER.compare(this.name, book.name);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
