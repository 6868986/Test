/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study;

/**
 * <p>
 *
 * </p>
 *
 * @author liushixing@meituan.com
 * @date 2023/4/26 10:28
 */
public class LambdaStudy {

    interface Add{
        int add(int a,int b);
    }

    private String test(int a,int b,Add add){
        return String.valueOf(add.add(a,b));
    }

    public static void main(String[] args) {

        LambdaStudy lambdaStudy = new LambdaStudy();
        Add add = (a,b) -> {
            return a + b;
        };
        System.out.println("1 + 2 = " + lambdaStudy.test(1,2,add));
    }
}
