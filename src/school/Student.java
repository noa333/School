package school;
public class Student extends Person{
    private int gradeLevel;
    private Course courses[] = new Course[Course.numPeriods];
    private double gradeScore[] = new double[Course.numPeriods];
    
    public static Student addStudent(String _name,
    Gender _gender, int _weight, int _gradeLevel)
    {
        Student temp = new Student(_name,_gender,_weight,
        _gradeLevel);
        Person.addPerson(temp);
        return(temp);
    }
    Student (String _name,Gender _gender,int _weight,int _gradeLevel)
    {
        super(_name,_gender,_weight);
        gradeLevel = _gradeLevel;
    } 
    
    public boolean addCourse(Course _course, double _gradeScore)
    {
        if (!setCourseOK(_course))
            return(false);
        if (!_course.setStudentOK(this))
            return(false);
        _course.setStudentDoIt(this);
        setCourseDoIt(_course, _gradeScore);
        return(true);
    } 
    public void setCourseDoIt(Course _course, double _gradeScore)
    {
        courses[_course.getPeriod()] = _course;
        gradeScore[_course.getPeriod()] = _gradeScore;
    }
    public boolean setCourseOK(Course _course)
    {
        if (_course == null)
            return(false);        
        if (courses[_course.getPeriod()] != null)
            return(false);
        return(true);
    }
            
            
            
    public void setGradeLevel(int _gradeLevel)
    {
        gradeLevel = _gradeLevel;
    }
    public int getGradeLevel()
    {
        return(gradeLevel);
    }          
    
    public static void printNames()
    {
        System.out.println(
        "===printNamesOf=== ");
        for (Person temp : people)
        {
            if (temp instanceof Student)
                System.out.println(temp.getName()/* + Course.getGpa()*/);
        }
        
             
    }
    
    public void printTeachersNames()
    {
       System.out.println(getName() + " is taught by");
        for (Course temp : courses)
        {
            if (temp != null)
            {
                if(temp.getTeacher(gradeLevel) != null)
                    System.out.println(temp.getTeacher(gradeLevel).getName());
            }
        }
    }
    
    public String toString()
    {
        return(getName());
    }       
}
 