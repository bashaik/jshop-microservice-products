
package com.jshop.dao;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jshop.cloud.orm.BaseEntity;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity
{
    private static final long serialVersionUID = 7866871914751126230L;
    
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "price", nullable = false)
    private String price;

    public ProductEntity()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int idParm)
    {
        id = idParm;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String nameParm)
    {
        name = nameParm;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String priceParm)
    {
        price = priceParm;
    }

    @Override
    public boolean equals(Object objParm)
    { 
        if (!(objParm instanceof ProductEntity))
        {
            return false;
        }        
        if (this == objParm)
        {
            return true;
        }
        ProductEntity other = (ProductEntity) objParm;

        return Objects.equals(getName(), other.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(name);
    }
}