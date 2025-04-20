package com.embarkx.firstjob.company;

import java.util.*;

public interface CompanyService {

    public List<Company> getAllCompanies();
    boolean updateCompany(Company company,Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);

}
