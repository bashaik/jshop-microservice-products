package com.jshop.service;

import java.util.Optional;

import com.jshop.core.common.Constants;

public interface IRemoteProductsService
{
    String PRODUCTS_URL = Constants.ROOT_PATH + "/products";
    String PRODUCT_ID_URL = "/{product-id}";
    
    ProductsResponse getProducts(Optional<Integer> productIdParm);
}