<#ftl encoding='UTF-8'>
<head>
    <head>
        <title>Sign In</title>
        <link href="/css/formStyle.css" rel="stylesheet" type="text/css">
    </head>
</head>
<body>
<#if model.error.isPresent()>
<div class="alert alert-danger" role="alert">Incorrect login or password</div>
</#if>
<div class="form-style-6">
    <form action="/signIn" method="post">
        <input name="login" placeholder="Login">
        <input name="password" placeholder="Password">
        <input type="submit">
    </form>
    <a href="/signUp">Go to SignUp</a>
</div>
</body>

