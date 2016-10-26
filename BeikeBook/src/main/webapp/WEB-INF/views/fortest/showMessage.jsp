<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>${ message }</h2>
	<img src="<c:url value='/images/${imagesFile}'/>">
</body>
</html>