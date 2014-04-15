package tomlongridge.ringdb.service.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PEALS")
public class Peal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private Date date;
	
	@JoinColumn
	@ManyToOne(fetch = FetchType.LAZY)
	private Tower tower;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name = "PEAL_RINGERS",
		joinColumns =
		{
			@JoinColumn(name = "ringer_id", nullable = false, updatable = false)
		},
		inverseJoinColumns = 
		{
			@JoinColumn(name = "peal_id", nullable = false, updatable = false)
		}
	)
	private List<Ringer> ringers;
	
	@Column
	private int duration;
	
	@Column
	@OneToMany(fetch = FetchType.LAZY, mappedBy="peal")
	private List<Footnote> footnotes;
}
