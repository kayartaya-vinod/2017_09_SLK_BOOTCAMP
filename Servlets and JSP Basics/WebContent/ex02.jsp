<%@ include file="header.txt" %>

<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
	<form>
		<input type="text" placeholder="Enter user id" name="user_id" id="user_id">
		<input type="submit" class="btn btn-primary" name="submit" value="Get data">
	</form>
	<script> document.getElementById("user_id").focus(); </script>
	
	<%!

		Connection conn = null;
		public void jspInit(){
			System.out.println("Setting up a db connection...");
			
			try{
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/slk", "sa", "");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public void jspDestroy(){
			try {
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
	
	<%
		
		if(request.getParameter("submit")!=null){
			
			// handle FORM submission
			String userId = request.getParameter("user_id");
			String sql = "select * from contacts where user_id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				%>
				<h3 class="alert alert-info">Contact list for user id *<%=userId %>*</h3>
				<table class="table table-striped table-condensed table-bordered table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>PHone</th>
						</tr>
					</thead>
					<tbody>
				<%
				do {
					%>
					<tr>
						<td><%= rs.getString("name") %></td>
						<td><%= rs.getString("email") %></td>
						<td><%= rs.getString("phone") %></td>
					</tr>
					<%
				}while(rs.next());
				%>
					</tbody>
				</table>
				<%
			}
			else {
				// there is no data
				// give the error in a <h3>
				%>
				<h3 class="alert alert-danger">No data found for user id *<%=userId %>*</h3>
				<%
			}
		}
		
	%>
</div>
</body>
</html>











