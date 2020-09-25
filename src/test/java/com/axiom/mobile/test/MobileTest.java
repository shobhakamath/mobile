package com.axiom.mobile.test;

import com.axiom.mobile.entities.Brand;
import com.axiom.mobile.test.util.LoadUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MobileTest {
    //@Test
    public void test1(){
        Brand[] brands =  new LoadUtils().getMobiles();
        List<Brand> brands1= Arrays.stream(brands)
                .filter(i->i.getRelease().getPriceEur().contains("200"))
        .collect(Collectors.toList());
        System.out.println(brands1.size());

    }

    //@Test
    public void test2(){
        Brand[] brands =  new LoadUtils().getMobiles();
        List<Brand> brands1= Arrays.stream(brands)
                .filter(i->i.getSim().contains("eSIM"))
                .collect(Collectors.toList());
        System.out.println(brands1.size());

    }

    //@Test
    public void test3(){
        Brand[] brands =  new LoadUtils().getMobiles();
        List<Brand> brands1= Arrays.stream(brands)
                .filter(i->i.getRelease().getAnnounceDate().contains("2018"))
                .collect(Collectors.toList());
        System.out.println(brands1.size());

    }
    @Test
    public void test4(){
        Brand[] brands = new LoadUtils().getMobiles();
        Field[] fields = brands[0].getClass().getDeclaredFields();
        //fields[0].setAccessible(true);
        System.out.println(fields[0].getName());
        System.out.println(fields);
//Get the field value
    }
}
