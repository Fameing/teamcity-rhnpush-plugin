<%@ page import="com.miltrex.tc.rhnpush.PluginConstants" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<props:viewWorkingDirectory />

<%--<div class="parameter">
    Execute rhnpush path: <strong><props:displayValue name="rhnpush.path" /></strong>
</div>--%>

<div class="parameter">
    Host name: <strong><props:displayValue name="<%=PluginConstants.PROPERTY_SERVER%>" /></strong>
</div>

<div class="parameter">
    Username: <strong><props:displayValue name="<%=PluginConstants.PROPERTY_USERNAME%>" /></strong>
</div>

<div class="parameter">
    Password: <strong><props:displayValue name="<%=PluginConstants.PROPERTY_PASSWORD%>" /></strong>
</div>

<div class="parameter">
    Channel: <strong><props:displayValue name="<%=PluginConstants.PROPERTY_CHANNEL%>" /></strong>
</div>

<div class="parameter">
    Source: <strong><props:displayValue name="<%=PluginConstants.PROPERTY_PARAM_SOURCE_PATH%>" emptyValue="none"/></strong>
</div>

<div class="parameter">
    Deploy non-GPG signed artifacts: <strong><props:displayValue name="<%=PluginConstants.PROPERTY_NOGPG%>" /></strong>
</div>

<div class="parameter">
    Verbose: <strong><props:displayValue name="<%=PluginConstants.PROPERTY_VERBOSE%>" /></strong>
</div>

