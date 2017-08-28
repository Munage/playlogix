
<%@ page import="playlogixskillstest.Watch" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'watch.label', default: 'Watch')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-watch" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-watch" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="brand" title="${message(code: 'watch.brand.label', default: 'Brand')}" />
					
						<g:sortableColumn property="model" title="${message(code: 'watch.model.label', default: 'Model')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'watch.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="warranty" title="${message(code: 'watch.warranty.label', default: 'Warranty')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${watchInstanceList}" status="i" var="watchInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${watchInstance.id}">${fieldValue(bean: watchInstance, field: "brand")}</g:link></td>
					
						<td>${fieldValue(bean: watchInstance, field: "model")}</td>
					
						<td>${fieldValue(bean: watchInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: watchInstance, field: "warranty")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${watchInstanceCount ?: 0}" />
			</div>


            <g:form name="search" action="search" style="margin: 20px;">
                <h2>Search</h2>

                <div>
                    <g:checkBox name="brand" value="Swatch" checked="${params.brand?.contains('Swatch')}"/> Swatch <br/>
                    <g:checkBox name="brand" value="Rolex" checked="${params.brand?.contains('Rolex')}" /> Rolex
                </div>
                <g:submitButton name="submit" />
            </g:form>


        </div>
	</body>
</html>
