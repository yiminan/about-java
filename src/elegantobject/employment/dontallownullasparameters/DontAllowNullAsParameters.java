package elegantobject.employment.dontallownullasparameters;

import java.io.File;
import java.util.Collections;

/**
 * "파라미터로 null을 절대 허용하면 안됩니다"
 * "null 사용"은 "객체의 가변성", "정적 메서드"와 같이 OOP 골칫덩이입니다.
 * 코드 어딘가 null이 존재한다면 잘못된 코드입니다.
 * 이번에는 메서드의 인자값으로 null을 사용하는 경우를 살펴보겠습니다.
 */
class DontAllowNullAsParameters {

    public Iterable<File> find(String mask) {
        if (mask == null) {
            /**
             * findAll()과 같은 기능
             * 모든 파일을 찾는 경우
             */
            return Collections.singleton(new File("")); // 실제 반환값은 모든 파일
        } else {
            /**
             * find(String mask)와 같은 기능
             * mask를 사용하여 해당하는 파일을 찾는 경우
             */
            return Collections.singleton(new File("")); // 실제는 특정 mask 파일
        }
    }

    public Iterable<File> findAll() {
        return Collections.singleton(new File("")); // 실제 반환값은 모든 파일
    }
}
