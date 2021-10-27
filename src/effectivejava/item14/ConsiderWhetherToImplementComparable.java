package effectivejava.item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * "{@link Comparable}을 구현할지 고려해야합니다."<p>
 */
public class ConsiderWhetherToImplementComparable {

    public static void main(String[] args) {
        Set<String> strings = new TreeSet<>();
        Collections.addAll(strings, "B");
        Collections.addAll(strings, "C");
        Collections.addAll(strings, "A");
        System.out.println(strings);// [A, B, C]
    }
}
