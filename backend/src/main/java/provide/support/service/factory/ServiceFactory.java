package provide.support.service.factory;

import provide.support.service.MonitoringService;
import provide.support.service.impl.MonitoringServiceImpl;

/**
 * @author Igor Hnes on 6/21/17.
 */
public class ServiceFactory {

    /**
     * @return instance of {@link MonitoringService}.
     */
    public static MonitoringService getMonitoringService() {
        return new MonitoringServiceImpl();
    }
}
