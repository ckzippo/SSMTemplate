<a href="/api/user/1">Get</a>

<form action="/api/user/" method="post">
    <input type="text" name="id" value="2"/>
    <input type="submit" value="发送POST请求"/>
</form>

<form action="rest/restPut" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="text" name="id" value="3">
    <input type="submit" value="发送PUT请求">
</form>


<form action="rest/restDelete" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="text" name="id" value="4">
    <input type="submit" value="发送DELETE请求">
</form>