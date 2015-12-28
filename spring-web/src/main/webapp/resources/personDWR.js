window.onload=function(){
	listPersons();
	listRoles();
}

function listRoles(){
	DWRService.listRolesWithPerson({
		callback: rolesList
	});

	function rolesList(roles){
		dwr.util.addOptions("role", roles, "roleId", "roleType");
	}
}

function listPersons(){
	var role = dwr.util.getValue("role") == null ? 0 : dwr.util.getValue("role");
	var column = dwr.util.getValue("column") == null ? "id" : dwr.util.getValue("column");
	var order = dwr.util.getValue("order") == null ? 1 : dwr.util.getValue("order");

	DWRService.listPerson(role, order, column, {
		callback: function(person){
			var cellFuncs = [
				function(data) { return data.id; },
				function(data) { return data.firstName; },
				function(data) { return data.lastName; },
				function(data) { return new Date(data.birthday).toISOString().slice(0,10); },
				function(data) { return data.gwa; },
				function(data) { return "<a href=\"person/edit/" + data.id + "\"/>Edit Person</a>"}
			];
			dwr.util.removeAllRows("person");
			dwr.util.addRows("person", person, cellFuncs, { escapeHtml:false });
		}
	});
}

function deletePerson(){
	if(confirm("Delete person?")){
		var personId = dwr.util.getValue("personId");
		DWRService.deletePerson(personId, {
			callback: function(){
				alert("Person successfully deleted!");
				listPersons();
				dwr.util.setValue("personId", '');
			},
			errorHandler: function(){
				alert("Error");
			}
		});
	}
}

