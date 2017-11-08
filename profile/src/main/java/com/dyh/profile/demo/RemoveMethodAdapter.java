package com.dyh.profile.demo;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

import java.util.Objects;

/**
 * @author dyh
 * @created at 2017 11 02 16:16
 */
public class RemoveMethodAdapter extends ClassAdapter{
    private String mName;
    private String mDesc;

    public RemoveMethodAdapter(ClassVisitor cv, String mName, String mDesc) {
        super(cv);
        this.mName = mName;
        this.mDesc = mDesc;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (Objects.equals(name,mName) && Objects.equals(desc,mDesc)){
            // do not delegate to next visitor -> this removes the method
            return null;
        }

        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}