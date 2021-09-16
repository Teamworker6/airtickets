package kg.asiaenterprice.airtickets.service.implementation;

import kg.asiaenterprice.airtickets.dao.BaseDAO;
import kg.asiaenterprice.airtickets.dao.PlaneDAO;
import kg.asiaenterprice.airtickets.entity.Plane;
import kg.asiaenterprice.airtickets.service.PlaneService;

public class PlaneServiceImpl implements PlaneService {
    PlaneDAO planeDAO = BaseDAO.getPlaneDAO();

    @Override
    public void addPlane(Plane plane) {
        planeDAO.add(plane);
    }
}
