package com.transportationcompany.tracking.repositories;

import com.transportationcompany.tracking.domain.VehicleLocation;
import com.vividsolutions.jts.geom.Point;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class VehicleLocationSearchRepositoryImpl implements VehicleLocationSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VehicleLocation> searchVehiclesWithinRectangle(Point upperRightCorner, Point bottomLeftCorner) {
        Query query = entityManager.createNativeQuery("SELECT * FROM vehicle_location WHERE location @ BOX(?,?)", VehicleLocation.class);
        query.setParameter(1, upperRightCorner);
        query.setParameter(2, bottomLeftCorner);

        return query.getResultList();
    }
}
