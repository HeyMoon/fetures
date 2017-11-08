package com.dyh.profile.demo;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

/**
 * @author dyh
 * @created at 2017 11 02 18:04
 */
public class ASMTest {

    /**
     * ClassVisitor 接口的方法调用顺序：
     * visit
     * visitSource? visitOuterClass? ( visitAnnotation | visitAttribute )*( visitInnerClass | visitField | visitMethod )*
     * visitEnd
     *
     * 这意味着visit方法必须被第一个调用，然后调用visitSource方法，最多调用一次，再接着是visitOuterClass
     * 然后再调用任意次数的visitAnnotation或者visitAttribute方法，
     *
     * 接着可以调用
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ClassPrinter cp = new ClassPrinter(Opcodes.ASM5);
        ClassReader cr = new ClassReader("java.lang.Runnable");
        cr.accept(cp,0);

        //ASMifier
        int flags = ClassReader.SKIP_DEBUG;
        ClassReader classReader = new ClassReader("java.lang.Runnable");
        classReader.accept(new TraceClassVisitor(null, new ASMifier(), new PrintWriter(
                System.out)), flags);

    }
}