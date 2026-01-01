
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.owaissalam.Hibernate.Util.HibernateUtil;
import com.owaissalam.Hibernate.entities.Student;

public class App {
	public static void main(String[] args) {
//		Student student = new Student();
//		student.setName("OwaisSalam");
//		student.setEmail("Owaissalam@gmail.com");
//		student.setAge("21");
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Student> students = new ArrayList<Student>();
		students = session.createQuery("FROM Student", Student.class).getResultList();
		
		for(Student s : students) {
			System.out.println(s);
		}
//		Transaction transaction = null;
//		try {
//			transaction = session.beginTransaction();
//			session.persist(student);
//			transaction.commit();
//			System.out.println("Added to DB");
//			
//		} catch (Exception e) {
//			if(transaction != null) {
//				transaction.rollback();
//			}
//			else {
//				e.printStackTrace();
//			}
//		}
//		finally {
//			session.close();
//		}
		
		
	}
}
