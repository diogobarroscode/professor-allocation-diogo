package professor.allocation.diogo.entity;

import java.time.DayOfWeek;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "allocation")
public class Allocation {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "day", nullable = false)
	private DayOfWeek day;
	
	@ApiModelProperty(example = "19:00-0300")
    @JsonFormat(pattern = "HH:mmZ")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Temporal(TemporalType.TIME)
	@Column(name = "start", nullable = false)
	private Date start;
	
	@ApiModelProperty(example = "22:00-0300")
    @JsonFormat(pattern = "HH:mmZ")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Temporal(TemporalType.TIME)
	@Column(name = "end", nullable = false)
	private Date end;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "course_id", nullable = false)
	private Long courseId;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "professor_id", nullable = false)
	private Long professorId;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnoreProperties({"allocations"})
	@ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
    private Course course;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnoreProperties({"allocations"})
	@ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", nullable = false, insertable = false, updatable = false)
    private Professor professor;
	
	public Allocation() {
		super();
	}

	public Allocation(Long id, DayOfWeek day, Date start, Date end, Long courseId, Long professorId) {
		super();
		this.id = id;
		this.day = day;
		this.start = start;
		this.end = end;
		this.courseId = courseId;
		this.professorId = professorId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return day;
	}

	public void setDayOfWeek(DayOfWeek day) {
		this.day = day;
	}

	public Date getStartHour() {
		return start;
	}

	public void setStartHour(Date start) {
		this.start = start;
	}

	public Date getEndHour() {
		return end;
	}

	public void setEndHour(Date end) {
		this.end = end;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", day=" + day + ", start=" + start + ", end=" + end + ", courseId=" + courseId
				+ ", professorId=" + professorId + "]";
	}
	
	
}
