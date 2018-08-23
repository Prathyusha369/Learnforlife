package com.springmvchibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvchibernate.entity.Tutor;

@Repository("TutorDao")
public class TutorDaoImpl implements TutorDao {

	@Autowired
	private SessionFactory sessionFactory;

/*	@Override
	public List<Tutor> getTutors() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public void addTutors(Tutor Tutor) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().save(Tutor);
	}

/*	@Override
	public void putTutors(Tutor Tutor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTutor(int Tutorid) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tutor getTutor(int id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
