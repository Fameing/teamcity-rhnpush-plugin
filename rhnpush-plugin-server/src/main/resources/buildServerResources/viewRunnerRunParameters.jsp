<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<props:viewWorkingDirectory />

<%--<div class="parameter">
    Execute rhnpush path: <strong><props:displayValue name="rhnpush.path" /></strong>
</div>--%>

<div class="parameter">
    Host name: <strong><props:displayValue name="rhnpush.server" /></strong>
</div>

<div class="parameter">
    Username: <strong><props:displayValue name="rhnpush.username" /></strong>
</div>

<div class="parameter">
    Password: <strong><props:displayValue name="rhnpush.password" /></strong>
</div>

<div class="parameter">
    Channel: <strong><props:displayValue name="rhnpush.channel" /></strong>
</div>

<div class="parameter">
    Deploy non-GPG signed artifacts: <strong><props:displayValue name="rhnpush.nogpg" /></strong>
</div>

<div class="parameter">
    Verbose: <strong><props:displayValue name="rhnpush.verbose" /></strong>
</div>

