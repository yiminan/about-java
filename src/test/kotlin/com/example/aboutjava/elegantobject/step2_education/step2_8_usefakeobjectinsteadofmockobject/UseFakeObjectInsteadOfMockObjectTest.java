package com.example.aboutjava.elegantobject.step2_education.step2_8_usefakeobjectinsteadofmockobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.example.aboutjava.elegantobject.step2_education.step2_8_usefakeobjectinsteadofmockobject.UseFakeObjectInsteadOfMockObject.Cash;
import static com.example.aboutjava.elegantobject.step2_education.step2_8_usefakeobjectinsteadofmockobject.UseFakeObjectInsteadOfMockObject.Exchange;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

class UseFakeObjectInsteadOfMockObjectTest {

    @DisplayName("Mock 객체를 사용한 테스트")
    @Test
    void mock() {
        Exchange exchange = Mockito.mock(Exchange.class);
        given(exchange.rate(anyString(), anyString())).willReturn(1.15f);
        Cash dollar = new Cash(exchange, 500);
        Cash euro = dollar.in("EUR");
        assertThat(euro.cents()).isEqualTo(575);
    }

    @DisplayName("Fake 객체를 사용한 테스트")
    @Test
    void fake() {
        Exchange exchange = new Exchange.Fake();
        Cash dollar = new Cash(exchange, 500);
        Cash euro = dollar.in("EUR");
        assertThat(euro.cents()).isEqualTo(617);
    }
}
