package com.coding.product.service;

import com.coding.product.ProductApplicationTests;
import com.coding.product.common.DecreaseStockInput;
import com.coding.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfo> list = productService.findList(Arrays.asList("10000001", "10000002"));
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    @Transactional
    public void decreaseStock() throws Exception {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("10000001", 2);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }
}
