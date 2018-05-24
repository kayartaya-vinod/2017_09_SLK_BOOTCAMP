<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:choose>
	<c:when test="${sessionScope.names==null || fn:length(sessionScope.names)==0}">
		<h3>No names in your list!!</h3>
	</c:when>
	
	<c:otherwise>
		<h3>The names in your list are:</h3>
		<ol>
			<c:forEach items="${sessionScope.names}" var="name">
				<li>${name}</li>
			</c:forEach>
		</ol>	
	</c:otherwise>
</c:choose>
