
package com.jshop.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jshop.core.logging.JShopLogger;
import com.jshop.service.IProductsService;
import com.jshop.service.IRemoteProductsService;
import com.jshop.service.ProductsResponse;
import com.jshop.shared.rest.BaseController;
import com.jshop.shared.rest.JShopControllerException;

@RestController
@RequestMapping(IRemoteProductsService.PRODUCTS_URL)
public class ProductsController extends BaseController implements IRemoteProductsService
{
    private static final JShopLogger LOGGER = new JShopLogger(ProductsController.class);

    @Autowired
    private IProductsService productsService;
    
    @Override
    @GetMapping({ "", PRODUCT_ID_URL})
    public ProductsResponse getProducts(@PathVariable("product-id") Optional<Integer> productIdParm)
    {
    	if (productIdParm.isPresent() && productIdParm.get() < 0) {
            throw new JShopControllerException("product.id.invalid", HttpStatus.BAD_REQUEST);    			
    	}

        ProductsResponse response = productsService.getProducts(productIdParm);
        return response;

    }

}