package elegantobject.retirement.throwonlycheckedexception;

import java.io.FileInputStream;
import java.io.IOException;

class JustOneExceptionIsEnough {

    public void example() {
        try {
            fileInputStream("a.jpg");
            age("12");
        } catch (Exception ex) {
            System.out.println(String.format("example message: %s", ex.getMessage()));
        }
    }

    private FileInputStream fileInputStream(String fileName) throws Exception {
        try {
            return new FileInputStream(fileName);
        } catch (IOException ex) {
            throw new Exception(String.format("This file(%s) can't open to stream.", fileName));
        }
    }

    private int age(String age) throws Exception {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException ex) {
            throw new Exception(String.format("Invalid age %s", age));
        }
    }

}
