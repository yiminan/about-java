package com.example.aboutjava.effectivejava.item9;

import java.io.*;

/**
 * "try-finally보다는 try-with-resources를 사용해야합니다."<p>
 * <p>
 * 자바 라이브러리에는 close 메서드를 호출해 직접 닫아줘야 하는 자원이 많습니다.<p>
 * {@link InputStream}, {@link OutputStream}, {@link java.sql.Connection} 등이 좋은 예시입니다.<p>
 * 자원 닫기는 클라이언트가 놓치기 쉬워서 예측할 수 없는 성능 문제로 이어지기도 합니다.<p>
 * 상당수가 안전망으로 finalizer를 활용하고 있지만, finalizer는 믿을만하지 못합니다.<p>
 * <p>
 * {@link AutoCloseable}을 사용하면, try-with-resources를 사용하여, 자원의 회수를 쉽게 할 수 있고, 가독성 있는 로직을 구현할 수 있습니다.<p>
 * **중요**<p>
 * 물론 {@link AutoCloseable}을 구현하는 클래스 내부에서 close()를 오버라이딩을 해야하지만, 비즈니스에 있던 자원회수 로직이 객체에 위임되고 분산된다.<p>
 * <p>
 * 결론)<p>
 * - 꼭 회수해야 하는 자원을 다룰 때는 try-finally 말고, try-with-resources를 사용해야한다.<p>
 * - 코드의 분명한 가독성, 예외 정보도 훨씬 유용하다.<p>
 * - try-finally로 작성하면 실용적이지 못할 만큼 지저분한 코드도, try-with-resources는 정확하고 쉽게 자원을 회수할 수 있다.<p>
 */
class UseTryWithResourcesThanTryFinally {
}
