package com.collegeDays.it;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.collegeDays.dataOnDemand.UserTypeDataOnDemand;
import com.collegeDays.entity.UserType;
import com.collegeDays.repository.UserTypeRepository;

import junit.framework.Assert;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@Configurable
public class UserTypeIntegrationTest {

  /*  @Test
    public void testMarkerMethod() {
    }

	@Autowired
    UserTypeDataOnDemand dod;

	@Autowired
    UserTypeRepository userTypeRepository;

	@Test
    public void testCount() {
        Assert.assertNotNull("Data on demand for 'UserType' failed to initialize correctly", dod.getRandomUserType());
        long count = userTypeRepository.count();
        Assert.assertTrue("Counter for 'UserType' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFind() {
        UserType obj = dod.getRandomUserType();
        Assert.assertNotNull("Data on demand for 'UserType' failed to initialize correctly", obj);
        Integer id = obj.getUserTypeId();
        Assert.assertNotNull("Data on demand for 'UserType' failed to provide an identifier", id);
        obj = userTypeRepository.findOne(id);
        Assert.assertNotNull("Find method for 'UserType' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'UserType' returned the incorrect identifier", id, obj.getUserTypeId());
    }

	@Test
    public void testFindAll() {
        Assert.assertNotNull("Data on demand for 'UserType' failed to initialize correctly", dod.getRandomUserType());
        long count = userTypeRepository.count();
        Assert.assertTrue("Too expensive to perform a find all test for 'UserType', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<UserType> result = userTypeRepository.findAll();
        Assert.assertNotNull("Find all method for 'UserType' illegally returned null", result);
        Assert.assertTrue("Find all method for 'UserType' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEntries() {
        Assert.assertNotNull("Data on demand for 'UserType' failed to initialize correctly", dod.getRandomUserType());
        long count = userTypeRepository.count();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<UserType> result = userTypeRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
        Assert.assertNotNull("Find entries method for 'UserType' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'UserType' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSave() {
        Assert.assertNotNull("Data on demand for 'UserType' failed to initialize correctly", dod.getRandomUserType());
        UserType obj = dod.getNewTransientUserType(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'UserType' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'UserType' identifier to be null", obj.getUserTypeId());
        try {
            userTypeRepository.save(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        userTypeRepository.flush();
        Assert.assertNotNull("Expected 'UserType' identifier to no longer be null", obj.getUserTypeId());
    }

	@Test
    public void testDelete() {
        UserType obj = dod.getRandomUserType();
        Assert.assertNotNull("Data on demand for 'UserType' failed to initialize correctly", obj);
        Integer id = obj.getUserTypeId();
        Assert.assertNotNull("Data on demand for 'UserType' failed to provide an identifier", id);
        obj = userTypeRepository.findOne(id);
        userTypeRepository.delete(obj);
        userTypeRepository.flush();
        Assert.assertNull("Failed to remove 'UserType' with identifier '" + id + "'", userTypeRepository.findOne(id));
    }*/
}
