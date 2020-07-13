package com.ibm;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	public PathologyResource() {
		// TODO Auto-generated constructor stub
	}

	
	List<Disease> diseases = Arrays.asList(
			new Disease("D1","Astama", "Warm Water Bath"),
			new Disease("D2","Headache", "Hot water Vapour"),
			new Disease("D3", "Corona", "Wash Hands properly")
			);
	
	
	@RequestMapping("/diseases")
	public DiseaseList getemployees() {
		DiseaseList diseaseList = new DiseaseList();
		
		diseaseList.setDiseases(diseases);
		return diseaseList;
	}
	
	
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {
		Disease d = diseases.stream()
				    .filter(disease -> Id.equals(disease.getId()))
				    .findAny()
				    .orElse(null);
		
		return d;
	}
}
