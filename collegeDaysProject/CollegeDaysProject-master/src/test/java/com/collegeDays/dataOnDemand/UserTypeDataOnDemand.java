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

import com.collegeDays.entity.UserType;
import com.collegeDays.repository.UserTypeRepository;

@Component
@Configurable
public class UserTypeDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<UserType> data;

	@Autowired
    UserTypeRepository userTypeRepository;

	public UserType getNewTransientUserType(int index) {
        UserType obj = new UserType();
        setCreatedBy(obj, index);
        setCreatedOn(obj, index);
        setLastUpdatedBy(obj, index);
        setLastUpdatedOn(obj, index);
        setUserType(obj, index);
        return obj;
    }

	public void setCreatedBy(UserType obj, int index) {
        String createdBy = "createdBy_" + index;
        if (createdBy.length() > 100) {
            createdBy = createdBy.substring(0, 100);
        }
        obj.setCreatedBy(createdBy);
    }

	public void setCreatedOn(UserType obj, int index) {
        Calendar createdOn = Calendar.getInstance();
        obj.setCreatedOn(createdOn);
    }

	public void setLastUpdatedBy(UserType obj, int index) {
        String lastUpdatedBy = "lastUpdatedBy_" + index;
        if (lastUpdatedBy.length() > 100) {
            lastUpdatedBy = lastUpdatedBy.substring(0, 100);
        }
        obj.setLastUpdatedBy(lastUpdatedBy);
    }

	public void setLastUpdatedOn(UserType obj, int index) {
        Calendar lastUpdatedOn = Calendar.getInstance();
        obj.setLastUpdatedOn(lastUpdatedOn);
    }

	public void setUserType(UserType obj, int index) {
        String userType = "userType_" + index;
        if (userType.length() > 20) {
            userType = new Random().nextInt(10) + userType.substring(1, 20);
        }
        obj.setUserType(userType);
    }

	public UserType getSpecificUserType(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        UserType obj = data.get(index);
        Integer id = obj.getUserTypeId();
        return userTypeRepository.findOne(id);
    }

	public UserType getRandomUserType() {
        init();
        UserType obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getUserTypeId();
        return userTypeRepository.findOne(id);
    }

	public boolean modifyUserType(UserType obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = userTypeRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'UserType' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<UserType>();
        for (int i = 0; i < 10; i++) {
            UserType obj = getNewTransientUserType(i);
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
            data.add(obj);
        }
    }
}
