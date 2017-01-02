package pk.edu.nust.seecs.gradebook.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
public class Teacher implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column
    private String name;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Course> Courses = new HashSet<>(0);
    
    public Teacher() {
    
    }
    
    public Teacher(String name) {
        this.name = name;
    }
    
    public Integer getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getCourses() {
        return Courses;
    }

    public void setCourses(Set Courses) {
        this.Courses = Courses;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherId=" + teacherId + ", name=" + name + ", Courses=" + Courses + '}';
    }
}