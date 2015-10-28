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

import com.collegeDays.dataOnDemand.UserDataOnDemand;
import com.collegeDays.entity.User;
import com.collegeDays.repository.UserRepository;

import junit.framework.Assert;

@Configurable
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class UserIntegrationTest {

/*    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    UserDataOnDemand dod;

	@Autowired
    UserRepository userRepository;

	@Test
    public void testCount() {
        Assert.assertNotNull("Data on demand for 'User' failed to initialize correctly", dod.getRandomUser());
        long count = userRepository.count();
        Assert.assertTrue("Counter for 'User' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFind() {
        User obj = dod.getRandomUser();
        Assert.assertNotNull("Data on demand for 'User' failed to initialize correctly", obj);
        Integer id = obj.getUserId();
        Assert.assertNotNull("Data on demand for 'User' failed to provide an identifier", id);
        obj = userRepository.findOne(id);
        Assert.assertNotNull("Find method for 'User' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'User' returned the incorrect identifier", id, obj.getUserId());
    }

	@Test
    public void testFindAll() {
        Assert.assertNotNull("Data on demand for 'User' failed to initialize correctly", dod.getRandomUser());
        long count = userRepository.count();
        Assert.assertTrue("Too expensive to perform a find all test for 'User', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<User> result = userRepository.findAll();
        Assert.assertNotNull("Find all method for 'User' illegally returned null", result);
        Assert.assertTrue("Find all method for 'User' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEntries() {
        Assert.assertNotNull("Data on demand for 'User' failed to initialize correctly", dod.getRandomUser());
        long count = userRepository.count();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<User> result = userRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
        Assert.assertNotNull("Find entries method for 'User' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'User' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSave() {
        Assert.assertNotNull("Data on demand for 'User' failed to initialize correctly", dod.getRandomUser());
        User obj = dod.getNewTransientUser(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'User' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'User' identifier to be null", obj.getUserId());
        try {
            userRepository.save(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        userRepository.flush();
        Assert.assertNotNull("Expected 'User' identifier to no longer be null", obj.getUserId());
    }

	@Test
    public void testDelete() {
        User obj = dod.getRandomUser();
        Assert.assertNotNull("Data on demand for 'User' failed to initialize correctly", obj);
        Integer id = obj.getUserId();
        Assert.assertNotNull("Data on demand for 'User' failed to provide an identifier", id);
        obj = userRepository.findOne(id);
        userRepository.delete(obj);
        userRepository.flush();
        Assert.assertNull("Failed to remove 'User' with identifier '" + id + "'", userRepository.findOne(id));
    }*/
}
