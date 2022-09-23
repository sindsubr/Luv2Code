# Luv2Code

### Spring Core:


### Spring MVC:

web.xml,servlet.xml -> configuration

controller,view

Model(data container)

add resources(images,js,css) in WebContent/resources ->

<code><mvc:resources mapping="resources/*" location="/resources/"></mvc:resources> ->${pageContext.request.contextPath}

@Controller
@RequestMapping
@RequestParam

<b> Spring MVC Tags: </b>

<i><%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>


<%@ taglib uri = "http://java.sun.java.com/jsp/jstl/core " prefix = "c" %><br></i>

add properties file in /WEB-INF/filename.properties ->
<util:properties id = "" location="classpath:..filename/.properties">

<b>Validation: </b> hibernate-validator 6.2 for javax spring 5 suppot

@NotNull
@NotBlank
@Min@Max
@Past@Future
@Pattern

Controller -> @Valid@ModelAttribute->BindingResult
whitespace problem -> @InitBinder -> WebDataBinder,StringTrimmerEditor

Handling Custom Error Messages: create bean for ResourceBundleMessageSource

custom validation : @Interface,ConstraintValidator

<b>File Upload:</b>

Multipart/formdata enc type
create bean for CommonsMultiPartResolver
CommonsMultiPartFile
