package de.fitcontrol.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.fitcontrol.domain.model.enums.MuscleGroup;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Document(collection = "exercises")
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
	
    @Id
    @Getter
    private String id;
	
	@Setter
	@OneToMany
	private Map<String, ExerciseSet> sets;
	
	@Getter
	@Setter
	private String title;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	@OneToMany
	private List<MuscleGroup> primaryMuscleGroups;
	
	@Getter
	@Setter
	@OneToMany
	private List<MuscleGroup> secondaryMuscleGroups;

	public Map<String, ExerciseSet> getSets() {
		if (this.sets == null) {
			this.sets = new HashMap<String, ExerciseSet>();
		}
		return sets;
	}
	
}
