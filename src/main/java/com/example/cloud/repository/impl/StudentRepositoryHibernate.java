package com.example.cloud.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cloud.constant.Gender;
import com.example.cloud.entity.Student;
import com.example.cloud.repository.StudentRepository;

@Repository
public class StudentRepositoryHibernate implements StudentRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public StudentRepositoryHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		Query<Student> query = session.createQuery(criteriaQuery);
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public Student findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Student.class, id);
	}

	@Override
	public List<Student> findByGender(Gender gender) {
		Session session = sessionFactory.getCurrentSession();
		Query<Student> query = null;

		// criteria way
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		Predicate maleEqual = criteriaBuilder.equal(root.get("gender"), gender);
		Order nameAsc = criteriaBuilder.asc(root.get("name"));
		criteriaQuery.select(root).where(maleEqual).orderBy(nameAsc);
		query = session.createQuery(criteriaQuery);

		// jpql query
		query = session.createQuery("select s from Student s where s.gender = 'MALE'", Student.class);

		// native query
		session.createNativeQuery("select * from student where gender = 'MALE'", Student.class);

		List<Student> list = query.getResultList();
		return list;
	}

}
