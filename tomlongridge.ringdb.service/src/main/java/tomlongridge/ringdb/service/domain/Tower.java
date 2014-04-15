package tomlongridge.ringdb.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name="TOWERS")
public class Tower extends ResourceSupport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String dedication;
	
	@Column
	private String location;
	
	@Column
	private String city;
	
	@JoinColumn
	@ManyToOne(fetch=FetchType.EAGER)
	private County county;
	
	@Column(name="num_bells")
	private int numBells;

	public long getID() {
		return id;
	}

	public String getDedication() {
		return dedication;
	}

	public void setDedication(String dedication) {
		this.dedication = dedication;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public int getNumBells() {
		return numBells;
	}

	public void setNumBells(int numBells) {
		this.numBells = numBells;
	}
	
}
