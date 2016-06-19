package com.kaishengit.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class CodecTestCase {
    @Test
    public void testMd5() {
        String password = "111111";
        String salt = "@##$$%#@00__)";
        password = DigestUtils.md5Hex(password + salt);
        System.out.print(password);

    }
}
