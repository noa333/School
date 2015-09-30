
package school;
import java.util.ArrayList;
public class Course {
    enum Type {
        Math,Science,English,History,Language,Elective,PE
    }
    public static final int numPeriods = 4;
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private String name;
    private Type type;
    private int period;
    private ArrayList<Student> students = new ArrayList<Student>();
    private int gpa;
    private Teacher theTeacher;
    
    public static Course addCourse(String _name,
    Type _type, int _period)
    {
        Course temp = new Course(_name,_type,_period);
        courses.add(temp);
        return(temp);
    }
    Course()
    {
        name = "None";
        type = Type.Elective;
        period = 1;
    }
    Course(String _name,Type _type, int _period)
    {
        name = _name;
        type = _type;
        period = _period;
    }   

    public boolean addStudent(Student _student, double _gradeScore)
    {
        if (!setStudentOK(_student))
            return(false);
        if (!_student.setCourseOK(this))
            return(false);
        _student.setCourseDoIt(this,_gradeScore);
        setStudentDoIt(_student);
        return(true);
    }  
    public boolean setStudentOK(Student _student)
    {
        if (_student == null)
            return(false);
        if (students.contains(_student))
            return(false);
        return(true);
    }
    public void setStudentDoIt(Student _student)
    {
        students.add(_student);
    }    
    
        /////////////////////    
    
    
    public boolean addTeacher(Teacher _teacher)
    {
        if (!setTeacherOK(_teacher))
            return(false);
        if (!_teacher.setCourseOK(this))
            return(false);
        _teacher.setCourseDoIt(this);
        setTeacherDoIt(_teacher);
        return(true);
    }  
    public boolean setTeacherOK(Teacher _teacher)
    {
        if (_teacher == null)
            return(false);
        if (theTeacher != null)
            return(false);
        return(true);
    }
    public void setTeacherDoIt(Teacher _teacher)
    {
        theTeacher = _teacher;
    }    
    
    public void setPeriod(int _period)
    {
        period = _period;
    }
    public int getPeriod()
    {
        return(period);
    }       
    public void setName(String _name)
    {
        name = _name;
    }
    public String getName()
    {
        return(name);
    }    
    public void setType(Type _type)
    {
        type = _type;
    }
    public Type getType()
    {
        return(type);
    }  
    

    public Student getStudent(int _index)
    {
        return(students.get(_index));
    }
    public int getNumStudents()
    {
        return(students.size());
    }
    
    public Teacher getTeacher(int _index)
    {
        return(theTeacher);
    }
    public double getGpa(int _index)
    {
        return(gpa);
    }
    
    
    public static void printNames()
    {
        System.out.println("===printNames===");
        for (Course temp : courses)
        {
                System.out.println(temp.getName());
        }        
    }    
    public String toString()
    {
        return(name + " " + type + " " + period);
    }    
}
 