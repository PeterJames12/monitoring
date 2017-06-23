package provide.support.dao.impl;

import lombok.val;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.Mapping;
import provide.support.dao.MonitoringDao;
import provide.support.model.MonitoringUrl;
import provide.support.util.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.EntityListeners;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of {@link MonitoringDao} interface.
 *
 * @author Igor Hnes on 6/21/17.
 */
public class MonitoringDaoImpl implements MonitoringDao {

    public static void main(String[] args) {

        final MonitoringDaoImpl monitoringDao = new MonitoringDaoImpl();
        monitoringDao.getUrls();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<MonitoringUrl> getUrls() {
        final Session session = getSession();
        session.beginTransaction();
        final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        val urlQuery = criteriaBuilder.createQuery(MonitoringUrl.class);
        final Root<MonitoringUrl> root = urlQuery.from(MonitoringUrl.class);
        urlQuery.select(root);
        final List<MonitoringUrl> urls = session.createQuery(urlQuery).getResultList();

        session.getTransaction().commit();
        session.close();
        return urls;
    }

    /**
     * @return {@link Session} for next steps.
     */
    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
