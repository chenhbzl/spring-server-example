<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Mobile Report Service</title>
    </head>
    <body>
        <center>
            free memory: <c:out value="${freeMemory}" /><br>
            total memory: <c:out value="${totalMemory}" /><br>
            <form name="groovy" action="ms" mothod="post">
                <table width="60%">
                    <tr><td align="left">groovy</td></tr>
                    <tr><td align="left"><c:out value="${groovyOutput}" /></td></tr>
                    <tr><td align="left"><textarea name="groovyInput" type="textarea" cols="80" rows="10"><c:out value="${groovyInput}" /></textarea></td></tr>
                    <tr><td align="left"><input type="submit" value="groovy" /></td></tr>
                </table>
            </form>

        </center>
    </body>
</html>