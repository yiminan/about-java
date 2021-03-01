package elegantobject.atleastencapsulatesomething;

public class AtLeastEncapsulateSomething {

    static class WrongYear {
        public long read() {
            return System.currentTimeMillis() / (1000L * 60L * 60L * 24L * 30L * 12L) - 1970L;
        }
    }
}
