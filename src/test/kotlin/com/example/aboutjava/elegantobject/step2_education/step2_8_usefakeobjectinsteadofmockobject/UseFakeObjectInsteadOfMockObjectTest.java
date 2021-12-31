package com.example.aboutjava.elegantobject.step2_education.step2_8_usefakeobjectinsteadofmockobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class UseFakeObjectInsteadOfMockObjectTest {

    @DisplayName("Mock 객체를 사용한 테스트")
    @Test
    void mock() {
        UseFakeObjectInsteadOfMockObject.Exchange exchange = Mockito.mock(UseFakeObjectInsteadOfMockObject.Exchange.class);
        Mockito.doReturn(1.15)
                .when(exchange)
                .rate("USD", "EUR");
        UseFakeObjectInsteadOfMockObject.Cash dollar = new UseFakeObjectInsteadOfMockObject.Cash(exchange, 500);
        UseFakeObjectInsteadOfMockObject.Cash euro = dollar.in("EUR");
        assertThat(euro.cents()).isEqualTo(617);
    }

    @DisplayName("Fake 객체를 사용한 테스트")
    @Test
    void fake() {
        UseFakeObjectInsteadOfMockObject.Exchange exchange = new UseFakeObjectInsteadOfMockObject.Exchange.Fake();
        UseFakeObjectInsteadOfMockObject.Cash dollar = new UseFakeObjectInsteadOfMockObject.Cash(exchange, 500);
        UseFakeObjectInsteadOfMockObject.Cash euro = dollar.in("EUR");
        assertThat(euro.cents()).isEqualTo(617);
    }
}
