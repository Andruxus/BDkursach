package org.example.services;

import org.example.dao.ContractDAO;
import org.example.models.Contract;

import java.util.List;

public class ContractService {
    private ContractDAO contractDAO = new ContractDAO();

    public ContractService() {
    }

    public Contract findClient(int id) {
        return contractDAO.findById(id);
    }

    public void saveClient(Contract contract) {
        contractDAO.save(contract);
    }

    public void deleteClient(Contract contract) {
        contractDAO.delete(contract);
    }

    public void updateClient(Contract contract) {
        contractDAO.update(contract);
    }

    public List<Contract> findAllUsers() {
        return contractDAO.findAll();
    }


}
