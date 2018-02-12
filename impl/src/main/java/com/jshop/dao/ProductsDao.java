
package com.jshop.dao;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.cloud.orm.BaseDao;
import com.jshop.core.logging.JShopLogger;
import com.jshop.service.JShopDaoException;

@Repository
public class ProductsDao extends BaseDao<ProductEntity> implements IProductsDao
{
    private static final JShopLogger LOGGER = new JShopLogger(ProductsDao.class);

    @Override
    @Transactional
    public ProductEntity getProductEntityByProductId(int productIdParm) throws JShopDaoException
    {
    	LOGGER.debug("productIdParm: ", productIdParm);
    		
        ProductEntity result = null;

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<ProductEntity> criteriaQuery = builder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);

        criteriaQuery.select(root).where(builder.equal(root.get("id"), productIdParm));

        try
        {
            result = getEntityManager().createQuery(criteriaQuery).getSingleResult();
        }
        catch (NoResultException excp)
        {
            throw new JShopDaoException("No results found for the product Id " + productIdParm);
        }

        return result;
    }

}