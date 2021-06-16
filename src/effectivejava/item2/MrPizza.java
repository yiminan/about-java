package effectivejava.item2;

import java.util.Objects;

class MrPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public MrPizza build() {
            return new MrPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private MrPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
