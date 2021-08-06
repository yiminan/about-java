package effectivejava.item9;

import java.io.*;

/**
 * "try-finally보다는 try-with-resources를 사용해야합니다."<p>
 * 자바 라이브러리에는 close 메서드를 호출해 직접 닫아줘야 하는 자원이 많습니다.<p>
 * {@link java.io.InputStream}, {@link java.io.OutputStream}, {@link java.sql.Connection} 등이 좋은 예시입니다.<p>
 * 자원 닫기는 클라이언트가 놓치기 쉬워서 예측할 수 없는 성능 문제로 이어지기도 합니다.<p>
 * 상당수가 안전망으로 finalizer를 활용하고 있지만, finalizer는 믿을만하지 못합니다.<p>
 */
class UseTryWithResourcesThanTryFinally {

    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[100];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
