
package com.jshop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshop.core.logging.JShopLogger;
import com.jshop.dao.IProductsDao;
import com.jshop.dao.ProductEntity;

@Service
public class ProductsService implements IProductsService
{
    private static final JShopLogger LOGGER = new JShopLogger(ProductsService.class);
    
    @Autowired
    private IProductsDao productsDao;

    @Override
    public ProductsResponse getProducts(Optional<Integer> productIdParm)
    {
        LOGGER.debug("Product Id:", productIdParm);
        ProductsResponse response = new ProductsResponse();
        List<ProductEntity> entities = new ArrayList<>();
        try
        {
            if (productIdParm.isPresent())
            {
                ProductEntity entity = productsDao.getProductEntityByProductId(productIdParm.get());
                
                if (entity != null)
                {
                    entities.add(entity);
                }
            }
            else
            {
                entities = productsDao.getAll();                
            }
            
            if (entities != null && !entities.isEmpty())
            {
                List<Product> products = convertProductEntitiesToProducts(entities);
                response.setProducts(products);
            }
        }
        catch (JShopDaoException excp)
        {
            LOGGER.error("Error retrieving Products:", excp);
            throw new JShopServiceException(excp);
        }
        
        return response;
    }

    private List<Product> convertProductEntitiesToProducts(List<ProductEntity> entitiesParm)
    {
        List<Product> products = new ArrayList<>(); 
        if (entitiesParm != null && !entitiesParm.isEmpty())
        {
            entitiesParm.stream().forEach(entity -> 
            {
                products.add(new Product(entity.getId(), entity.getName(), entity.getPrice()));
            });
        }
        Collections.sort(products, Comparator.comparing(Product::getName));
        return products;
    }  
}