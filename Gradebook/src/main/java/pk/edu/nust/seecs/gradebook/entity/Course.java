package pk.edu.nust.seecs.gradebook.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Course implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private Integer courseid;
    @Column
    private String classtitle;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startsOn;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endsOn;
    @Column
    private int creditHours;
    
    @OneToMany(mappedBy = "course",cascade = {CascadeType.ALL})
    private Set<Content> contents = new HashSet<>(0);

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="teacher_id",nullable=false)
    private Teacher teacher;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "course_students", joinColumns = {
        @JoinColumn(name = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "student_id")})
    private Set<Student> students = new HashSet<>(0);
    
    public Course() {
    
    }
    
    public Course(String classtitle, Date starttime, Date endtime, int creditHours) {
        this.classtitle = classtitle;
        this.startsOn = starttime;
        this.endsOn = endtime;
        this.creditHours = creditHours;
    }
    
    public Integer getCourseid() {
        return courseid;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getClasstitle() {
        return classtitle;
    }

    public void setClasstitle(String classtitle) {
        this.classtitle = classtitle;
    }

    public Date getStartsOn() {
        return startsOn;
    }

    public void setStartsOn(Date startsOn) {
        this.startsOn = startsOn;
    }

    public Date getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(Date endsOn) {
        this.endsOn = endsOn;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public Set getContents() {
        return contents;
    }

    public void setContents(Set contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Course{" + "courseid=" + courseid + ", classtitle=" + classtitle + ", startsOn=" + startsOn + ", endsOn=" + endsOn + ", creditHours=" + creditHours + ", contents=" + contents + ", teacher=" + teacher + ", students=" + students + '}';
    }
}