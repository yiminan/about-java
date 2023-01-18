package com.example.aboutjava.effectivejava.item37;

/**
 * Item 37 - ordinal 인덱싱 대신 EnumMap을 사용하라.<p>
 */
class UseEnumMapInsteadOfOrdinalIndexing {

    private static class Plant {

        enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

        final String name;
        final LifeCycle lifeCycle;

        Plant(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private enum Phase {
        SOLID, LIQUID, GAS;

        public enum Transition {
            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

            private final Phase from;
            private final Phase to;

            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }
        }
    }
}
