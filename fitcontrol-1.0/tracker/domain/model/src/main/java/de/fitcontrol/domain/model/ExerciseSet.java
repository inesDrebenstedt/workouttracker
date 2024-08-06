package de.fitcontrol.domain.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.fitcontrol.domain.model.enums.WeightUnit;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Document(collection = "exercisesets")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ExerciseSet {
	
    @Id
    @Getter
    private String id;
	
	@Getter
	@Setter
	private Double weight;
	
	@Getter
	@Setter
	private WeightUnit unit;
	
	@Setter
	@OneToMany
	private Set<Rep> reps;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private Integer numberOfReps;
	
	@ManyToOne
	@Getter
	private Exercise exercise;

	public Set<Rep> getReps () {
		if (this.reps == null) {
			this.reps = new HashSet<Rep>();
		}
		return reps;
	}

}
