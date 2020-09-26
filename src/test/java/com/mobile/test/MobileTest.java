package com.mobile.test;

import com.mobile.entities.Brand;
import com.mobile.test.util.LoadUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MobileTest {

    @Test
    public void test1(){
        Brand[] brands =  new LoadUtils().getMobiles();
        List<Brand> brands1= Arrays.stream(brands)
                .filter(i->i.getRelease().getPriceEur().contains("200"))
        .collect(Collectors.toList());
        Assert.assertTrue(brands1.size()==10);

    }

    @Test
    public void test2(){
        Brand[] brands =  new LoadUtils().getMobiles();
        List<Brand> brands1= Arrays.stream(brands)
                .filter(i->i.getSim().contains("eSIM"))
                .collect(Collectors.toList());
        Assert.assertTrue(brands1.size()==18);

    }

    @Test
    public void test3(){
        Brand[] brands =  new LoadUtils().getMobiles();
        List<Brand> brands1= Arrays.stream(brands)
                .filter(i->i.getRelease().getAnnounceDate().contains("2018"))
                .collect(Collectors.toList());
        Assert.assertTrue(brands1.size()==8);

    }
    @Test
    public void test4(){
        Brand[] brands = new LoadUtils().getMobiles();
        Field[] fields = brands[0].getClass().getDeclaredFields();
        Assert.assertTrue(fields[0].getName().equals("id"));

    }

    @Test
    public void test5(){
        Brand[] brands =  new LoadUtils().getMobiles();
        List<Brand> brands1= Arrays.stream(brands)
                .filter(i->i.getSim().contains("eSIM") && i.getRelease().getAnnounceDate().contains("2018"))
                .collect(Collectors.toList());
        Assert.assertTrue(brands1.size()==7);

    }
}
