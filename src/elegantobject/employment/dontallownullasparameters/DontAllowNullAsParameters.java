package elegantobject.employment.dontallownullasparameters;

import java.io.File;

/**
 * "파라미터로 null을 절대 허용하면 안됩니다"
 * "null 사용"은 "객체의 가변성", "정적 메서드"와 같이 OOP 골칫덩이입니다.
 * 코드 어딘가 null이 존재한다면 잘못된 코드입니다.
 * 이번에는 메서드의 인자값으로 null을 사용하는 경우를 살펴보겠습니다.
 */
class DontAllowNullAsParameters {

    private interface NonNullableParameter {
        Iterable<File> findAll();

        Iterable<File> find(String mask);
    }
}
