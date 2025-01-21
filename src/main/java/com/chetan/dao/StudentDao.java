package com.chetan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.chetan.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate; 

	 // Setter method for HibernateTemplate1
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//insert
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	//view all
	public List<Student> getAll() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}

	
	public Student getStudent(int id) {
		Student str = this.hibernateTemplate.get(Student.class, id);
		return str;
	}

	@Transactional
	public void updateStudent(Student student) {
		
		this.hibernateTemplate.update(student);
		
	}

	@Transactional
	public void deleteStudent(int stdId) {
		Student student = this.hibernateTemplate.get(Student.class, stdId);
		this.hibernateTemplate.delete(student);
	}

}
