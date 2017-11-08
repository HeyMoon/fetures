package com.dyh.profile.demo;

import org.objectweb.asm.ClassVisitor;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author dyh
 * @created at 2017 11 02 17:58
 */
public class ClassPrinter extends ClassVisitor{
    public ClassPrinter(int i) {
        super(i);
    }


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(signature + " "+ name + " extends " + superName + " implements " + Arrays.stream(interfaces).collect(Collectors.joining(",")).toString() );

        super.visit(version, access, name, signature, superName, interfaces);
    }




}
