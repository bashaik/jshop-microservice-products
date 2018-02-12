
package com.jshop.service;

import java.util.Optional;

public interface IProductsService
{
    ProductsResponse getProducts(Optional<Integer> productIdParm);
}