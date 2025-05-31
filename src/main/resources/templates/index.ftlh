<#import "layout.ftlh" as main>
<@main.layout ; spring>

    <input type="text" class="form-control p-2 mb-2" placeholder="From" id="departure-input">
    <input type="text" class="form-control p-2 mb-2" placeholder="To" id="destination-input">
    <input type="date" class="form-control p-2 mb-4" placeholder="Date" id="date-input">

    <#if flights??>
        <div id="flightsList">
            <#list flights as flight>
                <div class="card w-100 mb-3 overflow-hidden list-group-item mb-3" >
                    <div class="card-body">

                        <#if flight.company.avatar??>
                            <img src="/images/byName/${flight.company.avatar}" width="80" height="80" alt="avatar" class="me-3">
                        <#else>
                            <i class="fas fa-user-circle me-3 rounded" style="font-size: 80px; color: #6c757d;"></i>
                        </#if>
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
                        <button data-id="${flight.id}" type="button" class="buy-btn btn btn-outline-info" >But ticket</button>

                        <form class="confirm-form d-none" data-id="${flight.id}" action="/flights/buy" method="post">
                            <#if _csrf??>
                                <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                       value="${(_csrf.token)!'csrf-token'}" />
                            </#if>

                            <input type="hidden" name="flightId" value="${flight.id}">

                            <div class="card">
                                <div class="card-body">
                                    <p class="card-text">Business price - ${flight.bissnessPrice!"undefined"}</p>
                                    <p class="card-text">Economy price - ${flight.economyPrice!"undefined"}</p>

                                    <#if flight.bissnessTickets??>
                                        <p class="card-text">Choose a business ticket:</p>
                                        <#list flight.bissnessTickets as ticket>
                                            <div>
                                                <label>
                                                    <input type="radio" name="ticketId" value="${ticket.id}">
                                                    Business ticket, Place: ${ticket.place}
                                                </label>
                                            </div>
                                        </#list>
                                    </#if>

                                    <#if flight.economTickets??>
                                        <p class="card-text">Choose an economy ticket:</p>
                                        <#list flight.economTickets as ticket>
                                            <div>
                                                <label>
                                                    <input type="radio" name="ticketId" value="${ticket.id}">
                                                    Economy ticket, Place: ${ticket.place}
                                                </label>
                                            </div>
                                        </#list>
                                    </#if>

                                    <button type="submit" class="btn btn-outline-info">Buy selected ticket</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </#list>
        </div>

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