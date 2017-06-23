package provide.support.service;

import provide.support.model.MonitoringUrl;

import java.util.List;

/**
 * @author Igor Hnes on 6/21/17.
 */
public interface MonitoringService {

    /**
     * @return list of monitoring url.
     */
    List<MonitoringUrl> getUrls();
}
