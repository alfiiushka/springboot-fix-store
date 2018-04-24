<#ftl encoding='UTF-8'>
<head>
    <head>
        <title>Sign Up</title>
        <link href="/css/formStyle.css" rel="stylesheet" type="text/css">
    </head>
</head>
<body>
<#if error??>
<div class="alert alert-danger" role="alert">${error}</div>
</#if>
<div class="form-style-6">
    <form action="/signUp" method="post">
        <input name="login" placeholder="Login">
        <input name="password" placeholder="Password">
        <input type="submit">
    </form>
    <a href="/signIn">Go to SignIn</a>
</div>
</body>