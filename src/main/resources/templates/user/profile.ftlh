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
        <#if user.roleName == "COMPANY"><p class="text-center">List of flights</p></#if>

        <div class="row">
            <#if user.roleName == "USER">
                <#if flights??>
                    <div id="flightsList">
                        <#list flights as flight>
                            <div class="card w-100 mb-3 overflow-hidden list-group-item mb-3" >
                                <div class="card-body">
                                    <#if flight.company.name??>
                                        <p class="card-text fs-2">Company ${flight.company.name!'undefined'}</p>
                                    </#if>

                                    <p class="card-text fs-3">
                                        from <span class="departure-city">${flight.cityDeparture}</span>
                                        to <span class="destination-city">${flight.cityArrival}</span>
                                    </p>

                                    <!-- Добавьте класс к дате -->
                                    <div class="card-text">
                                        deporture on <span class="departure-date">${flight.dateTimeDeparture}</span>
                                        arrives on ${flight.dateTimeArrival}
                                    </div>

                                    <p class="card-text">Bisnes price - ${flight.bissnessPrice!"undefined"}</p>
                                    <p class="card-text">Econom price - ${flight.economyPrice!"undefined"}</p>

                                </div>
                            </div>
                        </#list>
                    </div>

                </#if>
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

        <nav >
            <div class="d-flex justify-content-center">
                <ul class="pagination">
                    <#if hasPrevious>
                        <li class="page-item ">
                            <a class="page-link" href="/?page=${currentPage - 1}" >previous</a>
                        </li>
                    <#else>
                        <li class="page-item disabled">
                            <a class="page-link" href="/?page=${currentPage - 1}" >previous</a>
                        </li>
                    </#if>
                    <#list 0..(totalPages - 1) as page>
                        <li class="page-item <#if page == currentPage>active</#if>">
                            <a class="page-link" href="/?page=${page}">${page + 1}</a>
                        </li>
                    </#list>
                    <#if hasNext>
                        <li class="page-item">
                            <a class="page-link" href="/?page=${currentPage + 1}">next</a>
                        </li>
                    <#else>
                        <li class="page-item disabled">
                            <a class="page-link" href="/?page=${currentPage + 1}">next</a>
                        </li>
                    </#if>

                </ul>
            </div>
        </nav>

    </body>

    </@main.layout>
