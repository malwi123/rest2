
function PersonViewModel(model,parent){
	var p = parent;
	var listOfPeople='listOfPeople';
	ko.mapping.fromJS(model,{},this);
	var self = this;

	self.show = function(){
		alert(ko.mapping.toJSON(self));
	};
	self.deleteMe = function(){
		$.ajax({
            url: "http://localhost:8080/samplerestapp/rest/people/delete/"+self.id(),
            type: "DELETE",
            contentType: "application/json",
            success: function (data) {
                alert("udało się deleteMe");
                p.getData();
            },
            error: function (XMLHttpRequest, testStatus, errorThrown) {
               alert("nie udało się deleteMe");
               console.log(testStatus);
               console.log(errorThrown);
               console.log(XMLHttpRequest);

            }
        });
	};
	self.updateMe = function(){
		$.ajax({
            url: "http://localhost:8080/samplerestapp/rest/people/update/"+self.id(),
            type: "PUT",
            data: ko.mapping.toJSON(self),
            contentType: "application/json",
            success: function (data) {
                alert("udało się updateMe2");
                p.getData();
            },
            error: function (XMLHttpRequest, testStatus, errorThrown) {
               alert("nie udało się updateMe2");

            }
        });
	};
	self.add = function(){
		$.ajax({
            url: "http://localhost:8080/samplerestapp/rest/people/add",
            type: "POST",
            data: ko.mapping.toJSON(self),
            contentType: "application/json",
            success: function (data) {
                alert("udało się");
            },
            error: function (XMLHttpRequest, testStatus, errorThrown) {
                alert("nie udało się add")
             }
        });
	}
}