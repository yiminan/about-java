package effectivejava.item2;

class DominoPizza extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        public DominoPizza build() {
            return new DominoPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private DominoPizza(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }
}
