package com.original.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_ROUTES")
public class Route implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(onMethod = @__({@JsonIgnore}))
	private Long id;
	
	@Column
	private String source;
	
	@Column
	private String target;
	
	@Column
	private int distance;
	
	@ManyToOne
	@JoinColumn(name = "graph_id", nullable = false)
	@Getter(onMethod = @__({@JsonIgnore}))
	private Graph graph;
	
	public boolean equals(Route route) {
		if (this.source.equals(route.source) && this.target.equals(route.target) && this.distance == route.getDistance()) {
			return true;
		} else {			
			return false;
		}
	}

}
