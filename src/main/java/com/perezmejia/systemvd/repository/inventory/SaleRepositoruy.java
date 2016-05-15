package com.perezmejia.systemvd.repository.inventory;

import com.perezmejia.systemvd.entity.inventory.Warehouse;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Guil on 5/8/2016.
 */
public interface SaleRepositoruy extends CrudRepository<Warehouse, Long> {
}
