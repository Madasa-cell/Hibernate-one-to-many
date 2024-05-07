import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

import java.util.List;

public class HibernateTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Creating new Students
        Tutor tutor1 = new Tutor("TUT-012-ABC", "Sam Tesla", 44444);
        Student student1 = new Student("Tomas Ullby", "STU-111-ABC");
        Student student2 = new Student("Sarah Johansson", "STU-112-ABC");
        Student student3 = new Student("Oliver Nordhamn", "STU-113-ACF");

        tutor1.addStudentToTeachingGroup(student2);
        tutor1.addStudentToTeachingGroup(student3);

        //Saving newStudent in database.
        session.save(tutor1);
        session.save(student1);
        session.save(student2);
        session.save(student3);

        // Commiting the transaction to save the changes to the database
        tx.commit();

        // Starting a new transaction to retrieve the data
        tx = session.beginTransaction();

        // Retrieving students from the group.
            //Make sure to manually update the number to be upp to date.
        Tutor retreiveTutor = (Tutor)session.get(Tutor.class, 109);

        List<Student> studentsInGroup = retreiveTutor.getTeachingGroup();
        for (Student students : studentsInGroup) {
            System.out.println(students);
        }

        // Closing of Knots
        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
