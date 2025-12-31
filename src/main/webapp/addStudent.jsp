<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Add Student</h2>

    <form action="<%=application.getContextPath() %>/addStudent" method="post">
        <label>Name</label>
        <input type="text" name="name" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Age</label>
        <input type="number" name="age" required>

        <button type="submit">Save Student</button>
    </form>

    <a href="index.jsp">Back to Home</a>
</div>

</body>
</html>
