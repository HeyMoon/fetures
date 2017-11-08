package com.dyh.profile.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author dyh
 * @created at 2017 10 24 10:35
 */
public class ProfileTransformer implements ClassFileTransformer{


    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {


        return new byte[0];
    }

}
