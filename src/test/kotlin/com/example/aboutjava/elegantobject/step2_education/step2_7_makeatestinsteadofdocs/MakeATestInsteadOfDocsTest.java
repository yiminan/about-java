package com.example.aboutjava.elegantobject.step2_education.step2_7_makeatestinsteadofdocs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeATestInsteadOfDocsTest {

    @Test
    void summarizes() {
        assertEquals(
                new MakeATestInsteadOfDocs.Cash(8),
                new MakeATestInsteadOfDocs.Cash(5).plus(new MakeATestInsteadOfDocs.Cash(3))
        );
    }

    @Test
    void deducts() {
        assertEquals(
                new MakeATestInsteadOfDocs.Cash(-4),
                new MakeATestInsteadOfDocs.Cash(7).plus(new MakeATestInsteadOfDocs.Cash(-11))
        );
    }

    @Test
    void multiplies() {
        assertEquals(
                new MakeATestInsteadOfDocs.Cash(6),
                new MakeATestInsteadOfDocs.Cash(2).mul(3)
        );
    }
}
