package provide.support.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import provide.support.model.MonitoringUrl;
import provide.support.service.factory.ServiceFactory;

import java.util.List;

/**
 * Controller provides api for creating, getting and deleting url.
 *
 * @author Igor Hnes on 6/22/17.
 */
@RestController
@RequestMapping("/api/monitoring")
@RequiredArgsConstructor
public class MonitoringController {

    @GetMapping("/getUrls")
    public ResponseEntity<List<MonitoringUrl>> getUrls() {
        final List<MonitoringUrl> urls = ServiceFactory.getMonitoringService().getUrls();
        return new ResponseEntity<>(urls, HttpStatus.OK);
    }
}
