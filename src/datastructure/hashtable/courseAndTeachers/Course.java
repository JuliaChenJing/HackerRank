package datastructure.hashtable.courseAndTeachers;
import java.util.Arrays;

class Course 
{
	 String c_name;
     String[] faculty;
     public Course(String c_name, String [] faculty)
     {
    	 this.c_name=c_name;
    	 this.faculty=faculty;
    	 
     }
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String[] getFaculty() {
		return faculty;
	}
	public void setFaculty(String[] faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return "Course [c_name=" + c_name + ", faculty=" + Arrays.toString(faculty) + "]";
	}
}
