package com.mr.test;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Administrator on 2018/5/29.
 */
public class ShiroTest {
    public static void main(String[] args) {
        String password = "666";
        //md5直接加密
        Md5Hash md5Hash = new Md5Hash(password);
      //  System.out.println(md5Hash);
        //fae0b27c451c728867a567e8c1bb4e53:md5一次加密

        //MD5+盐值：加密
        String name = "ls";
        Md5Hash md5 = new Md5Hash(password,name);
        System.out.println(md5);
        //b630a2dd1ec4718d8f915f8c5477574a :zs
        //eabe51b927419df61f1ea47105eebd56 :ls

        //MD5+盐值：加密
        Md5Hash md5hashIterations = new Md5Hash(password,name ,3 );
        System.out.println(md5hashIterations);
        //140be9aae2cb3edb7da62672506b8021 :zs + 666 +1000次
        //65b6fb49d76acd37c4bfba51053edf8f : ls + 666 + 1000
    }
}
