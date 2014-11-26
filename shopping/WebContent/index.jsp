<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<s:debug></s:debug>
<h1><s:property value="#session.currentUser.username"/>欢迎登陆</h1>
<table>
<tr>
<th>名称</th><th>描述</th><th>价格</th>
</tr>
<s:iterator value="#session.products" >
<tr>
<td><s:property value="pname"/></td>
<td><s:property value="pdesc"/></td>
<td><s:property value="pprice"/></td>
<s:checkbox  name="checkbox" value="true"/>
</tr>
</s:iterator>
</table>
<s:submit value="加入购物车"></s:submit>
</body>
</html>