package de.fitcontrol.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import de.fitcontrol.domain.model.enums.RepCategory;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Document(collection = "exercisereps")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Rep {
	
	@Getter
	@Setter
	private RepCategory category;
	
	@Getter
	@ManyToOne
	private ExerciseSet exerciseSet;
	
}
