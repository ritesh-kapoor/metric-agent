package org.metricagent.agent;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by ritesh on 13/10/14.
 */
public class Log {
    Class aClass;
    public static PrintWriter writer = new PrintWriter(System.out);

    private Log(Class aClass) {
        this.aClass = aClass;
    }

    public static Log getLogger(Class aClass) {
        return new Log(aClass);
    }

    public static void info(String s, Object a1, Object a2, Object a3, Object a4, Object a5) {
        print(s, new Object[]{a1, a2, a3, a4, a5});
    }

    public static void info(String s, Object a1, Object a2, Object a3, Object a4) {
        print(s, new Object[]{a1, a2, a3, a4});
    }

    public static void info(String s, Object a1, Object a2, Object a3) {
        print(s, new Object[]{a1, a2, a3});
    }

    public static void info(String s, Object a1, Object a2) {
        print(s, new Object[]{a1, a2});
    }

    public static void info(String s, Object a1) {
        print(s, new Object[]{a1});
    }

    public static void info(String s) {
        print(s, null);
    }

    public static void print(String s, Object[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MetricAgent [INFO] [")
                .append(new Date().toString())
                .append("] ");

        if (args == null) {
            writer.println(stringBuilder.append(s));
        } else {
            writer.println(stringBuilder.append(MessageFormat.format(s, args)));
        }
        writer.flush();
    }
}
