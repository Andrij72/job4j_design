package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(DemoLog4j.class.getName());

    public static void main(String[] args) {
        byte a = 4;
        short b = 44;
        int c = 444;
        Long d = -44442L;
        float e = 4.4F;
        boolean f = true;
        boolean g = false;
        char h = 40;
        LOG.error("Var a:{}, Var b:{}, Var c:{}, Var d:{}, Var e:{}, Var f:{}, Var g:{}, Var h:{}", a, b, c, d, e, f, g, h);
    }
}
