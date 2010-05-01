<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Search Results:</title>
	<s:head />
</head>
<body>
	<p>Books matching <s:property value="searchTerm"/></p><br/>
    <s:if test="books.size > 0">
		<table>
			<s:iterator value="books">
				<tr id="row_<s:property value="id"/>">
					<td>
						<s:property value="title" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</body>
</html>
