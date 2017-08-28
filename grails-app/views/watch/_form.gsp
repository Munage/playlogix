<%@ page import="playlogixskillstest.Watch" %>



<div class="fieldcontain ${hasErrors(bean: watchInstance, field: 'brand', 'error')} required">
	<label for="brand">
		<g:message code="watch.brand.label" default="Brand" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="brand" required="" value="${watchInstance?.brand}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: watchInstance, field: 'model', 'error')} required">
	<label for="model">
		<g:message code="watch.model.label" default="Model" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="model" required="" value="${watchInstance?.model}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: watchInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="watch.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: watchInstance, field: 'price')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: watchInstance, field: 'warranty', 'error')} required">
	<label for="warranty">
		<g:message code="watch.warranty.label" default="Warranty" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="warranty" type="number" min="0" value="${watchInstance.warranty}" required=""/>

</div>

