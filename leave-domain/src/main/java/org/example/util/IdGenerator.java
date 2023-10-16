package org.example.util;

import java.util.UUID;

/**
 * @author
 */
public class IdGenerator {
    public static String nextId(){
        return UUID.randomUUID().toString();
    }
}
