<%@ page import="grails.converters.JSON" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Grails Shell</title>
        <g:javascript library="jquery"/>
        <script type="text/javascript">
            function listOrders() {
                alert("listOrders()");
            }

            function listCustomers() {
//                alert("listCustomers()");
            }

            function listItems() {
//                alert("listItems()");
            }
        </script>

        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            function loadMiniDash() {
                // http://docs.grails.org/2.4.4/ref/Tags/remoteFunction.html
                // oh yay
                // https://stackoverflow.com/questions/36668645/springboot-gsp-tag-form-does-not-exist-no-tag-library-found-for-namespace
                %{--<g:link controller="index" action="updateMiniDashItems" update="listItems"/>--}%
                %{--document.getElementById("listItems").innerHTML = <f:table collection="itemsList" domainClass="com.cmt.Items"/>;--}%
            }

            //            $("#listOrders").ready(function () {
            //                listOrders();
            //            });

            $(function () {
                $.ajax({
                    url: "${createLink(controller:'customers',action:'updateMiniDashCustomers')}",
                    type: "get",
                    dataType: 'json',
                    success: function(data) {
                        console.log(data);
//                        $("#listOrders").text("List of Orders:");
//                        listOrders();

                        $("#listCustomers").text("List of Customers:");
                        listCustomers();

                        $.each(data, function (index, values) {
//                            alert( index + ": " + values);
                            document.getElementById("listCustomers").innerHTML += "<br />";
                            $.each(values, function (key, value) {
//                               alert( key + ": " + value);
                                document.getElementById("listCustomers").innerHTML += key + ": " + value + "<br />";
                            });
                            document.getElementById("listCustomers").innerHTML += "<br />";
                        });

//                        $("#listItems").text("List of Items:");
//                        listItems();
                    },
                    error: function (err) {
                        alert("Error: " + err.responseText);
                    }
                });

                $.ajax({
                    url: "${g.createLink(controller:'items',action:'updateMiniDashItems')}",
                    type: "get",
                    dataType: 'json',
                    success: function (data) {
                        console.log(data);
                        $("#listItems").text("List of Items:");
                        listItems();
//                        alert(data);
                        $.each(data, function (index, values) {
//                            alert( index + ": " + values);
                            document.getElementById("listItems").innerHTML += "<br />";
                            $.each(values, function (key, value) {
//                               alert( key + ": " + value);
                                document.getElementById("listItems").innerHTML += key + ": " + value + "<br />";
                            });
                        });
//                        alert($.parseJSON(data));
//                        document.getElementById("listItems").innerHTML = $.parseJSON(JSON.stringify(data)).each(function () {
//                           alert(this.desc);
//                        });
                        //for (item in data) { document.write(data[item].desc + "<br />"); };
                            %{--<g:each var="item" in="${data)}">${item.catNum}, ${item.desc}, ${item.price}</g:each>;--}%
                    },
                    error: function (err) {
                        alert("Error: " + err.responseText);
                    }
                });

                $.ajax({
                    url: "${createLink(controller:'orders',action:'updateMiniDashOrders')}",
                    type: "get",
                    dataType: 'json',
                    success: function(data) {
                        console.log(data);
                        $("#listOrders").text("List of Orders:");
//                        listOrders();

//                    $("#listCustomers").text("List of Customers:");
//                    listCustomers();

                        $.each(data, function (index, values) {
//                            alert( index + ": " + values);
                            document.getElementById("listOrders").innerHTML += "<br />";
                            $.each(values, function (key, value) {
//                               alert( key + ": " + value);
                                document.getElementById("listOrders").innerHTML += key + ": " + value + "<br />";
                            });
                            document.getElementById("listOrders").innerHTML += "<br />";
                        });

//                        $("#listItems").text("List of Items:");
//                        listItems();
                    },
                    error: function (err) {
                        alert("Error: " + err.responseText);
                    }
                });
            });



            //            $(function() {
            //                $('div[onload]').trigger('onload');
            //            });

            loadMiniDash();
        </script>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4">

                <div id="status" role="complementary">

                    <div id="application-status" class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">Application Status</h2>
                        </div>
                        <div class="panel-body">
                            <dl class="dl-horizontal">
                                <dt>Environment:</dt>
                                <dd>${grails.util.Environment.current.name}</dd>
                                <dt>App profile:</dt>
                                <dd>${grailsApplication.config.grails?.profile}</dd>
                                <dt>App version:</dt>
                                <dd><g:meta name="info.app.version"/></dd>
                                <dt>Grails version:</dt>
                                <dd><g:meta name="info.app.grailsVersion"/></dd>
                                <dt>Groovy version:</dt>
                                <dd>${GroovySystem.getVersion()}</dd>
                                <dt>JVM version:</dt>
                                <dd>${System.getProperty('java.version')}</dd>
                                <dt>Reloading active:</dt>
                                <dd>${grails.util.Environment.reloadingAgentEnabled}</dd>
                            </dl>
                        </div>
                    </div>

                    <div id="artefacts" class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">Artefacts</h2>
                        </div>
                        <div class="panel-body">
                            <dl class="dl-horizontal">
                                <dt>Controllers:</dt>
                                <dd>${grailsApplication.controllerClasses.size()}</dd>
                                <dt>Domains:</dt>
                                <dd>${grailsApplication.domainClasses.size()}</dd>
                                <dt>Services:</dt>
                                <dd>${grailsApplication.serviceClasses.size()}</dd>
                                <dt>Tag Libraries:</dt>
                                <dd>${grailsApplication.tagLibClasses.size()}</dd>
                            </dl>
                        </div>
                    </div>

                    <div id="installed-plugins" class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">Installed Plugins</h2>
                        </div>
                        <div class="panel-body">
                            <dl class="dl-horizontal">
                                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                                    <dt>${plugin.name}:</dt>
                                    <dd>${plugin.version}</dd>
                                </g:each>
                            </dl>
                        </div>
                    </div>

                </div>
            </div>

            <div class="col-md-8">
                <div id="page-body" role="main">
                    <div id="controller-list" role="navigation" class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">Welcome to Grails Shell</h2>
                        </div>
                        <div class="panel-body">
                            <p>Congratulations, you have successfully started your first Grails application! At the moment, this is the default page (Check out the <code>UrlMappings</code> class to see why). Feel free to modify it to either redirect to a controller or display whatever content you may choose. Below is a list of controllers that are currently deployed in this application, click on each to execute its default action:</p>
                            <g:if test="${grailsApplication.controllerClasses.size() > 0}">
                                <ul>
                                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                                        <li class="controller"><g:link controller="${c.logicalPropertyName}">${message(code: c.propertyName.minus('Controller') + '.label')}</g:link></li>
                                    </g:each>
                                </ul>
                            </g:if>
                            <g:else>
                                <p><em>There aren't any controllers yet.</em></p>
                            </g:else>
                        </div>
                    </div>
                </div>

                <div id="mini-dash" class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">Mini Dashboard</h2>
                    </div>
                    <div class="panel-body">
                        %{--List of Orders:<br />--}%
                        <div id="listOrders"></div>
                        %{--List of Customers:<br />--}%
                        <div id="listCustomers"></div>
                        <div id="listItems"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
