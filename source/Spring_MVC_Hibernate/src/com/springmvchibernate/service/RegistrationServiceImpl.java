package com.springmvchibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvchibernate.dao.StudentDao;
import com.springmvchibernate.dao.TutorDao;
import com.springmvchibernate.entity.Customer;
import com.springmvchibernate.entity.Registration;
import com.springmvchibernate.entity.Student;
import com.springmvchibernate.entity.Tutor;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	StudentDao studentDao;

	@Autowired
	TutorDao TutorDao;

	@Override
	@Transactional
	public String register(Registration registration) {
		if (registration.getRole().equalsIgnoreCase("student")) {

			Student student = new Student(registration.getUserName(), registration.getGender(),
					registration.getEmail());
			studentDao.addStudents(student);

			return "student";
		} 
		
		else if (registration.getRole().equalsIgnoreCase("tutor")) {

			Tutor tutor = new Tutor(registration.getUserName(), registration.getGender(), registration.getEmail());
			TutorDao.addTutors(tutor);
			return "tutor";
		}

		return "false";

	}

}
