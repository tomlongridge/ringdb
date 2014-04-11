package tomlongridge.ringdb.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TOWERS")
public class Tower {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String dedication;
	
	@Column
	private String location;
	
	@Column
	private String city;
	
	@Column
	private String county;
	
	@Column
	private String country;
	
	@Column
	private int numBells;
	
}
