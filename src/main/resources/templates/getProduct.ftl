<html>
<head>
    <title>Products</title>
    <link href="/css/formStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-6">
    <h1>Products list</h1>
    <table>
        <tr>
            <th>Product name</th>
        </tr>
        <#list productList as product>
            <tr>
                <td>${product.name}</td>
            </tr>
        </#list>
    </table>
    <a href="/save-product">Go to adding products</a>
    <a href="/logout">Exit</a>
</div>

</body>

</html>