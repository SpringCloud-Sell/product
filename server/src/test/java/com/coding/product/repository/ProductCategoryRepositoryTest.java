package com.coding.product.repository;

import com.coding.product.ProductApplicationTests;
import com.coding.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductCategoryRepositoryTest extends ProductApplicationTests {

    @Autowired private ProductCategoryRepository repository;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = repository.findByCategoryTypeIn(Arrays.asList(0));
        Assert.assertTrue(list.size() > 0);
    }
}
