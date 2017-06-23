package provide.support.dao;

import provide.support.model.MonitoringUrl;

import java.util.List;

/**
 * @author Igor Hnes on 6/21/17.
 */
public interface MonitoringDao {

    /**
     * @return list of monitoring url.
     */
    List<MonitoringUrl> getUrls();
}
