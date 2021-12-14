package com.response.vo;

import org.junit.Assert;
import org.junit.Test;

import com.responsetap.vo.Telephone;

class TelephoneTestCase {

    @Test
    void test() {
        Telephone telephone = new Telephone("10", "+441619109020");
        Assert.assertTrue(telephone.toString().contains("10"));
        Assert.assertTrue(telephone.toString().contains("+441619109020"));
    }

}
