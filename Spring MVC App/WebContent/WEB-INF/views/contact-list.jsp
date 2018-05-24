<%@ include file="header.txt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table id="tblContacts" class="table table-striped table-bordered table-condensed table-hover">
	<thead>
		<tr>
			<td>Name</td>
			<td>Email address</td>
			<td>Phone number</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contacts}" var="ct">
		<tr>
			<td>
			<a href="view-contact.action?id=${ct.id}">${ct.gender=="M" ? "Mr." : "Ms." } ${ct.name}</a>
			</td>
			<td>${ct.email}</td>
			<td>${ct.phone}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="footer.txt"%>