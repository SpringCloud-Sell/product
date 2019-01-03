package com.coding.product.repository;

import com.coding.product.ProductApplicationTests;
import com.coding.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> list =
                repository.findByProductIdIn(Arrays.asList("10000001", "10000002"));
        Assert.assertTrue(list.size() > 0);
    }
}
