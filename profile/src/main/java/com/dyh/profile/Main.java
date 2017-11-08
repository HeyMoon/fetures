package com.dyh.profile;

import com.dyh.profile.instrument.ProfileTransformer;

import java.lang.instrument.Instrumentation;

/**
 * @author dyh
 * @created at 2017 11 08 10:54
 */
public class Main {
    public static void premain(String args, Instrumentation inst){

        inst.addTransformer(new ProfileTransformer());

    }
}
