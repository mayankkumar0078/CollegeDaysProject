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

import com.collegeDays.dataOnDemand.FacultyDataOnDemand;
import com.collegeDays.entity.Faculty;
import com.collegeDays.repository.FacultyRepository;

import junit.framework.Assert;

@Configurable
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class FacultyIntegrationTest {
/*
    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    FacultyDataOnDemand dod;

	@Autowired
    FacultyRepository facultyRepository;

	@Test
    public void testCount() {
        Assert.assertNotNull("Data on demand for 'Faculty' failed to initialize correctly", dod.getRandomFaculty());
        long count = facultyRepository.count();
        Assert.assertTrue("Counter for 'Faculty' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFind() {
        Faculty obj = dod.getRandomFaculty();
        Assert.assertNotNull("Data on demand for 'Faculty' failed to initialize correctly", obj);
        Integer id = obj.getFacultyId();
        Assert.assertNotNull("Data on demand for 'Faculty' failed to provide an identifier", id);
        obj = facultyRepository.findOne(id);
        Assert.assertNotNull("Find method for 'Faculty' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Faculty' returned the incorrect identifier", id, obj.getFacultyId());
    }

	@Test
    public void testFindAll() {
        Assert.assertNotNull("Data on demand for 'Faculty' failed to initialize correctly", dod.getRandomFaculty());
        long count = facultyRepository.count();
        Assert.assertTrue("Too expensive to perform a find all test for 'Faculty', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Faculty> result = facultyRepository.findAll();
        Assert.assertNotNull("Find all method for 'Faculty' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Faculty' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEntries() {
        Assert.assertNotNull("Data on demand for 'Faculty' failed to initialize correctly", dod.getRandomFaculty());
        long count = facultyRepository.count();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Faculty> result = facultyRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
        Assert.assertNotNull("Find entries method for 'Faculty' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Faculty' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSave() {
        Assert.assertNotNull("Data on demand for 'Faculty' failed to initialize correctly", dod.getRandomFaculty());
        Faculty obj = dod.getNewTransientFaculty(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Faculty' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Faculty' identifier to be null", obj.getFacultyId());
        try {
            facultyRepository.save(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        facultyRepository.flush();
        Assert.assertNotNull("Expected 'Faculty' identifier to no longer be null", obj.getFacultyId());
    }

	@Test
    public void testDelete() {
        Faculty obj = dod.getRandomFaculty();
        Assert.assertNotNull("Data on demand for 'Faculty' failed to initialize correctly", obj);
        Integer id = obj.getFacultyId();
        Assert.assertNotNull("Data on demand for 'Faculty' failed to provide an identifier", id);
        obj = facultyRepository.findOne(id);
        facultyRepository.delete(obj);
        facultyRepository.flush();
        Assert.assertNull("Failed to remove 'Faculty' with identifier '" + id + "'", facultyRepository.findOne(id));
    }*/
}
