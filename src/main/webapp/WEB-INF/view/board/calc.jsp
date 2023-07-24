<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
    <h2>계산기</h2>
    <form method="post" action="/bbs/CalcServlet">
    	<input type="number" name="num1">
		<select name="operator">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
    	<input type="number" name="num2">
        <input type="submit" value="=">
    	<input type="number" name="result">
    </form>
    <hr>
</body>
</html>