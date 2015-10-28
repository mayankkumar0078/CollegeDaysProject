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

import com.collegeDays.entity.Faculty;
import com.collegeDays.repository.FacultyRepository;

@Component
@Configurable
public class FacultyDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Faculty> data;

	@Autowired
    UserDataOnDemand userDataOnDemand;

	@Autowired
    FacultyRepository facultyRepository;

	public Faculty getNewTransientFaculty(int index) {
        Faculty obj = new Faculty();
        setCreatedBy(obj, index);
        setCreatedOn(obj, index);
        setLastUpdatedBy(obj, index);
        setLastUpdatedOn(obj, index);
        setQualification(obj, index);
        setSubjects(obj, index);
        return obj;
    }

	public void setCreatedBy(Faculty obj, int index) {
        String createdBy = "createdBy_" + index;
        if (createdBy.length() > 100) {
            createdBy = createdBy.substring(0, 100);
        }
        obj.setCreatedBy(createdBy);
    }

	public void setCreatedOn(Faculty obj, int index) {
        Calendar createdOn = Calendar.getInstance();
        obj.setCreatedOn(createdOn);
    }

	public void setLastUpdatedBy(Faculty obj, int index) {
        String lastUpdatedBy = "lastUpdatedBy_" + index;
        if (lastUpdatedBy.length() > 100) {
            lastUpdatedBy = lastUpdatedBy.substring(0, 100);
        }
        obj.setLastUpdatedBy(lastUpdatedBy);
    }

	public void setLastUpdatedOn(Faculty obj, int index) {
        Calendar lastUpdatedOn = Calendar.getInstance();
        obj.setLastUpdatedOn(lastUpdatedOn);
    }

	public void setQualification(Faculty obj, int index) {
        String qualification = "qualification_" + index;
        if (qualification.length() > 100) {
            qualification = qualification.substring(0, 100);
        }
        obj.setQualification(qualification);
    }

	public void setSubjects(Faculty obj, int index) {
        String subjects = "subjects_" + index;
        if (subjects.length() > 100) {
            subjects = subjects.substring(0, 100);
        }
        obj.setSubjects(subjects);
    }

	public Faculty getSpecificFaculty(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Faculty obj = data.get(index);
        Integer id = obj.getFacultyId();
        return facultyRepository.findOne(id);
    }

	public Faculty getRandomFaculty() {
        init();
        Faculty obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getFacultyId();
        return facultyRepository.findOne(id);
    }

	public boolean modifyFaculty(Faculty obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = facultyRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Faculty' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Faculty>();
        for (int i = 0; i < 10; i++) {
            Faculty obj = getNewTransientFaculty(i);
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
            data.add(obj);
        }
    }
}
