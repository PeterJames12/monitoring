package provide.support.dao.factory;

import provide.support.dao.MonitoringDao;
import provide.support.dao.impl.MonitoringDaoImpl;

/**
 * @author Igor Hnes on 6/21/17.
 */
public class DaoFactory {

    /**
     * @return instance of {@link MonitoringDao}.
     */
    public static MonitoringDao getMonitoringDao() {
        return new MonitoringDaoImpl();
    }
}
