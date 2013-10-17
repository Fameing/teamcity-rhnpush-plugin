<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>

<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<l:settingsGroup title="Satellite server configuration">
    <forms:workingDirectory />

<%--    <tr>
        <th>
            <label for="rhnpush.path">Execute rhnpush path: </label>
        </th>
        <td>
            <props:textProperty name="rhnpush.path" className="longField"/>
            <span class="error" id="error_hnpush.path"></span>
        <span class="smallNote">
             Execute bin path to rhnpush.
        </span>
        </td>
    </tr>--%>

    <tr>
        <th>
            <label for="rhnpush.server">Host name: </label>
        </th>
        <td>
            <props:textProperty name="rhnpush.server" className="longField"/>
            <span class="error" id="error_rhnpush.server"></span>
             <span class="smallNote">
                 The satellite server to publish these RPMs to.
             </span>
        </td>
    </tr>

    <tr>
        <th>
            <label for="rhnpush.username">Username: </label>
        </th>
        <td>
            <props:textProperty name="rhnpush.username" className="longField"/>
            <span class="error" id="error_rhnpush.username"></span>
            <span class="smallNote">
                 The username to authenticate to the satellite server as.
            </span>
        </td>
    </tr>

    <tr>
        <th>
            <label for="rhnpush.password">Password: </label>
        </th>
        <td>
            <props:passwordProperty name="rhnpush.password" className="longField"/>
            <span class="error" id="error_rhnpush.password"></span>
            <span class="smallNote">
                 The password to authenticate to the satellite server with.
            </span>
        </td>
    </tr>

    <tr>
        <th>
            <label for="rhnpush.channel">Channel: </label>
        </th>
        <td>
            <props:textProperty name="rhnpush.channel" className="longField"/>
            <span class="error" id="error_rhnpush.channel"></span>
            <span class="smallNote">
                 Comma separated list of channel names.
            </span>
        </td>
    <tr>
</l:settingsGroup>
<l:settingsGroup title="Additional configuration">
    <tr>
        <th>
            <label for="rhnpush.nogpg">Deploy non-GPG signed artifacts: </label>
        </th>
        <td>
            <props:checkboxProperty name="rhnpush.nogpg"/>
            <span class="error" id="error_rhnpush.nogpg"></span>
            <span class="smallNote">
                 Deploy even if artifacts are not GPG signed.
            </span>
        </td>
    <tr>
    <tr>
        <th>
            <label for="rhnpush.verbose">Verbose: </label>
        </th>
        <td>
            <props:checkboxProperty name="rhnpush.verbose" />
            <span class="error" id="error_rhnpush.verbose"></span>
            <span class="smallNote">
                 Increase verbosity
            </span>
        </td>
    <tr>
</l:settingsGroup>