<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %><%
  String message = (String)request.getAttribute("message");
  String redirectUrl = (String)request.getAttribute("redirectUrl");
%><script>
if("<%=message%>" !== "") {
  alert("<%=message%>");
}
document.location.replace("<%=redirectUrl%>");
</script>