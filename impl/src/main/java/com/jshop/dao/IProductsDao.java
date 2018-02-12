package com.jshop.dao;

import com.jshop.cloud.orm.IDao;
import com.jshop.service.JShopDaoException;

public interface IProductsDao  extends IDao<ProductEntity>
{
    ProductEntity getProductEntityByProductId(int productIdParm)  throws JShopDaoException;
}