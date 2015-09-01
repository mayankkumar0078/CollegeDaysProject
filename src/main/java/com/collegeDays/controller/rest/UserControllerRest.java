package com.collegeDays.controller.rest;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegeDays.dao.UserRepository;
import com.collegeDays.dto.UserDTO;
import com.collegeDays.entity.User;

@RestController
@EnableAutoConfiguration
@ComponentScan
@Transactional
public class UserControllerRest {

   

	 @Resource
	 private UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody User create(@RequestBody UserDTO userDTO) {
    	System.out.println("Creating a new role with information: " + userDTO);
    	User user = new User();
    	user.setEmail(userDTO.getEmail());
    	user.setPassword(userDTO.getUserName());
    	return userRepository.save(user);
    }

    /*@RequestMapping(value = "/api/roles/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody
    Role delete(@PathVariable("id") Long id) {
	logger.debug("Deleting role with id: " + id);

	Role deleted = roleRepository.findOne(id);

	roleRepository.delete(deleted);

	return deleted;
    }

    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    public @ResponseBody
    List<Role> findAll() {
	logger.debug("Finding all roles");

	return roleRepository.findAll();
    }

    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Role findById(@PathVariable("id") Long id) {
	logger.debug("Finding role by id: " + id);

	return roleRepository.findOne(id);
    }

    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public @ResponseBody
    Role update(@PathVariable("id") Long id, @RequestBody RoleDTO updated) {
	logger.debug("Updating role with information: " + updated);

	Role role = roleRepository.findOne(updated.getId());

	role.setName(updated.getName());
	role.setDescription(updated.getDescription());

	return role;
    }
*/
}
