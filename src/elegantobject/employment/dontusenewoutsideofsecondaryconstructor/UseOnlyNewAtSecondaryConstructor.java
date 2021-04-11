package elegantobject.employment.dontusenewoutsideofsecondaryconstructor;

 */
class UseOnlyNewAtSecondaryConstructor {

    private static class NYSE implements Exchange {
        @Override
        public float rate(String origin, String target) {
            if ("EUR".equals(origin)) {
                switch (target) {
                    case "USD":
                        return 1.19F;
                }
            }
            if ("USD".equals(origin)) {
                switch (target) {
                    case "EUR":
                        return 0.84F;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private interface Exchange {
        float rate(String origin, String target);
    }
}
