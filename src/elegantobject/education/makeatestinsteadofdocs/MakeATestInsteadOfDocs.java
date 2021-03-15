package elegantobject.education.makeatestinsteadofdocs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class MakeATestInsteadOfDocs {
    
    private static class Cash {
        private final int dollars;

        public Cash(int dollars) {
            this.dollars = dollars;
        }

        public Cash plus(Cash cash) {
            return new Cash(this.dollars + cash.dollars);
        }

        public Cash mul(int factor) {
            return new Cash(this.dollars * factor);
        }
    }

    private static class MakeATestInsteadOfDocsTest {
        @Test
        void summarizes() {
            assertEquals(
                    new Cash(8),
                    new Cash(5).plus(new Cash(3))
            );
        }

        @Test
        void deducts() {
            assertEquals(
                    new Cash(-4),
                    new Cash(7).plus(new Cash(-11))
            );
        }

        @Test
        void multiplies() {
            assertEquals(
                    new Cash(6),
                    new Cash(2).mul(3)
            );
        }
    }
}
