/*
 * 文件名称：ProductService.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180726 07:12
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180726-01         Rushing0711     M201807260712 新建文件
 ********************************************************************************/
package com.coding.product.service;

import com.coding.product.dataobject.ProductInfo;
import com.coding.product.dto.CartDTO;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有上架商品列表
     *
     * @return 上架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList -
     * @return -
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDTOList -
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
