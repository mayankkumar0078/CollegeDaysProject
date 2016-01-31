package com.collegeDays.dataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.collegeDays.entity.Student;
import com.collegeDays.repository.StudentRepository;

@Configurable
@Component
public class StudentDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Student> data;

	@Autowired
    UserDataOnDemand userDataOnDemand;

	@Autowired
    StudentRepository studentRepository;

	public Student getNewTransientStudent(int index) {
        Student obj = new Student();
        setBranchId(obj, index);
        setCreatedBy(obj, index);
        setCreatedOn(obj, index);
        setLastUpdatedBy(obj, index);
        setLastUpdatedOn(obj, index);
        return obj;
    }

	public void setBranchId(Student obj, int index) {
        Integer branchId = new Integer(index);
        obj.setBranchId(branchId);
    }

	public void setCreatedBy(Student obj, int index) {
        String createdBy = "createdBy_" + index;
        if (createdBy.length() > 100) {
            createdBy = createdBy.substring(0, 100);
        }
        obj.setCreatedBy(createdBy);
    }

	public void setCreatedOn(Student obj, int index) {
        Calendar createdOn = Calendar.getInstance();
        obj.setCreatedOn(createdOn);
    }

	public void setLastUpdatedBy(Student obj, int index) {
        String lastUpdatedBy = "lastUpdatedBy_" + index;
        if (lastUpdatedBy.length() > 100) {
            lastUpdatedBy = lastUpdatedBy.substring(0, 100);
        }
        obj.setLastUpdatedBy(lastUpdatedBy);
    }

	public void setLastUpdatedOn(Student obj, int index) {
        Calendar lastUpdatedOn = Calendar.getInstance();
        obj.setLastUpdatedOn(lastUpdatedOn);
    }

	public Student getSpecificStudent(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Student obj = data.get(index);
        Integer id = obj.getStudentId();
        return studentRepository.findOne(id);
    }

	public Student getRandomStudent() {
        init();
        Student obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getStudentId();
        return studentRepository.findOne(id);
    }

	public boolean modifyStudent(Student obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = studentRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Student' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student obj = getNewTransientStudent(i);
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
            data.add(obj);
        }
    }
}
