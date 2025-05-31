<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <body class="bg-light">

        <div class="text-center mb-4">
            <h2 style="color: red;">
                Personal profile
                <#if user.roleName == "ADMIN">
                    Admin
                <#elseif user.roleName == "USER">
                    User
                <#elseif user.roleName == "COMPANY">
                    Company
                </#if>
            </h2>
        </div>

        <div class="d-flex align-items-center justify-content-between mb-4">
            <div class="d-flex align-items-center">

                <div>
                    <h3>${user.email}</h3>
                    <p class="text">${user.firstName} ${user.lastName}</p>
<#--                    <a href="/users/edit/${user.email}" class="btn btn-outline-success btn-sm mt-2"><@spring.message "auth.profile.edit" /></a>-->
                </div>
            </div>

        </div>
        <#if user.roleName == "USER"><p class="text-center">History of orders</p></#if>
        <#if user.roleName == "COMPANY"><p class="text-center">List of flights</p></#if>>

        <div class="row">
            <#if user.roleName == "USER">
                <div class="col-4">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
            </#if>

            <#if user.roleName == "COMPANY">
                <div class="col-4">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                            <p class="card-text">sldfkskdfslkjfs</p>
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
            </#if>
        </div>

    </body>

    </@main.layout>
