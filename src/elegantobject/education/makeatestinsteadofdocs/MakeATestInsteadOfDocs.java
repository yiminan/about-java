package elegantobject.education.makeatestinsteadofdocs;

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
}
