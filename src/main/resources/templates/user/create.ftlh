<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <style>

        h2 {
            color: red;
            text-align: center;
            margin-bottom: 30px;
        }
    </style>


    <form action="/admin/createCompany" method="post" enctype="multipart/form-data">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>


        <div class="mb-3">
            <label class="form-label">Email</label>
            <@spring.formInput "companyDto.email" 'class="form-control form-control-lg"' />
            <@spring.showErrors "<br>" "error text-danger" />
        </div>

        <div class="mb-3">
            <label class="form-label">Password</label>
            <@spring.formInput "companyDto.password" 'class="form-control form-control-lg"' />
            <@spring.showErrors "<br>" "error text-danger" />
        </div>

        <div class="mb-3">
            <label class="form-label">Name</label>
            <@spring.formInput "companyDto.name" 'class="form-control form-control-lg"' />
            <@spring.showErrors "<br>" "error text-danger" />
        </div>


        <div class="mb-3">
            <label for="formFileMultiple" class="form-label">Avatar</label>
            <input name="file" class="form-control" type="file" id="formFileMultiple">
        </div>

        <button type="submit" class="btn btn-success w-100 mb-3">save</button>
    </form>
</@main.layout>