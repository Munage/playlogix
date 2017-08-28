
<%@ page import="playlogixskillstest.Watch" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'watch.label', default: 'Watch')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-watch" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-watch" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list watch">
			
				<g:if test="${watchInstance?.brand}">
				<li class="fieldcontain">
					<span id="brand-label" class="property-label"><g:message code="watch.brand.label" default="Brand" /></span>
					
						<span class="property-value" aria-labelledby="brand-label"><g:fieldValue bean="${watchInstance}" field="brand"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${watchInstance?.model}">
				<li class="fieldcontain">
					<span id="model-label" class="property-label"><g:message code="watch.model.label" default="Model" /></span>
					
						<span class="property-value" aria-labelledby="model-label"><g:fieldValue bean="${watchInstance}" field="model"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${watchInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="watch.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${watchInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${watchInstance?.warranty}">
				<li class="fieldcontain">
					<span id="warranty-label" class="property-label"><g:message code="watch.warranty.label" default="Warranty" /></span>
					
						<span class="property-value" aria-labelledby="warranty-label"><g:fieldValue bean="${watchInstance}" field="warranty"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:watchInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${watchInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
