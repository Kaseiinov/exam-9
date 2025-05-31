package kg.attractor.exam9.service.impl;

import kg.attractor.exam9.dto.CompanyDto;
import kg.attractor.exam9.models.Company;
import kg.attractor.exam9.repository.CompanyRepository;
import kg.attractor.exam9.service.CompanyService;
import kg.attractor.exam9.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final FileUtil fileUtil;

    @Override
    public void save(CompanyDto companyDto){
        String fileName = fileUtil.saveUploadFile(companyDto.getFile(), "/company");

        Company company = new Company();
        company.setName(companyDto.getName());
        company.setId(companyDto.getId());
        company.setEmail(companyDto.getEmail());
        company.setPassword(companyDto.getPassword());
        company.setEnable(Boolean.TRUE);
        company.setAvatar(fileName);

        companyRepository.save(company);
    }

}
