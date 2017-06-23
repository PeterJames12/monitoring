package provide.support.service.impl;


import provide.support.dao.factory.DaoFactory;
import provide.support.model.MonitoringUrl;
import provide.support.service.MonitoringService;

import java.util.List;

/**
 * Implementation of {@link MonitoringService} interface.
 *
 * @author Igor Hnes on 6/21/17.
 */
public class MonitoringServiceImpl implements MonitoringService {

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<MonitoringUrl> getUrls() {
        return DaoFactory.getMonitoringDao().getUrls();
    }
}
