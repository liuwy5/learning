package com.learning.common.util;

import java.util.UUID;

/**
 * UuidUtil
 * Created by lw on 16-12-19.
 */
public class UuidUtil {
    public static String getUuid() {
        return UUID.randomUUID().toString();
    }
}
