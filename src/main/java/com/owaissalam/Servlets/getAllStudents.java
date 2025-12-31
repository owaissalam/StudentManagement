package com.owaissalam.Servlets;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.hibernate.Session;

import com.owaissalam.Hibernate.Util.HibernateUtil;
import com.owaissalam.Hibernate.entities.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAllStudents")
public class getAllStudents extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//Get all students from DB
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Student> students = new ArrayList<Student>();
		students = session.createQuery("from student", Student.class).getResultList();
		session.close();
		
		//Show all students to client
		//resp.setContentType("text/html");
		
		req.setAttribute("students", students);

        //forward to JSP
        RequestDispatcher rd =
                req.getRequestDispatcher("getAllStudents.jsp");
        rd.forward(req, resp);
		
	}

}
