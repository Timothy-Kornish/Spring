<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student Regristration Here</title>
	</head>
	<body>
		<form:form action = "processForm" modelAttribute = "student">
		
			First Name: <form:input path = "firstName" />
			<br><br>
			Last Name: <form:input path = "lastName" />
			<br><br>
			
			Country:
			<form:select path = "country">
				<form:options items = "${student.countryOptions}" />			
			</form:select>
			<br><br>
			
			Favorite Programming Language: 
			<br><br>
			Java <form:radiobutton path = "favoriteLanguage" value = "Java" />
			C++ <form:radiobutton path = "favoriteLanguage" value = "C++" />
			Python <form:radiobutton path = "favoriteLanguage" value = "Python" />
			JavaScript <form:radiobutton path = "favoriteLanguage" value = "JavaScript" />
			C# <form:radiobutton path = "favoriteLanguage" value = "C#" />
			<br><br>
			
			Operating Systems:
			<br><br>
			Linux <form:checkbox path="operatingSystems" value = "Linux"/>
			Mac OS <form:checkbox path="operatingSystems" value = "Mac OS"/>
			Windows <form:checkbox path="operatingSystems" value = "Windows"/>
			<br><br>
			
			<input type = "submit" value = "Submit" />
			<br><br>
		</form:form>

	</body>
</html>