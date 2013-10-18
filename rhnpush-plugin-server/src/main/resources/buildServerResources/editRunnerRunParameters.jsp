<%@ page import="com.miltrex.tc.rhnpush.PluginConstants" %>
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
            <label for="<%=PluginConstants.PROPERTY_SERVER%>">Host name: </label>
        </th>
        <td>
            <props:textProperty name="<%=PluginConstants.PROPERTY_SERVER%>" className="longField"/>
            <span class="error" id="error_<%=PluginConstants.PROPERTY_SERVER%>"></span>
             <span class="smallNote">
                 The satellite server to publish these RPMs to.
             </span>
        </td>
    </tr>

    <tr>
        <th>
            <label for="<%=PluginConstants.PROPERTY_USERNAME%>">Username: </label>
        </th>
        <td>
            <props:textProperty name="<%=PluginConstants.PROPERTY_USERNAME%>" className="longField"/>
            <span class="error" id="error_<%=PluginConstants.PROPERTY_USERNAME%>"></span>
            <span class="smallNote">
                 The username to authenticate to the satellite server as.
            </span>
        </td>
    </tr>

    <tr>
        <th>
            <label for="<%=PluginConstants.PROPERTY_PASSWORD%>">Password: </label>
        </th>
        <td>
            <props:passwordProperty name="<%=PluginConstants.PROPERTY_PASSWORD%>" className="longField"/>
            <span class="error" id="error_<%=PluginConstants.PROPERTY_PASSWORD%>"></span>
            <span class="smallNote">
                 The password to authenticate to the satellite server with.
            </span>
        </td>
    </tr>

    <tr>
        <th>
            <label for="<%=PluginConstants.PROPERTY_CHANNEL%>">Channel: </label>
        </th>
        <td>
            <props:textProperty name="<%=PluginConstants.PROPERTY_CHANNEL%>" className="longField"/>
            <span class="error" id="error_<%=PluginConstants.PROPERTY_CHANNEL%>"></span>
            <span class="smallNote">
                 Comma separated list of channel names.
            </span>
        </td>
    <tr>
</l:settingsGroup>
<l:settingsGroup title="Deployment Source">
    <tr>
        <th><label for="jetbrains.buildServer.deployer.sourcePath">Artifacts path: </label></th>
        <td>
            <props:multilineProperty name="<%=PluginConstants.PROPERTY_PARAM_SOURCE_PATH%>" className="longField" cols="30" rows="4" expanded="true" linkTitle="Enter artifacts paths"/>
            <span class="smallNote">New line or comma separated paths to build artifacts. Ant-style wildcards like dir/**/*.rpm and target directories like *.rpm => winFiles,unix/distro.rpm => linuxFiles, where winFiles and linuxFiles are target directories are supported.
            <bs:help file="Configuring+General+Settings" anchor="artifactPaths"/></span>
        </td>
    </tr>
</l:settingsGroup>
<l:settingsGroup title="Additional configuration">
    <tr>
        <th>
            <label for="<%=PluginConstants.PROPERTY_NOGPG%>">Deploy non-GPG signed artifacts: </label>
        </th>
        <td>
            <props:checkboxProperty name="<%=PluginConstants.PROPERTY_NOGPG%>"/>
            <span class="error" id="error_<%=PluginConstants.PROPERTY_NOGPG%>"></span>
            <span class="smallNote">
                 Deploy even if artifacts are not GPG signed.
            </span>
        </td>
    <tr>
    <tr>
        <th>
            <label for="<%=PluginConstants.PROPERTY_VERBOSE%>">Verbose: </label>
        </th>
        <td>
            <props:checkboxProperty name="<%=PluginConstants.PROPERTY_VERBOSE%>" />
            <span class="error" id="error_<%=PluginConstants.PROPERTY_VERBOSE%>"></span>
            <span class="smallNote">
                 Increase verbosity
            </span>
        </td>
    <tr>
</l:settingsGroup>