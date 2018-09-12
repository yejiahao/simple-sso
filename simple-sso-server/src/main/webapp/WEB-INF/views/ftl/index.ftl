<html>
<head>
    <title>auth center</title>
</head>
<body>
<div>
    <form id="login" action="/login" method="post">
        <span>username:</span><input type="text" name="username" value=""/><br/>
        <span>password:</span><input type="password" name="password" value=""/><br/>
        <input type="hidden" name="clientUrl" value="${clientUrl!}"/>
        <input type="submit" value="Login"/>
    </form>
</div>
</body>
</html>