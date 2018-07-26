/*
 * 文件名称：ProductController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180725 07:45
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180725-01         Rushing0711     M201807250745 新建文件
 ********************************************************************************/
package com.coding.product.controller;

import com.coding.product.dataobject.ProductCategory;
import com.coding.product.dataobject.ProductInfo;
import com.coding.product.service.CategoryService;
import com.coding.product.service.ProductService;
import com.coding.product.utils.ResultVOUtil;
import com.coding.product.vo.ProductInfoVO;
import com.coding.product.vo.ProductVO;
import com.coding.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired private ProductService productService;
    @Autowired private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        /*
         * 1. 查询所有上架的商品
         * 2. 获取类目type列表
         * 3. 查询类目
         * 4. 构造数据
         */
        // 1. 查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 2. 获取类目type列表
        List<Integer> categoryTypeList =
                productInfoList
                        .stream()
                        .map(ProductInfo::getCategoryType)
                        .collect(Collectors.toList());
        // 3. 查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
