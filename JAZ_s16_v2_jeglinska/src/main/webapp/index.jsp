<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/templates" %>    
<t:layout>
	<jsp:attribute name="styles">
		<!-- put your styles here -->
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script type="text/javascript">
		$.ajax({
            url: "http://localhost:8080/samplerestapp/rest/service/test",
            type: "POST",
            data: ko.toJSON({
            	messege:"hello3"
            }),
            contentType: "application/json",
            success: function (data) {
                alert("udało siddd ");
            },
            error: function (XMLHttpRequest, testStatus, errorThrown) {
               alert("nie udało się 4");
               console.log("nie udało się 44");
               console.log(testStatus);
               console.log(errorThrown);
               console.log(XMLHttpRequest);

            }
        });
			
		</script>	
		
	</jsp:attribute>
	<jsp:body>
		Hello World
	</jsp:body>
	
</t:layout>