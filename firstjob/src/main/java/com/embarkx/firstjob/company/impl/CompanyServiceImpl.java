package com.embarkx.firstjob.company.impl;

import com.embarkx.firstjob.company.Company;
import com.embarkx.firstjob.company.CompanyRepository;
import com.embarkx.firstjob.company.CompanyService;
import com.embarkx.firstjob.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//this convey message that need to use this class as the service.
@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

//    this is managed by spring
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

//    this method is going to return all the instance of company that we are going to return.
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany,Long id) {
        Optional<Company> companyOptional   =companyRepository.findById(id);
        if(companyOptional.isPresent()){

            Company company=companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {

        if(companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
