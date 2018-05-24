<%@ include file="header.txt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 class="alert alert-info text-center">${pageTitle}</h3>
<form class="form-horizontal" method="POST" action="save-contact.action">

<input type="hidden" name="id" value="${contact.id}">
<input type="hidden" name="user_id" value="${contact.userId}">

  <div class="form-group">
    <label for="name" class="col-sm-3 control-label">Name</label>
    <div class="col-sm-7">
      <input type="text" value="${contact.name}" class="form-control" id="name" name="name" placeholder="Name">
    </div>
  </div>
	<script>$("#name").focus()</script>
  <div class="form-group">
    <label for="name" class="col-sm-3 control-label">Gender</label>
    <div class="col-sm-7">
      <label><input type="radio" name="gender" value="M" 
      	${contact.gender=="M" ? "checked" : "" }> Male</label>
      <label><input type="radio" name="gender" value="F" 
      	${contact.gender=="F" ? "checked" : "" }> Female</label>
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-3 control-label">Email address</label>
    <div class="col-sm-7">
      <input type="email" value="${contact.email}"  class="form-control" id="email" name="email" placeholder="Email address">
    </div>
  </div>

  <div class="form-group">
    <label for="phone" class="col-sm-3 control-label">Phone number</label>
    <div class="col-sm-7">
      <input type="text" value="${contact.phone}"  class="form-control" id="phone" name="phone" placeholder="Phone number">
    </div>
  </div>

  <div class="form-group">
    <label for="address" class="col-sm-3 control-label">Address</label>
    <div class="col-sm-7">
      <input type="text" value="${contact.address}"  class="form-control" id="address" name="address" placeholder="Address">
    </div>
  </div>

  <div class="form-group">
    <label for="city" class="col-sm-3 control-label">City</label>
    <div class="col-sm-6">
      <input type="text" value="${contact.city}"  class="form-control" id="city" name="city" placeholder="City">
    </div>
  </div>

  <div class="form-group">
    <label for="state" class="col-sm-3 control-label">State</label>
    <div class="col-sm-6">
      <input type="text" value="${contact.state}"  class="form-control" id="state" name="state" placeholder="State">
    </div>
  </div>

  <div class="form-group">
    <label for="country" class="col-sm-3 control-label">Country</label>
    <div class="col-sm-6">
      <input type="text" value="${contact.country}"  class="form-control" id="country" name="country" placeholder="Country">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-9">
      <button type="submit" class="btn btn-primary">Save</button>
      <c:choose>
      	<c:when test="${contact.id==0}">
      		<a href="view-all.action">Cancel</a>
      	</c:when>
      	<c:otherwise>
      		<a href="view-contact.action?id=${contact.id}">Cancel</a>
      	</c:otherwise>
      </c:choose>
      
    </div>
  </div>
</form>
<%@ include file="footer.txt" %>