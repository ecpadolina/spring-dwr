jq(document).ready(function(){
	jq("#test").click(function(){
		var test = [];
		jq('[name="contact"').each(function(index){
			test.push({"number": jq(this).val()});
		});
		console.log(test);
	});
});

window.onload=function(){
	listPersons();
	listRoles();
}

function listRoles(){
	personDWRService.listRolesWithPerson({
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

	personDWRService.listPerson(role, order, column, {
		callback: function(person){
			var cellFuncs = [
				function(data) { return data.id; },
				function(data) { return data.firstName; },
				function(data) { return data.lastName; },
				function(data) { return new Date(data.birthday).toISOString().slice(0,10); },
				function(data) { return data.gwa; },
			];
			dwr.util.removeAllRows("person");
			dwr.util.addRows("person", person, cellFuncs, { escapeHtml:false });
		}
	});
}

function deletePerson(){
	if(confirm("Delete person?")){
		var personId = jq("#personId").val();
		personDWRService.deletePerson(personId, {
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
