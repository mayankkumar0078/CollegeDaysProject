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

import com.collegeDays.entity.User;
import com.collegeDays.entity.UserType;
import com.collegeDays.repository.UserRepository;

@Component
@Configurable
public class UserDataOnDemand {

	/*private Random rnd = new SecureRandom();

	private List<User> data;

	@Autowired
    UserRepository userRepository;

	public User getNewTransientUser(int index) {
        User obj = new User();
        setAboutMe(obj, index);
        setAddress(obj, index);
        setCollegeId(obj, index);
        setCountryId(obj, index);
        setCreatedBy(obj, index);
        setCreatedOn(obj, index);
        setEmailId(obj, index);
        setFirstName(obj, index);
        setLastName(obj, index);
        setLastUpdatedBy(obj, index);
        setLastUpdatedOn(obj, index);
        setMiddleName(obj, index);
        setPhoneNumber(obj, index);
        setPwd(obj, index);
        setUserTypeId(obj, index);
        return obj;
    }

	public void setAboutMe(User obj, int index) {
        String aboutMe = "aboutMe_" + index;
        if (aboutMe.length() > 200) {
            aboutMe = aboutMe.substring(0, 200);
        }
        obj.setAboutMe(aboutMe);
    }

	public void setAddress(User obj, int index) {
        String address = "address_" + index;
        if (address.length() > 200) {
            address = address.substring(0, 200);
        }
        obj.setAddress(address);
    }

	public void setCollegeId(User obj, int index) {
        Integer collegeId = new Integer(index);
        obj.setCollegeId(collegeId);
    }

	public void setCountryId(User obj, int index) {
        Integer countryId = new Integer(index);
        obj.setCountryId(countryId);
    }

	public void setCreatedBy(User obj, int index) {
        String createdBy = "createdBy_" + index;
        if (createdBy.length() > 100) {
            createdBy = createdBy.substring(0, 100);
        }
        obj.setCreatedBy(createdBy);
    }

	public void setCreatedOn(User obj, int index) {
        Calendar createdOn = Calendar.getInstance();
        obj.setCreatedOn(createdOn);
    }

	public void setEmailId(User obj, int index) {
        String emailId = "foo" + index + "@bar.com";
        if (emailId.length() > 100) {
            emailId = new Random().nextInt(10) + emailId.substring(1, 100);
        }
        obj.setEmailId(emailId);
    }

	public void setFirstName(User obj, int index) {
        String firstName = "firstName_" + index;
        if (firstName.length() > 100) {
            firstName = firstName.substring(0, 100);
        }
        obj.setFirstName(firstName);
    }

	public void setLastName(User obj, int index) {
        String lastName = "lastName_" + index;
        if (lastName.length() > 50) {
            lastName = lastName.substring(0, 50);
        }
        obj.setLastName(lastName);
    }

	public void setLastUpdatedBy(User obj, int index) {
        String lastUpdatedBy = "lastUpdatedBy_" + index;
        if (lastUpdatedBy.length() > 100) {
            lastUpdatedBy = lastUpdatedBy.substring(0, 100);
        }
        obj.setLastUpdatedBy(lastUpdatedBy);
    }

	public void setLastUpdatedOn(User obj, int index) {
        Calendar lastUpdatedOn = Calendar.getInstance();
        obj.setLastUpdatedOn(lastUpdatedOn);
    }

	public void setMiddleName(User obj, int index) {
        String middleName = "middleName_" + index;
        if (middleName.length() > 50) {
            middleName = middleName.substring(0, 50);
        }
        obj.setMiddleName(middleName);
    }

	public void setPhoneNumber(User obj, int index) {
        String phoneNumber = "phoneNumber_" + index;
        if (phoneNumber.length() > 15) {
            phoneNumber = phoneNumber.substring(0, 15);
        }
        obj.setPhoneNumber(phoneNumber);
    }

	public void setPwd(User obj, int index) {
        String pwd = "pwd_" + index;
        if (pwd.length() > 25) {
            pwd = pwd.substring(0, 25);
        }
        obj.setPwd(pwd);
    }

	public void setUserTypeId(User obj, int index) {
        UserType userTypeId = null;
        obj.setUserTypeId(userTypeId);
    }

	public User getSpecificUser(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        User obj = data.get(index);
        Integer id = obj.getUserId();
        return userRepository.findOne(id);
    }

	public User getRandomUser() {
        init();
        User obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getUserId();
        return userRepository.findOne(id);
    }

	public boolean modifyUser(User obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = userRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'User' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User obj = getNewTransientUser(i);
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
            data.add(obj);
        }
    }*/
}
