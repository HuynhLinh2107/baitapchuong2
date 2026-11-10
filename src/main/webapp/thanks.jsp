<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/styles/main.css">
</head>

<body>

    <h1>Thanks for joining our email list!</h1>

    <p>Here is the information that you entered:</p>

    <label>Email:</label>
    <span>${user.email}</span>
    <br><br>

    <label>First Name:</label>
    <span>${user.firstName}</span>
    <br><br>

    <label>Last Name:</label>
    <span>${user.lastName}</span>
    <br><br>

    <p>
        To enter another email address,
        click the Return button below.
    </p>

    <form action="${pageContext.request.contextPath}/"
          method="get">

        <input type="submit" value="Return">

    </form>

</body>
</html>
