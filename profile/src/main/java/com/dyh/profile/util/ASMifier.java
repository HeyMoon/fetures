package com.dyh.profile.util;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

/**
 * @author dyh
 * @created at 2017 11 07 20:05
 */
public class ASMifier {
    public static void main(String[] args) throws Exception {
        int flags = ClassReader.SKIP_DEBUG;

        ClassReader classReader = new ClassReader("com.dyh.profile.instrument.ProfileTransformer");

        classReader.accept(new TraceClassVisitor(null, new org.objectweb.asm.util.ASMifier(), new PrintWriter(System.out)), flags);
    }
}