package tomlongridge.ringdb.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RINGERS")
public class Ringer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String firstName;
	
	@Column
	private String middleInitials;
	
	@Column
	private String surname;
	
}
