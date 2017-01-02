package pk.edu.nust.seecs.gradebook.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Integer studentId;
    @Column
    private String name;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "course_students", joinColumns = {
    @JoinColumn(name = "student_id")}, inverseJoinColumns = {
    @JoinColumn(name = "course_id")})
    
    private Set<Course> Courses = new HashSet<>(0);
    
    public Student() {
    
    }
    
    public Student(String name) {
        this.name = name;
    }

    public Set getCourses() {
        return Courses;
    }

    public void setCourses(Set Courses) {
        this.Courses = Courses;
    }
    
    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name=" + name + ", Courses=" + Courses + '}';
    }
}