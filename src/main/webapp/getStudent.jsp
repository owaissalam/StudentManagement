<!DOCTYPE html>
<html>
<head>
    <title>Get Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Get Student</h2>

    <form action="<%=application.getContextPath() %>/getStudent" method="get">
        <label>Enter student ID : </label>
        <input type="number" name="id" required>

        <button type="submit">Find Student</button>
    </form>

    <a href="index.jsp">Back to Home</a>
</div>

</body>
</html>
