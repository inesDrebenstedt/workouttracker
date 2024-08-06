package de.fitcontrol.adapter.restapi.controller.json;

import java.util.ArrayList;
import java.util.List;

import de.fitcontrol.domain.model.Rep;
import de.fitcontrol.domain.model.enums.RepCategory;

public class RepJson {
	
	private RepCategory category;
	
	public RepJson(Rep rep) {
		this.category  = rep.getCategory();
	}
	
	public static List<RepJson> from(List<Rep> reps) {
		List<RepJson> repsJson = new ArrayList<>();
		reps.forEach(rep -> repsJson.add(new RepJson(rep)));
		return repsJson;
	}

}
