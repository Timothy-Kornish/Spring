package com.timothyKornish.springDemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext ConstraintValidatorContext) {
		boolean result = false;
		
		if(theCode != null) {
			// looping through course prefix codes
			for(String tempPrefix: coursePrefix) {
				result = theCode.startsWith(tempPrefix);
				// if a match is found, break the loop
				if(result) {
					break;
				}
			}
			
		} else {
			result = true;
		}
		return result;
	}

}
