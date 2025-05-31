<#import "layout.ftlh" as main>
<@main.layout ; spring>

<#--    <div class="row card justify-content-center" >-->
<#--        <form action="/flights/" method="get">-->
<#--            <div class="col-3">-->
<#--                <div class="input-group mb-3">-->
<#--                    <span class="input-group-text" id="inputGroup-sizing-default">Departure</span>-->
<#--                    <input name="departure" type="text" class="form-control">-->
<#--                </div>-->
<#--            </div>-->
<#--            <div class="col-3">-->
<#--                <div class="input-group mb-3">-->
<#--                    <span class="input-group-text" id="inputGroup-sizing-default">Destination</span>-->
<#--                    <input name="destination"  type="text" class="form-control">-->
<#--                </div>-->
<#--            </div>-->
<#--            <div class="col-3">-->
<#--                <div class="input-group mb-3">-->
<#--                    <span class="input-group-text" id="inputGroup-sizing-default">When?</span>-->
<#--                    <input name="date"  type="date" class="form-control">-->
<#--                </div>-->
<#--            </div>-->
<#--            <div class="col-3">-->
<#--                <button type="submit" class="btn btn-primary">Search</button>-->
<#--            </div>-->
<#--        </form>-->
<#--    </div>-->

    <#if flights??>
            <#list flights as flight>
                <div class="card w-100 mb-3 overflow-hidden list-group-item" >
                    <div class="card-body">
                        <p class="card-text fs-3">from ${flight.cityDeparture} to ${flight.cityArrival}</p>
                        <div class="card-text">deporture on ${flight.dateTimeDeparture} arrives on ${flight.dateTimeArrival}</div>
                        <p class="card-text">Bisnes price - ${flight.bissnessPrice!"undefined"}</p>
                        <p class="card-text">Econom price - ${flight.economyPrice!"undefined"}</p>
                        <form class="confirm-form" data-id="${flight.id}" action="/flights/buy" method="post">
                            <div class="card">
                                <div class="card-body">

                                </div>
                            </div>
                            <button type="submit" class="btn btn-outline-info">Confirm</button>
                        </form>
                    </div>
                </div>
            </#list>
    </#if>

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

</@main.layout>