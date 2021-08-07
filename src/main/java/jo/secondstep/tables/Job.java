package jo.secondstep.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id", nullable = false)
	private Integer id;
	@Column(name = "job_title",nullable = false)
	private String title;
	@Column(name = "min_salary")
	private Double minSalary;
	@Column(name = "max_salary")
	private Double maxSalary;

	
	
	
	public Job() {
	}
	
	

	public Job(String title, Double minSalary, Double maxSalary) {
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}



	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public Double getMinSalary() {
		return minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}


	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + "]";
	}

}
