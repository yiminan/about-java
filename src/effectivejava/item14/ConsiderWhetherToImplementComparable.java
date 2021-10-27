package effectivejava.item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * "{@link Comparable}을 구현할지 고려해야합니다."<p>
 * {@link Comparable}를 구현하면, 수많은 제네릭 알고리즘과 컬렉션의 힘을 누릴 수 있습니다.<p>
 * 사실상 자바 플랫폼 라이브러리의 모든 값 클래스와 열거타입이 {@link Comparable}를 구현했다.<p>
 * 알파벳, 숫자, 연대 같이 순서가 명확한 값 클래스를 작성한다면 {@link Comparable}를 구현하면 좋다.<p>
 *
 */
public class ConsiderWhetherToImplementComparable {

    public static void main(String[] args) {
        Set<String> strings = new TreeSet<>();
        Collections.addAll(strings, "B");
        Collections.addAll(strings, "C");
        Collections.addAll(strings, "A");
        /**
         * String은 {@link Comparable}을 구현한 구현체입니다.<p>
         * compareTo를 통해서 단순 동치성 비교에 더해 순서까지 비교할 수 있습니다.<p>
         */
        System.out.println(strings);// [A, B, C]

        Set<Book> books = new TreeSet<>();
        Collections.addAll(books, new Book("An Apple"));
        Collections.addAll(books, new Book("Creative Idea"));
        Collections.addAll(books, new Book("Beyond Today"));
        System.out.println(books);
    }

    private static final class Book implements Comparable<Book> {
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
