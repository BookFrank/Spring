package com.tazine.bootwar;

import com.tazine.bootwar.entity.NbaPlayer;

/**
 * Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        NbaPlayer kobe = new NbaPlayer("kobe", 24);
        System.out.println(kobe.getName());
        System.out.println(kobe.getNum());
    }
}
