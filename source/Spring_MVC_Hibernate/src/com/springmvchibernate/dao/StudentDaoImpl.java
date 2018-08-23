package com.springmvchibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvchibernate.entity.Student;

@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public void addStudents(Student Student) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().save(Student);
	}

	/*@Override
	public void putStudents(Student Student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(int Studentid) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
