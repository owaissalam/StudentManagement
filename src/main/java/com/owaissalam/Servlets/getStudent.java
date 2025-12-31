package com.owaissalam.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;

import com.owaissalam.Hibernate.Util.HibernateUtil;
import com.owaissalam.Hibernate.entities.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getStudent")
public class getStudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Fetch Student from DB
		String id = req.getParameter("id");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = session.get(Student.class, id);
		session.close();
		//Display it to client via browser
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.print("""
				<h1>Student with id %s : </h1>
				<h1>name : %s </h1>
				<h1>email : %s </h1>
				<h1>age : %s</h1>
				""".formatted(id, student.getName(), student.getEmail(), student.getAge() ));
	}

	
}
