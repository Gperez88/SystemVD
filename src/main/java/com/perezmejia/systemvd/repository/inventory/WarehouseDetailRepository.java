package com.perezmejia.systemvd.repository.inventory;

import com.perezmejia.systemvd.entity.inventory.Warehouse;
import com.perezmejia.systemvd.entity.inventory.WarehouseDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Guil on 5/8/2016.
 */
public interface WarehouseDetailRepository extends CrudRepository<WarehouseDetail, Long> {
}
