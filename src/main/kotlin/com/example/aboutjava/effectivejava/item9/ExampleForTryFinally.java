package com.example.aboutjava.effectivejava.item9;

import java.io.*;

/**
 * 기존의 try-finally를 사용한 예시
 * - Java 라이브러리에서 close 메서드를 제대로 구현한 비율은 겨우 1/3정도다.
 * - ...
 */
class ExampleForTryFinally {
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
