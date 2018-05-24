<%@ include file="header.txt" %>

<h3 class="alert alert-info text-center">${pageTitle}</h3>
<form class="form-horizontal" method="POST" action="save-contact">

<input type="hidden" name="id" value="${contact.id}">
<input type="hidden" name="user_id" value="${contact.userId}">

  <div class="form-group">
    <label for="name" class="col-sm-3 control-label">Name</label>
    <div class="col-sm-7">
      <input type="text" disabled value="${contact.name}" class="form-control" id="name" name="name" placeholder="Name">
    </div>
  </div>
	<script>$("#name").focus()</script>
  <div class="form-group">
    <label for="name" class="col-sm-3 control-label">Gender</label>
    <div class="col-sm-7">
      <label><input type="radio" disabled name="gender" value="M" 
      	${contact.gender=="M" ? "checked" : "" }> Male</label>
      <label><input type="radio" disabled name="gender" value="F" 
      	${contact.gender=="F" ? "checked" : "" }> Female</label>
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-3 control-label">Email address</label>
    <div class="col-sm-7">
      <input type="email" disabled value="${contact.email}"  class="form-control" id="email" name="email" placeholder="Email address">
    </div>
  </div>

  <div class="form-group">
    <label for="phone" class="col-sm-3 control-label">Phone number</label>
    <div class="col-sm-7">
      <input type="text" disabled value="${contact.phone}"  class="form-control" id="phone" name="phone" placeholder="Phone number">
    </div>
  </div>

  <div class="form-group">
    <label for="address" class="col-sm-3 control-label">Address</label>
    <div class="col-sm-7">
      <input type="text" disabled value="${contact.address}"  class="form-control" id="address" name="address" placeholder="Address">
    </div>
  </div>

  <div class="form-group">
    <label for="city" class="col-sm-3 control-label">City</label>
    <div class="col-sm-6">
      <input type="text" disabled value="${contact.city}"  class="form-control" id="city" name="city" placeholder="City">
    </div>
  </div>

  <div class="form-group">
    <label for="state" class="col-sm-3 control-label">State</label>
    <div class="col-sm-6">
      <input type="text" disabled value="${contact.state}"  class="form-control" id="state" name="state" placeholder="State">
    </div>
  </div>

  <div class="form-group">
    <label for="country" class="col-sm-3 control-label">Country</label>
    <div class="col-sm-6">
      <input type="text" disabled value="${contact.country}"  class="form-control" id="country" name="country" placeholder="Country">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-9">
		<a href="edit-contact?id=${contact.id}" title="Edit details" class="btn btn-primary">
			<span class="glyphicon glyphicon-pencil"></span> Edit
		</a>
		<a href="delete-contact?id=${contact.id}" class="btn btn-danger"
      		onclick="return confirm('Are you sure to delete this?')">
      		<span class="glyphicon glyphicon-trash"></span> Delete
      	</a>
    </div>
  </div>
</form>
<%@ include file="footer.txt" %>