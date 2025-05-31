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
                <div class="card w-100 mb-3 overflow-hidden list-group-item mb-3" >
                    <div class="card-body">
                        <p class="card-text fs-3">from ${flight.cityDeparture} to ${flight.cityArrival}</p>
                        <div class="card-text">deporture on ${flight.dateTimeDeparture} arrives on ${flight.dateTimeArrival}</div>
                        <p class="card-text">Bisnes price - ${flight.bissnessPrice!"undefined"}</p>
                        <p class="card-text">Econom price - ${flight.economyPrice!"undefined"}</p>
                        <button data-id="${flight.id}" type="button" class="buy-btn btn btn-outline-info" >But ticket</button>

                        <form class="confirm-form d-none" data-id="${flight.id}" action="/flights/buy" method="post">
                            <div class="card">
                                <div class="card-body">
                                    <p class="card-text">Bisnes price - ${flight.bissnessPrice!"undefined"}</p>
                                    <p class="card-text">Econom price - ${flight.economyPrice!"undefined"}</p>
                                    <#if flight.bissnessTickets??>
                                        <p class="card-text">Places for bissness <#list flight.bissnessTickets as ticket>
                                                 ${ticket.place}
                                            </#list></p>
                                        <button type="submit" class="btn btn-outline-info">Buy bissness</button>
                                    </#if>
                                    <#if flight.economTickets??>
                                        <p class="card-text">Places for economy <#list flight.economTickets as ticket>
                                                ${ticket.place}
                                            </#list></p>
                                        <button type="submit" class="btn btn-outline-info">Buy econom</button>
                                    </#if>

                                </div>
                            </div>

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

    <script src="../static/main.js"></script>

</@main.layout>