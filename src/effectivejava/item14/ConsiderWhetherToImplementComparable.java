package effectivejava.item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * "{@link Comparable}을 구현할지 고려해야합니다."<p>
 */
public class ConsiderWhetherToImplementComparable {

    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
