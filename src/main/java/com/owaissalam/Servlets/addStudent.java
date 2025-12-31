package com.owaissalam.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.owaissalam.Hibernate.Util.HibernateUtil;
import com.owaissalam.Hibernate.entities.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Accept data from user
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		
		//Converting data into Student obj
		
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setAge(age);
		
		//Saving data in DB using Hibernate
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			else {
				e.printStackTrace();
			}
		}
		finally {
			session.close();
		}
		
		
		//Display message to user
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.print("""
				<h1>Student added</h1>
				""");
		
	}
	
	

}
