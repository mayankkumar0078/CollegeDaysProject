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

import com.collegeDays.dataOnDemand.StudentDataOnDemand;
import com.collegeDays.entity.Student;
import com.collegeDays.repository.StudentRepository;

import junit.framework.Assert;

@Configurable
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class StudentIntegrationTest {

    /*@Test
    public void testMarkerMethod() {
    }

	@Autowired
    StudentDataOnDemand dod;

	@Autowired
    StudentRepository studentRepository;

	@Test
    public void testCount() {
        Assert.assertNotNull("Data on demand for 'Student' failed to initialize correctly", dod.getRandomStudent());
        long count = studentRepository.count();
        Assert.assertTrue("Counter for 'Student' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFind() {
        Student obj = dod.getRandomStudent();
        Assert.assertNotNull("Data on demand for 'Student' failed to initialize correctly", obj);
        Integer id = obj.getStudentId();
        Assert.assertNotNull("Data on demand for 'Student' failed to provide an identifier", id);
        obj = studentRepository.findOne(id);
        Assert.assertNotNull("Find method for 'Student' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Student' returned the incorrect identifier", id, obj.getStudentId());
    }

	@Test
    public void testFindAll() {
        Assert.assertNotNull("Data on demand for 'Student' failed to initialize correctly", dod.getRandomStudent());
        long count = studentRepository.count();
        Assert.assertTrue("Too expensive to perform a find all test for 'Student', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Student> result = studentRepository.findAll();
        Assert.assertNotNull("Find all method for 'Student' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Student' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEntries() {
        Assert.assertNotNull("Data on demand for 'Student' failed to initialize correctly", dod.getRandomStudent());
        long count = studentRepository.count();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Student> result = studentRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
        Assert.assertNotNull("Find entries method for 'Student' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Student' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSave() {
        Assert.assertNotNull("Data on demand for 'Student' failed to initialize correctly", dod.getRandomStudent());
        Student obj = dod.getNewTransientStudent(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Student' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Student' identifier to be null", obj.getStudentId());
        try {
            studentRepository.save(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        studentRepository.flush();
        Assert.assertNotNull("Expected 'Student' identifier to no longer be null", obj.getStudentId());
    }

	@Test
    public void testDelete() {
        Student obj = dod.getRandomStudent();
        Assert.assertNotNull("Data on demand for 'Student' failed to initialize correctly", obj);
        Integer id = obj.getStudentId();
        Assert.assertNotNull("Data on demand for 'Student' failed to provide an identifier", id);
        obj = studentRepository.findOne(id);
        studentRepository.delete(obj);
        studentRepository.flush();
        Assert.assertNull("Failed to remove 'Student' with identifier '" + id + "'", studentRepository.findOne(id));
    }*/
}
